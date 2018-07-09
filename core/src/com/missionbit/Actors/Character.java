package com.missionbit.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Character {

    private Animation an;
    boolean atkIsActive;
    Rectangle hurtbox;
    Rectangle hitbox;
    Vector2 position;;

Texture img;

    public Character(int hp, int x, int y) {
        this.hp = 100;


        img = new Texture("Ghost.png");
        hitbox = new Rectangle();
        position = new Vector2(x, y);
        hurtbox = new Rectangle();
        hitbox.set(x, y, img.getWidth(), img.getHeight());
     an = new Animation(new TextureRegion(img),50, 7f,5,10);
    }




    public void update(){

//        if ( hp= 0)
            System.out.println("GAME OVER");


    }

    int hp;


    public void draw(SpriteBatch batch){


        batch.draw(img, position.x, position.y);
    }









    }


