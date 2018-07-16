package com.missionbit;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.missionbit.Actors.Controller;
import com.missionbit.Actors.Player;

public class MyGdxGame extends ApplicationAdapter {


	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	public static final String TITLE = "LibGDX Sample";
	private Controller controller;
	OrthographicCamera camera;


	SpriteBatch batch;
	Texture img;
	Player ghost;
ShapeRenderer sr;
	Texture Background;


	@Override
	public void create () {
sr = new ShapeRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
		controller = new Controller(camera);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	ghost = new Player(100,100,500);
		System.out.println("Hello World!!!! - Make sure to update every time you make/complete a task.");



	}

	@Override
	public void render () {


Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ghost.update(Gdx.graphics.getDeltaTime());


		if (controller.isLeftPressed()){

			ghost.moveLeft();
		}else if(controller.isRightPressed()){

			ghost.moveRight();

		} else {
			ghost.resetAnim();

		}

		if (controller.isJumpPressed()){
			System.out.println("hi22");
			ghost.jump();
		}


		batch.begin();
		controller.draw(batch);
		ghost.draw(batch);

		batch.end();

sr.begin(ShapeRenderer.ShapeType.Line);

controller.drawDebug(sr);
sr.end();

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();

	}
}
