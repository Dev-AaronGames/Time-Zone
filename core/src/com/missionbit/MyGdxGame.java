package com.missionbit;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.missionbit.States.PlayState;

public class MyGdxGame extends Game {


	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	public static final String TITLE = "LibGDX Sample";

	OrthographicCamera camera;


	public SpriteBatch batch;


	public ShapeRenderer sr;
	Texture Background;



	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,MyGdxGame.WIDTH,MyGdxGame.HEIGHT);

		Background = new Texture("landscape.png");
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		setScreen(new PlayState(this));

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		Gdx.gl.glClear(GL20.GL_STENCIL_VALUE_MASK);

	}

	@Override
	public void dispose () {
		batch.dispose();


	}
}
