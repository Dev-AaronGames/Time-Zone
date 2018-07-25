package com.missionbit.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.missionbit.Actors.Ghost;
import com.missionbit.Actors.Player;
import com.missionbit.MyGdxGame;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.EventQueue;
import net.java.games.input.Rumbler;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.DEBUG;

public class PlayState extends States {
    public World world;
    public OrthographicCamera camera;
    private Controller controller;
    private TiledMapRenderer tiledMapRenderer;
    private TiledMap tiledMap;
    //    Ghost ghost;
    Player ghost;
    Body groundBody;
    BodyDef groundDef;
    PolygonShape groundShape;


    public PlayState(final Camera game) {
        super(game);

        ghost = new Player(100, 100, 100);
        controller = new Controller(camera) {
                @Override
            public Controller[] getControllers() {
                return new Controller[0];
            }

            @Override
            public Type getType() {
                return null;
            }

            @Override
            public Component[] getComponents() {
                return new Component[0];
            }

            @Override
            public Component getComponent(Component.Identifier identifier) {
                return null;
            }

            @Override
            public Rumbler[] getRumblers() {
                return new Rumbler[0];
            }

            @Override
            public boolean poll() {
                return false;
            }

            @Override
            public void setEventQueueSize(int i) {

            }

            @Override
            public EventQueue getEventQueue() {
                return null;
            }

            @Override
            public PortType getPortType() {
                return null;
            }

            @Override
            public int getPortNumber() {
                return 0;
            }

            @Override
            public String getName() {
                return null;
            }
            };
            groundDef = new BodyDef();
            
        groundDef = new BodyDef();
        groundShape = new PolygonShape();

            Array<Body> grounds = new Array<Body>();
            int counter = 0;

        }

        public PlayState(MyGdxGame game) {

        }

        @Override
        public void render(float delta) {
            super.render(delta);
        }

        @Override
        public void update(float dt) {
            if (controller.isLeftPressed()) {

                ghost.moveLeft();
            } else if (controller.isRightPressed()) {

                ghost.moveRight();

            } else {
                ghost.resetAnim();

            }

            if (controller.isJumpPressed()) {
                ghost.jump();
            }

            if (controller.isAttackPressed()) {
                ghost.atack();
            }
            if (controller.isFirePressed()) {
                ghost.fire();
            }

            ghost.update(Gdx.graphics.getDeltaTime());
//
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
            batch.draw(ghost.getTexture(Gdx.graphics.getDeltaTime()), ghost.getPosition().x, ghost.getPosition().y, 250, 250);
            controller.draw(batch);
            game.batch.end();
            game.sr.begin(ShapeRenderer.ShapeType.Line);
            game.sr.setColor(Color.RED);


            game.sr.begin(ShapeRenderer.ShapeType.Line);
            game.sr.setColor(Color.RED);

            controller.drawDebug(game.sr);
            game.sr.end();
        }
    }







