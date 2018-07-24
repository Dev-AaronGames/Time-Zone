package com.missionbit.Levels;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.missionbit.MyGdxGame;
import com.missionbit.States.States;

public class Level2 extends States {
    TiledMap tiledMap;

    protected Level2(MyGdxGame game) {
        super(game);
        tiledMap = new TmxMapLoader().load("Level1.tmx");
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void drawGame() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

//Solution = Offer Edward III different opportunity to stop their invasion of France.or by force - Complete
    private class EdwardIII {

    }
}
