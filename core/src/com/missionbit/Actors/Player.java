package com.missionbit.Actors;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Player {

    private Animation an;
    boolean atkIsActive;
    Rectangle hurtbox;
    Rectangle hitbox;
    Vector2 position;
    private Vector2 velocity;
    private static final int GRAVITY = -15;
private boolean faceRight,isAttacking;
    private int numJumps;

    Texture img;

    public Player(int hp, int x, int y) {
        this.hp = 100;


        velocity = new Vector2();
        img = new Texture("Ghost.png");
        hitbox = new Rectangle();
        position = new Vector2(x, y);
        hurtbox = new Rectangle();
        hitbox.set(x, y, img.getWidth(), img.getHeight());
        an = new Animation(new TextureRegion(img), 50, 7f, 5, 10);
faceRight = true;
isAttacking = true;


    }

    public void jump() {
        velocity.y = 500;
    }

    public void resetAnim() {
velocity.x = 0;
    }

    public void moveLeft() {
        velocity.x = -150;
       faceRight = false;
    }

    public void moveRight() {
        velocity.x = 72;
        faceRight = true;
    }


    public void update(float dt) {

//        if ( hp= 0)
//            System.out.println("");
        if (position.y > 0 ){
            velocity.add(0, GRAVITY);
        }
        an.update(dt);

        velocity.scl(dt);
        position.add(velocity);
        velocity.scl(1 / dt);
        if (position.y < 0) {
            position.y = 0;


}



    }

    int hp;


    public void draw(SpriteBatch batch) {


        batch.draw(an.getFrame(), position.x, position.y);
    }


}


