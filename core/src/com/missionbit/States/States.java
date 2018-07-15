package com.missionbit.States;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.missionbit.MyGdxGame;

public abstract class States implements Screen {
    final MyGdxGame game;
    public TiledMapRenderer mapRenderer;
    public OrthographicCamera camera;

    protected States(MyGdxGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

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
        game.batch.setProjectionMatrix(camera.combined);
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
