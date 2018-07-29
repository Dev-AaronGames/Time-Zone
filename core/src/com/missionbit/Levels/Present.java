package com.missionbit.Levels;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.missionbit.States.PlayState;

public class Present extends PlayState{
    TiledMap tiledMap;

    public Present(Camera game) {
        super(game);
        tiledMap = new TmxMapLoader().load("Level2.xml");

        win = true;
    }
    //Winner of the Game - Complete

    //Present() {
        //System.out.println("Present.tmx");
    //}
}
