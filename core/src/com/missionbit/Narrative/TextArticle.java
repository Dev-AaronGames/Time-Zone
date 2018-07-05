package com.missionbit.Factors.Narrative;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class TextArticle {
    protected String headline;
    protected String bodyText;
    public static TextArticle loadJSON(String jsonPath){
        Json j = new Json();
        FileHandle f = Gdx.files.internal(jsonPath);
        TextArticle article = j.fromJson(TextArticle.class, f);
        return article;
    }
}

