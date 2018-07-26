package com.missionbit.Levels;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.missionbit.States.PlayState;
import com.missionbit.States.States;

public class Level7 extends PlayState {
    TiledMap tiledMap;

    public Level7(Camera gameCamera) {
        super(gameCamera);
        tiledMap = new TmxMapLoader().load("Level7.xml");

        if (win == true) {
            tiledMap = new TmxMapLoader().load("Maps/Present.xml");
        } else if (lose == true) {
            tiledMap = new TmxMapLoader().load("Maps/Lose.xml");
        }
    }

    @Override
    public void drawGame() {

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

        groundShape = new PolygonShape();

        for (PolygonMapObject obj : tiledMap.getLayers().get("Killer").getObjects().getByType(PolygonMapObject.class)) {
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
    public void update(float dt) {

    }

    @Override
    public void drawGame(String s) {

    }

    //Solution: Prevent Hitler from rising to power. -Complete
    private class Hitler { //Thug = Thug & Gang

    }
}
