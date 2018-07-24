package com.missionbit;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.missionbit.Actors.Controller;
import com.missionbit.Actors.Player;

public class MyGdxGame extends Game {


	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;
	public static final String TITLE = "LibGDX Sample";
	private Controller controller;
	OrthographicCamera camera;


	public SpriteBatch batch;

	Player ghost;
	ShapeRenderer sr;
	Texture Background;



	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
		ghost = new Player(100,100,100);
		controller = new Controller(camera);
		Background = new Texture("landscape.png");
		batch = new SpriteBatch();
		sr = new ShapeRenderer();

	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		Gdx.gl.glClear(GL20.GL_STENCIL_VALUE_MASK);
		if (controller.isLeftPressed()){

			ghost.moveLeft();
		}else if(controller.isRightPressed()){

			ghost.moveRight();

		} else {
			ghost.resetAnim();

		}

		if (controller.isJumpPressed()){
			ghost.jump();
		}

		if (controller.isAttackPressed()){
			ghost.atack();
		}
		if (controller.isFirePressed()){
			ghost.fire();
		}

		ghost.update(Gdx.graphics.getDeltaTime());

		batch.begin();
		batch.draw(
				ghost.getTexture(Gdx.graphics.getDeltaTime()),
				ghost.getPosition().x,
				ghost.getPosition().y,
				250,
				250);
		controller.draw(batch);
		batch.end();



		sr.begin(ShapeRenderer.ShapeType.Line);
		controller.drawDebug(sr);
		sr.end();

	}

	@Override
	public void dispose () {
		batch.dispose();


	}
}
