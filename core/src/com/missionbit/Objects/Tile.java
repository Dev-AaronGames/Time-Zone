//package com.missionbit.Objects;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class Tile {
//    private static final Texture terrain = new Texture("landscape.png");
//    private static final Map<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
//    protected int x, y;
//    protected Texture sprite;
//    protected boolean solid;
//    protected int id;
//
//    public static final Tile tile1 = new Tile(0xFFFFFFFF,new Texture(terrain, 1, 1, 32));
//    public static final Tile tile2 = new Tile(0xFFFF0000,new Texture(terrain, 1, 2, 32));
//
//    private Tile getFromID(int id, Texture sprite) {
//        this.id = id;
//        this.sprite = sprite;
//        tileMap.put(id, this);
//        return null;
//    }
//
//    public Tile(int id, int x, int y) {
//        this.sprite = getFromID(id).sprite;
//        this.x = x * sprite.getWidth();
//        this.y = y * sprite.getHeight();
//        this.solid = true;
//    }
//
//    private Tile getFromID(int id) {
//        return null;
//    }
//
//}
