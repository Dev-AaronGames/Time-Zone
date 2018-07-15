package com.missionbit.Factors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    Array<TextureRegion> levels; //where we store all of our frames
    float maxLevelTime; //this determines how long a frame needs to stay in view before switching to the next one
    float currentLevelTime; //how long the animation has been in the current frame
    int levelCount; //number of frames in our animation
    int level; //the current frame we're in
    public Animation(TextureRegion region, int frameCount, float cycleTime){
        levels = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for(int i = 0; i < frameCount; i++){
            levels.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.levelCount = frameCount;
        maxLevelTime = cycleTime / frameCount;
        level = 0;
    }
    public void update(float dt, int Level){
        currentLevelTime += dt;
        if(currentLevelTime > maxLevelTime){
            Level++;
            currentLevelTime = 0;
        }
        if(level >= levelCount)
            level = 0;
    }
    public TextureRegion getFrame(){
        return levels.get(level);
    }
}