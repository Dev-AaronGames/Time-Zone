


import com.badlogic.gdx.graphics.Texture;

import java.awt.Image;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import javax.swing.ImageIcon;

public class Snake {

  Rectangle hitbox;
  Vector2 position;

    Texture img;


    public Snake(int x, int y) {
        img = new Texture();
        hitbox = new Rectangle();
        position = new Vector2(x, y);

        hitbox.set(x, y, img.getWidth(), img.getHeight());
    }

        public void update(){

if ()

        }

        public void draw(SpriteBatch batch){


            batch.draw(img, position.x, position.y);
        }

    }









