package com.missionbit.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.missionbit.MyGdxGame;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.DEBUG;

public class PlayState extends States {
    public World world;
    public Texture camera;

    private TiledMapRenderer tiledMapRenderer;
    private TiledMap tiledMap;

    Body groundBody;
    BodyDef groundDef;
    PolygonShape groundShape;


    public PlayState(final MyGdxGame game) {
        super(game);

        groundDef = new BodyDef();
        groundShape = new PolygonShape();

        Array<Body> grounds = new Array<Body>();
        int counter = 0;
        for (PolygonMapObject obj : tiledMap.getLayers().get("Collision").getObjects().getByType(PolygonMapObject.class)) {
            groundDef.position.set(obj.getPolygon().getX() * States.PTM, obj.getPolygon().getY() * States.PTM);
            grounds.add(world.createBody(groundDef));
            float[] vertices = obj.getPolygon().getVertices();
            for (int i = 0; i < vertices.length; i++) {
                vertices[i] = vertices[i] * States.PTM;
            }
            groundShape.set(vertices);
            grounds.get(counter).createFixture(groundShape, 0.0f);
            counter++;
        }

    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void update(float dt) {
        if (Gdx.input.justTouched()) {
            game.setScreen(new InGame(game));
            dispose();
        }
        world.step(1/60f, 6, 2); //Last Thing in this list
    }

    @Override
    public void drawGame(String s) {

    }

    @Override
    public void drawGame() {
        game.batch.begin();
        game.font.draw(batch, this.getClass().toString(), 0, MyGdxGame.HEIGHT);
        game.batch.end();

        if (DEBUG) {
            ShapeRenderer sr = new ShapeRenderer();
            sr.begin(ShapeRenderer.ShapeType.Line);
            sr.setColor(Color.RED);
            sr.end();
        }
    }
}






