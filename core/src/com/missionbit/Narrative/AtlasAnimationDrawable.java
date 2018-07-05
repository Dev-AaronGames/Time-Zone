package com.missionbit.Factors.Narrative;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AtlasAnimationDrawable extends ExampleDrawable {

    private TextureAtlas atlas;

    private Animation<TextureRegion> animation;

    private float animationTime;

    protected SpriteBatch drawBatch;

    public AtlasAnimationDrawable(Camera gameCamera) {

        super(gameCamera);

        atlas = new TextureAtlas(Gdx.files.internal("images/animationSheets/animation.atlas"));

        animation = new Animation<TextureRegion>(0.25f, atlas.getRegions(), Animation.PlayMode.LOOP_PINGPONG);

        animationTime = 0;

        drawBatch = new SpriteBatch();

    }

    public void update() {

    }

    public void draw() {

        animationTime += Gdx.graphics.getDeltaTime();

        TextureRegion currentFrame = animation.getKeyFrame(animationTime, true);

        drawBatch.begin();

        drawBatch.draw(currentFrame, 100, 100);

        drawBatch.end();

    }
}