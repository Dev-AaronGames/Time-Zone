package com.missionbit.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.missionbit.Actors.Character;
import com.missionbit.MyGdxGame;
import com.missionbit.Objects.Controls;
import com.missionbit.Actors.Ghost;
import com.missionbit.Actors.Thug;

import static jdk.nashorn.internal.runtime.Context.DEBUG;

public class InGame extends States {
    private Character character;
    private Controls controller;

    private TiledMapRenderer tiledMapRenderer;
    private TiledMap tiledMap;
    public World world;
    private Box2DDebugRenderer debugRenderer;

    private BodyDef platformDef;
    PolygonShape platformShape;
    private Array<Body> platforms;
    private int counter = 0;
    private Ghost ghost;
    private Thug thug;

    public InGame(MyGdxGame game) {
        super(game);

        tiledMap = new TmxMapLoader().load("Level1.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        Box2D.init();
        world = new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();

        ghost = new Ghost(50, 100, this);
        thug = new Thug(100, 200, this);
        controller = new Controls(camera);

        tiledMap = new TmxMapLoader().load("Maps/Map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, States.PTM);

        platforms = new Array<Body>();

        platformDef = new BodyDef();
        platformShape = new PolygonShape();

        for (PolygonMapObject obj : tiledMap.getLayers().get("Platform").getObjects().getByType(PolygonMapObject.class)) {
            platformDef.position.set(obj.getPolygon().getX() * States.PTM, obj.getPolygon().getY() * States.PTM);
            platforms.add(world.createBody((platformDef)));
            float[] vertices = obj.getPolygon().getVertices();

            for (int i = 0; i < vertices.length; i++) {
                vertices[i] = vertices[i] * States.PTM;
            }

            platformShape.set(vertices);
            platforms.get(counter).createFixture(platformShape, 0.0f);
            counter++;
        }

    }

    public void handleInput() {
        if (controller.isLeftPressed()) {
            if (controller.isRightPressed()) {
                character.moveRight();
            } else {
                character.resetAnim();
            }
        } else {
            character.moveLeft();
        }

        if (controller.isJumpPressed()) {
        } else {
            character.jump();
        }

        if (controller.isAttackPressed()) {
        } else {
            character.attack();
        }
        for (int i = 0; i < 5; i++) {
            if (Gdx.input.isTouched(i)) {
                Vector3 touchPos = new Vector3(Gdx.input.getX(i), Gdx.input.getY(i), 0);
                camera.unproject(touchPos);
            }

        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        character.update(dt);
        if (character.getX() > MyGdxGame.WIDTH || character.getX() + character.getWidth() < 0) {
            game.setScreen(new PlayState(game));
            dispose();
        }
    }

    @Override
    public void drawGame(String s) {

    }

    @Override
    public void drawGame() {
        game.batch.setProjectionMatrix(camera.combined);
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        game.batch.begin();

        game.batch.draw(character.getTexture(), character.getX(), character.getY(), character.getTexture.getRegionWidth() * States.PTM, character.getTexture().getRegionHeight() * States.PTM);
        game.batch.end();

        debugRenderer.render(world, camera.combined);
        world.step(1 / 60f, 6, 2);

        font.draw(batch, this.getClass().toString(), 0, MyGdxGame.HEIGHT);
        batch.draw(character.getTexture(), character.getPosition().x, character.getPosition().y);
        controller.draw(batch);
        batch.end();

        if (DEBUG){
            ShapeRenderer sr = new ShapeRenderer();
            sr.begin(ShapeRenderer.ShapeType.Line);
            sr.setColor(Color.RED);
            controller.drawDebug(sr);
            character.drawDebug(sr);
            sr.end();

        }
    }

    @Override
    public void render(float delta) {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        super.render(delta);

    }

    public void dispose() {
        super.dispose();
        character.dispose();
        debugRenderer.dispose();
        game.dispose();
    }
}

