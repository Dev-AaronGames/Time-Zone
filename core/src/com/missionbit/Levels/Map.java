package com.missionbit.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

//Complete

public class Map {
    public String[] Level = {"MONGOL CONQUEST", "HUNDRED YEAR WAR", "AMERICAN REVOLUTIONARY WAR", "NAPOLEONIC WARS", "AMERICAN CIVIL WAR", "WORLD WAR I", "WORLD WAR II"};
    protected Sprite LeftButton;
    protected Sprite RightButton;
    protected int page = 0;

    public Map(Camera gameCamera) {
        RightButton = new Sprite(new Texture(Gdx.files.internal("images/RightButton.png")));
        RightButton.setPosition(540, 200);
        LeftButton = new Sprite(new Texture(Gdx.files.internal("images/LeftButton.png")));
        LeftButton.setPosition(40, 200);
    }
}