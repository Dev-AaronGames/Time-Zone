//package com.missionbit.Objects;
//
//import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Graphics;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.missionbit.States.Play;
//import com.missionbit.States.PlayState;
//
//import org.w3c.dom.css.Rect;
//
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//
//public abstract class Entiny {
//    protected double x, y;
//    protected Texture texture;
//    protected TiledMap tiledMap;
//
//    public Entiny (Texture texture, double x, double y, TiledMap tiledMap) {
//        this.texture = texture;
//        this.y = y;
//        this.x = x;
//        this.tiledMap = tiledMap;
//        tiledMap.addEntiny(this);
//    }
//
//    public abstract void tick();
//
//    public void render(Graphics2D g) {
//        texture.render(g, x, y);
//    }
//    public Rectangle getBounds() {
//        return new Rectangle((int) x + 6, (int) y, texture.getWidth(), texture.getHeight());
//    }
//    public Rectangle getTop() {
//        return new Rectangle((int) x + 6, (int) y, texture.getWidth() - 6, 4);
//    }
//    public Rectangle getBottom() {
//        return new Rectangle((int) x +6, (int) y, texture.getHeight() - 4, 4);
//    }
//    public Rectangle getRight() {
//        return new Rectangle((int) x + texture.getWidth() -4, (int) y +6, 4, texture.getHeight() -6);
//    }
//    public Rectangle getLeft() {
//        return new Rectangle((int) x, (int) y + 6, 4, texture.getHeight() - 6);
//    }
//}
