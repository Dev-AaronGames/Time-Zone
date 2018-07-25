package com.missionbit.Levels;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.missionbit.States.PlayState;

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
