package com.missionbit.Levels;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.missionbit.States.PlayState;

public class Level6 extends PlayState {
    TiledMap tiledMap;

    public Level6(Camera gameCamera) {
        super(gameCamera);
        tiledMap = new TmxMapLoader().load("Level6.xml");

        if (win == true) {
            tiledMap = new TmxMapLoader().load("Maps/Level7.xml");
        } else if (lose == true) {
            tiledMap = new TmxMapLoader().load("Maps/Lose.xml");
        }
    }


    @Override
    public void drawGame() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void drawGame(String s) {

    }
}
