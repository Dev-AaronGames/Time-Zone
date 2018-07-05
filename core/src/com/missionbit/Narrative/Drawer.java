package com.missionbit.Factors.Narrative;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Drawer extends ApplicationAdapter {
    private OrthographicCamera camera;

    private ExampleDrawable drawable;

    @Override
    public void create() {
        // Set up camera for 2d view of 800x480 pixels
        camera = new OrthographicCamera();

        camera.setToOrtho(false, 960, 540);

        // Collision demo -- uncomment this to run
        //drawable = new SimpleCollisionDrawable(camera);

        // Text drawing demo
        drawable = new TextDrawable(camera);

        //drawable = new AnimationDrawable(camera);
        drawable = new AtlasAnimationDrawable(camera);

    }

    @Override
    public void render() {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //Set up our camera
        camera.update();

        //Update and draw our shapes
        drawable.update();

        drawable.draw();

//        @Override
//        public void dispose; //{
//            //camera.dispose;
//        //}
    }
}
