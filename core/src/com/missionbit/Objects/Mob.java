//package com.missionbit.Objects;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.missionbit.Actors.Animation;
//import com.missionbit.States.States;
//
//import java.awt.Graphics2D;
//
//public abstract class Mob extends Entiny {
//
//    protected double dx, dy;
//    protected double maxDY;
//    protected double gravity;
//    protected boolean falling;
//    protected boolean canJump;
//    protected boolean moving;
//    protected Animation anime;
//
//    public Mob() {
//        super(texture, x, y, tiledMap);
//        this.anime = anime;
//        falling = true;
//        gravity = 0.5;
//        maxDY = 7;
//    }
//
//    @Override
//    public void tick() {
//        move();
//        fall();
//        if (dx != 0) moving = true;
//        else moving = false;
////        if(moving) anime<run>
//    }
//
//    @Override
//    public void render(Graphics2D g) {
//        if (!moving)
//            super.render(g);
////        else anime.render(g, x, y);
//    }
//
//    protected void fall() {
//        if (falling) {
//            dy += gravity;
//            if (dy > maxDY) dy = maxDY;
//        }
//    }
//
//    protected void jump(double jumpHeight) {
//        if (canJump) {
//            dy -= jumpHeight;
//            canJump = false;
//        }
//    }
//}
//
