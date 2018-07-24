package com.missionbit.Levels;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.missionbit.MyGdxGame;
import com.missionbit.States.States;

import static com.missionbit.MyGdxGame.HEIGHT;
import static com.missionbit.MyGdxGame.WIDTH;

public class Level3 extends States {
    TiledMap tiledMap;

    public Level3(Camera gameCamera) {
        super(gameCamera);
    }

//    if (lose == true) {
//
//    } else if (win == true)


    @Override
    protected void drawGame() {

    }

    protected Level3(MyGdxGame game) {
        super(game);
        tiledMap = new TmxMapLoader().load("Level3.tmx");
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


