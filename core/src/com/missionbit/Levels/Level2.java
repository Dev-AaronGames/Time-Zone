package com.missionbit.Levels;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.missionbit.MyGdxGame;
import com.missionbit.States.PlayState;
import com.missionbit.States.States;

import javax.swing.JOptionPane;

import static com.missionbit.MyGdxGame.HEIGHT;
import static com.missionbit.MyGdxGame.WIDTH;

public class Level2 extends PlayState {
    TiledMap tiledMap;

    public Level2(Camera gameCamera) {
        super(gameCamera);
        tiledMap = new TmxMapLoader().load("Level2.xml");
        JOptionPane.showMessageDialog(null, "Defeat the Monsters and get to the \n AMERICAN REVOLUTIONARY WAR", "HUNDRED YEAR WAR", JOptionPane.INFORMATION_MESSAGE);

        if (win == true) {
            tiledMap = new TmxMapLoader().load("Maps/Level3.xml");
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


    }

    protected Level2(MyGdxGame game) {
        super(game);
        tiledMap = new TmxMapLoader().load("Level1.tmx");
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void drawGame(String s) {
        int width = getWidth();
        int height = getHeight();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
    public void render (SpriteBatch sb) {
        //super.render(null);
        sb.begin();
        sb.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(playBtn, (MyGdxGame.WIDTH / 2) - (playBtn.getWidth() / 2), MyGdxGame.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
        playBtn.dispose();
    }

    public int getWidth() {
        return WIDTH;
    }
    public int getHeight() {
        return HEIGHT;
    }
}


