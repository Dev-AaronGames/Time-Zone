//package com.missionbit.Objects;
//
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.badlogic.gdx.maps.tiled.TiledMapTile;
//import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
//import com.missionbit.Actors.Player;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.logging.Level;
//
//import javax.imageio.ImageIO;
//
//public class tileMap {
//
//    private static final int TILE_SIZE = 32;
//    private static final int TILE_SIZE_BITS = 5;
//
//    private Tile[] tiles;
//    private String Name;
//    private int width, height;
//
//    private Player player;
//
//    private ArrayList<Entiny> entities;
//
//    public tileMap(String Name){
//        entities = new ArrayList<Entiny>();
//    }
//
//    public static int pixelsToTiles(int pixels){
//        return pixels >> TILE_SIZE_BITS;
//    }
//
//    public static int tilesToPixels(int tiles){
//        return tiles << TILE_SIZE_BITS;
//    }
//
//    public void setTile(int x, int y, Tile tile) {
//        tiles[x + y * width] = tile;
//    }
//
//    public Tile getTile(int x, int y) {
//        if (x < 0 || x > width || y < 0 || y >= height) return null;
//        return tiles[x + y * width] = tiles;
//    }
//
//    private void load(String Name){
//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(new File("./levels" + Name + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.Name = Name;
//        this.height = image.getHeight();
//        this.width = image.getWidth();
//
//        int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);
//
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                int id = pixels[x + y + width];
//                if (id ==0xFF000FF)
//                    player = new Player(tilesToPixels(x) * 32, tilesToPixels(y) *32, this);
//                else if (Tile.getFromID(id) != null)
////                    state.addTile(new Tile(id, x, y));
//                    setTile(x, y, Tile.getFromID(id));
//            }
//        }
//    }
//
//    public void addEntiny(Entiny e) {
//        if (!(e instanceof Player)) entities.add(e);
//    }
//
//    public void removeEntiny(Entiny e) {
//        if (!(e instanceof Player)) entities.remove(e);
//    }
//
//    public ArrayList<Entiny> getEntities() {
//        return entities;
//    }
//
//    public Player getPlayer() {
//     return player;
//    }
//}
