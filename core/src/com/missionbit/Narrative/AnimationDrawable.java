package com.missionbit.Factors.Narrative;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class AnimationDrawable extends ExampleDrawable {


    private Animation<Texture> animation;

    private Array<Texture> frames = new Array<Texture>();

    private float animationTime;


    protected SpriteBatch drawBatch;


    public AnimationDrawable(Camera gameCamera) {

        super(gameCamera);

        for (int i = 0; i < 3; i++) {

            Texture t = new Texture(Gdx.files.internal("images/animation/frame0" + (i + 1) + ".png"));

            frames.add(t);

        }

        animation = new Animation<Texture>(0.25f, frames, Animation.PlayMode.LOOP_PINGPONG);

        animationTime = 0;


        drawBatch = new SpriteBatch();

    }


    public void update() {

    }

    public void draw() {

        animationTime += Gdx.graphics.getDeltaTime();

        Texture currentFrame = animation.getKeyFrame(animationTime, true);


        drawBatch.begin();

        drawBatch.draw(currentFrame, 100, 100);

        drawBatch.end();

    }

}
