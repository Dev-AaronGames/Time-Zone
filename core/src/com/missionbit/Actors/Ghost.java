package com.missionbit.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.missionbit.States.InGame;

public class Ghost extends Character {
    Texture img;
    public Object Ghost;


    public Ghost(int x, int y, InGame game) {
        super(50, 100, game);
        Ghost = new Texture("Ghost.png");
        playerBody.setFixedRotation(false);
        playerBody.applyLinearImpulse(new Vector2(5, 0), position, true);

        moveSpeed = 150;
        jumpHeight = 300;
        numJumps = 3;

        position = new Vector2(x, y);
        offset = new Vector2(100, 70);
        velocity = new Vector2(0, 0);

        bounds = new Rectangle(position.x + offset.x, position.y + offset.y, 56, 120);
        hitbox = new Rectangle(position.x  + offset.x, position.y + offset.y, 130, 150);
    }

    public void update(float dt) {

    }
}