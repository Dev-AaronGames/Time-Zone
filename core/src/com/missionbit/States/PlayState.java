package com.missionbit.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.missionbit.Actors.Controller;
import com.missionbit.Actors.Player;
import com.missionbit.MyGdxGame;

public class PlayState extends States {
    public World world;

    private Controller controller;    private TiledMapRenderer tiledMapRenderer;
    private TiledMap tiledMap;
    Player ghost;
    Body groundBody;
    BodyDef groundDef;
    PolygonShape groundShape;


    public PlayState(final MyGdxGame game) {
        super(game);
        ghost = new Player(100,100,100);
        controller = new Controller(camera);
        groundDef = new BodyDef();
//        groundShape = new PolygonShape();

        Array<Body> grounds = new Array<Body>();
        int counter = 0;
//        for (PolygonMapObject obj : tiledMap.getLayers().get("Collision").getObjects().getByType(PolygonMapObject.class)) {
//            groundDef.position.set(obj.getPolygon().getX() * States.PTM, obj.getPolygon().getY() * States.PTM);
//            grounds.add(world.createBody(groundDef));
//            float[] vertices = obj.getPolygon().getVertices();
//            for (int i = 0; i < vertices.length; i++) {
//                vertices[i] = vertices[i] * States.PTM;
//            }
//            groundShape.set(vertices);
//            grounds.get(counter).createFixture(groundShape, 0.0f);
//            counter++;
//        }

    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void update(float dt) {

        if (controller.isLeftPressed()){

            ghost.moveLeft();
        }else if(controller.isRightPressed()){

            ghost.moveRight();

        } else {
            ghost.resetAnim();

        }

        if (controller.isJumpPressed()){
            ghost.jump();
        }

        if (controller.isAttackPressed()){
            ghost.atack();
        }
        if (controller.isFirePressed()){
            ghost.fire();
        }

        ghost.update(Gdx.graphics.getDeltaTime());
//
//        if (Gdx.input.justTouched()) {
//            game.setScreen(new InGame(game));
//            dispose();
//        }
//        world.step(1/60f, 6, 2); //Last Thing in this list
    }

    @Override
    public void drawGame(String s) {

    }

    @Override
    public void drawGame() {


        game.batch.begin();
        batch.draw(
                ghost.getTexture(Gdx.graphics.getDeltaTime()),
                ghost.getPosition().x,
                ghost.getPosition().y,
                250,
                250);
        controller.draw(batch);

        game.batch.end();


        game.sr.begin(ShapeRenderer.ShapeType.Line);
        game.sr.setColor(Color.RED);

        controller.drawDebug(game.sr);
        game.sr.end();
    }
    }







