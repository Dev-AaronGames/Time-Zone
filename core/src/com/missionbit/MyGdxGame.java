package com.missionbit;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	private Texture img;
	public static final String TITLE = "Time-Zone";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
    public BitmapFont font;
    private Music music;

	public OrthographicCamera camera;

	private TiledMapRenderer tiledMapRenderer;
	private TiledMap tiledMap;

	public MyGdxGame() {

	}

	@Override
	public void create () {
    	font = new BitmapFont();
    	font.setColor(Color.WHITE);
    	batch = new SpriteBatch();
		Gdx.gl.glClearColor(0.75f, 0.75f, 0.75f, 1);

//		music = Gdx.audio.newMusic(Gdx.files.internal("music/bgm1.mp3"));
//		music.setLooping(true);
//		music.setVolume(1f);
//		music.play();

//		this.setScreen(new Map(this));

//		img = new Texture("GameVortex.png");
		img = new Texture("badlogic.jpg");
		System.out.println("Hello World!!!! - Make sure to update every time you make/complete a task.");

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}



	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
//		music.dispose();
	}
}

