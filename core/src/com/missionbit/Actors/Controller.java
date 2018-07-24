package com.missionbit.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;




public class Controller implements InputProcessor {


    private OrthographicCamera camera; // We need this to unproject our tap coordinates
    private Array<Image> buttons;
/*
Note to self:
To use InputListener, would need a way to reference the pointer that initiated the button to
correctly implement touchUp.
 */


    private Rectangle leftHitbox, rightHitbox ,jumpHitbox,attackHitbox,fireHitbox;

    private boolean leftPressed, rightPressed, jumpPressed, attackPressed,firePressed;


    class TouchInfo {
        public float touchX = 0;
        public float touchY = 0;
        public boolean touched = false;
    }

    private Map<Integer, TouchInfo> touches = new HashMap<Integer, TouchInfo>();


    public Controller(OrthographicCamera camera) {
        buttons = new Array<Image>();

        this.camera = camera;

        Image left = new Image(new Texture("LeftButton.png"));
        left.setPosition(0, 0);
        leftHitbox = new Rectangle(left.getX(), left.getY(), left.getWidth(), left.getHeight());
        buttons.add(left);

        Image right = new Image(new Texture("RightButton.png"));
        right.setPosition(100, 0);
        rightHitbox = new Rectangle(right.getX(), right.getY(), right.getWidth(), right.getHeight());
        buttons.add(right);

        Image jump = new Image(new Texture("jump.png"));
        jump.setPosition(67, 100);
        jumpHitbox = new Rectangle(jump.getX() , jump.getY() , jump.getWidth() , jump.getHeight() );
        buttons.add(jump);

        Image attack = new Image(new Texture("pixil-frame-0 (1).png"));
        attack.setPosition(600,80);
        attackHitbox = new Rectangle(attack.getX() , attack.getY() , attack.getWidth() , attack.getHeight());
        buttons.add(attack);

        Image fire = new Image(new Texture("pixil-frame-0 (2).png"));
        fire.setPosition(600,160);
        fireHitbox = new Rectangle(fire.getX() , fire.getY() , fire.getWidth() , fire.getHeight());
        buttons.add(fire);


        Gdx.input.setInputProcessor(this);
        for (int i = 0; i < 5; i++) {
            touches.put(i, new TouchInfo());
        }


    }

    public void update(OrthographicCamera camera) {

    }

    public void draw(SpriteBatch batch) {
        for (Image i : buttons) {
            i.draw(batch, 0.8f);

        }
    }

    public void drawDebug(ShapeRenderer sr) {
        sr.rect(leftHitbox.x, leftHitbox.y, leftHitbox.width, leftHitbox.height);
        sr.rect(rightHitbox.x, rightHitbox.y, rightHitbox.width, rightHitbox.height);
        sr.rect(jumpHitbox.x, jumpHitbox.y, jumpHitbox.width, jumpHitbox.height);
        sr.rect(attackHitbox.x, attackHitbox.y, attackHitbox.width,attackHitbox.height);
        sr.rect(fireHitbox.x, fireHitbox.y, fireHitbox.width,fireHitbox.height);
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isJumpPressed() {
        return jumpPressed;
    }

    public boolean isAttackPressed() {
        return attackPressed;
    }

    public boolean isFirePressed() { return firePressed; }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

           @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            Vector3 touchPos = new Vector3(screenX, screenY, 0);
            camera.unproject(touchPos);


            if (pointer < 5) {
            touches.get(pointer).touchX = touchPos.x;
            touches.get(pointer).touchY = touchPos.y;
            touches.get(pointer).touched = true;

            if (leftHitbox.contains(touchPos.x, touchPos.y)) {

                leftPressed = true;

            } else if (rightHitbox.contains(touchPos.x, touchPos.y)) {

                rightPressed = true;

            } else if (jumpHitbox.contains(touchPos.x, touchPos.y)) {

                jumpPressed = true;
                System.out.println("hi");
            }
            else if (attackHitbox.contains(touchPos.x, touchPos.y)) {

                attackPressed = true;

            }  else if (fireHitbox.contains(touchPos.x, touchPos.y)) {

               firePressed = true;

            }
            return true;
        }


        return true;


    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector3 touchPos = new Vector3(screenX, screenY, 0);

camera.unproject(touchPos);

if (pointer < 5){

    leftPressed = false;
    rightPressed = false;
    jumpPressed = false;
    attackPressed = false;
    firePressed = false;
}

        return true;


    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        Vector3 touchPos = new Vector3(screenX, screenY, 0);
        camera.unproject(touchPos);


        if (pointer < 5) {
            touches.get(pointer).touchX = touchPos.x;
            touches.get(pointer).touchY = touchPos.y;
            touches.get(pointer).touched = true;

            if (leftHitbox.contains(touchPos.x, touchPos.y)) {

                leftPressed = true;

            } else if (rightHitbox.contains(touchPos.x, touchPos.y)) {

                rightPressed = true;

            } else if (jumpHitbox.contains(touchPos.x, touchPos.y)) {

                jumpPressed = true;

            }
            else if (attackHitbox.contains(touchPos.x, touchPos.y)) {

                attackPressed = true;
            }else if (fireHitbox.contains(touchPos.x, touchPos.y)) {

                firePressed = true;
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

