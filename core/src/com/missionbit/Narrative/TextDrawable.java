package com.missionbit.Factors.Narrative;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Align;
import com.missionbit.Factors.Narrative.ExampleDrawable;

//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.graphics.Camera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
//import com.badlogic.gdx.utils.Align;

public class TextDrawable extends ExampleDrawable implements InputProcessor {
    protected BitmapFont bodyFont;
    protected BitmapFont headlineFont;
    protected SpriteBatch batch;
    protected TextArticle text;
    protected Sprite leftArrow;
    protected Sprite rightArrow;
    protected int page = 0;
    protected int pageSize = 300;
    protected int maxPage;
    public TextDrawable(Camera gameCamera){
        super(gameCamera);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/RobotoSlab-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 18;
        bodyFont = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/RobotoSlab-Bold.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 18;
        headlineFont = generator.generateFont(parameter);
        generator.dispose();
        batch = new SpriteBatch();
        text = TextArticle.loadJSON("text/TextExample.json");
        maxPage = text.bodyText.length() / pageSize;
        rightArrow = new Sprite( new Texture(Gdx.files.internal("images/right_arrow.png")));
        rightArrow.setPosition(540, 200);
        leftArrow = new Sprite( new Texture(Gdx.files.internal("images/left_arrow.png")));
        leftArrow.setPosition(40, 200);
        Gdx.input.setInputProcessor(this);
    }
    @Override
    public void draw(){
        batch.setProjectionMatrix(camera.combined);
        String textPage = text.bodyText.substring(page * pageSize,
                Math.min((page + 1) * pageSize, text.bodyText.length()));
        batch.begin();
        headlineFont.draw(batch, text.headline, 100, Gdx.graphics.getHeight() - 60, 400, Align.left, false);
        headlineFont.draw(batch,(page + 1) + " of " + (maxPage + 1), 100, Gdx.graphics.getHeight() - 120, 400, Align.left, false);
        bodyFont.draw(batch, textPage, 100, Gdx.graphics.getHeight() - 180, 400, Align.left, true);
        rightArrow.draw(batch);
        leftArrow.draw(batch);
        batch.end();
    }
    @Override
    public void update(){

    }
    public void incrementPage(){
        if(page < maxPage){
            page++;
        }
    }
    public void decrementPage(){
        if(page > 0){
            page--;
        }
    }
    public boolean keyDown (int keycode) {
        return false;
    }
    public boolean keyUp (int keycode) {
        return false;
    }
    public boolean keyTyped (char character) {
        return false;
    }
    public boolean touchDown (int x, int y, int pointer, int button) {
        Vector3 touchPos = new Vector3();
        touchPos.set(x, y, 0);
        camera.unproject(touchPos);
        if(leftArrow.getBoundingRectangle().contains(touchPos.x, touchPos.y)){
            decrementPage();
        }
        if(rightArrow.getBoundingRectangle().contains(touchPos.x, touchPos.y)){
            incrementPage();
        }
        return false;
    }
    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }
    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }
    public boolean mouseMoved (int x, int y) {
        return false;
    }
    public boolean scrolled (int amount) {
        if(amount > 0){
            incrementPage();
        }
        else if(amount < 0){
            decrementPage();
        }
        return false;
    }
}
