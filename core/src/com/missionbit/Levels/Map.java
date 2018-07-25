package com.missionbit.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.missionbit.MyGdxGame;
import com.missionbit.States.PlayState;

public class Map extends PlayState{
    public String[] level = {"MONGOL CONQUEST", "HUNDRED YEAR WAR", "AMERICAN REVOLUTIONARY WAR", "NAPOLEONIC WARS", "AMERICAN CIVIL WAR", "WORLD WAR I", "WORLD WAR II"};
    protected Sprite LeftButton;
    protected Sprite RightButton;
    protected int page = 0;
    public Texture img;
    public Map map;
    public MapLayer layer;
    public Object object;

    TiledMap tiledMap;

    public Map(Camera gameCamera, MyGdxGame game) {
        super(game);
        this.game = game;
        RightButton = new Sprite(new Texture(Gdx.files.internal("images/RightButton.png")));
        RightButton.setPosition(540, 200);
        LeftButton = new Sprite(new Texture(Gdx.files.internal("images/LeftButton.png")));
        LeftButton.setPosition(40, 200);
    }



    public Map(MyGdxGame game) {
        super(game);
        tiledMap = new TmxMapLoader().load("Map.xml");
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