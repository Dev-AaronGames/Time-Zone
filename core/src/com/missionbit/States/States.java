package com.missionbit.States;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.missionbit.Actors.Controller;
import com.missionbit.Actors.Player;
import com.missionbit.MyGdxGame;

public abstract class States implements Screen {
    final MyGdxGame game;
    public TiledMapRenderer mapRenderer;
    public OrthographicCamera camera;
    private Controller controller;



    SpriteBatch batch;
    Texture img;
    Player ghost;
    ShapeRenderer sr;
    Texture Background;

    protected States(MyGdxGame game) {
        this.game = game;
        sr = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
        controller = new Controller(camera);
        batch = new SpriteBatch();
        ghost = new Player(100,100,500);
        System.out.println("Hello World!!!! - Make sure to update every time you make/complete a task.");

    }

    public abstract void update(float dt);
    public abstract void drawGame();

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        drawGame();
        batch.setProjectionMatrix(camera.combined);
        camera.update();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
