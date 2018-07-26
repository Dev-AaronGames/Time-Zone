package com.missionbit.Levels;

import com.badlogic.gdx.graphics.Texture;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import static com.missionbit.MyGdxGame.HEIGHT;
import static com.missionbit.MyGdxGame.WIDTH;
import static java.lang.ref.FinalizerReference.add;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Level1 extends PlayState {
    TiledMap tiledMap;
    private Texture background;
    boolean win = false;

    JPanel jp = new JPanel();
    JButton jb = new JButton();
    private int defaultCloseOperation;

    public Level1(MyGdxGame gameCamera, Texture background) {
        super(gameCamera);
        this.background = background;
        tiledMap = new TmxMapLoader().load("Maps/Level1.xml");
        JOptionPane.showMessageDialog(null, "Defeat the Monsters and get to the \n HUNDRED YEAR WAR", "MONGOL CONQUEST", JOptionPane.INFORMATION_MESSAGE);

        if (win == true) {
            tiledMap = new TmxMapLoader().load("Maps/Level2.xml");
        } else if (lose == true) {
            tiledMap = new TmxMapLoader().load("Maps/Lose.xml");
        }


//        jb.setVisible(true);
//        jb.setSize(400, 200);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        jb.setIcon(new ImageIcon("C:\\Users\\NUZHAT\\Desktop\\Projects\\Time-Zone\\android\\assets\\GameVortex.png"));
//        jp.add(jb);
//        jb.add(jp);
//
//        jb.validate();
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

    protected Level1(MyGdxGame game) {
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

    public void setDefaultCloseOperation(int defaultCloseOperation) {
        this.defaultCloseOperation = defaultCloseOperation;
    }
}
