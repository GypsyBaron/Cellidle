package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import javax.xml.bind.SchemaOutputResolver;

public class Cellidle extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private Texture img;
    private ShapeRenderer shapeRenderer;
	private Cell cell;
	private ArrayList<Food> foods = new ArrayList();
	private Food closestFood;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		shapeRenderer = new ShapeRenderer();
		cell = new Cell((float)(Gdx.graphics.getWidth() / 2) , (float)Gdx.graphics.getHeight() / 2 , 100.0f, 1);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(241/255f, 53/255f, 188/255f, 1);
        shapeRenderer.circle(cell.getX(), cell.getY(), cell.getWidth());
		shapeRenderer.end();

		if (!foods.isEmpty()) {
			closestFood = findNearestFood();

			if (Math.abs(cell.getX() - closestFood.getX()) <= 5 && Math.abs(cell.getY() - closestFood.getY()) <= 5) {
				foods.remove(closestFood);
			} else {
				closestFood.setColorR(255);
				closestFood.setColorG(255);
				closestFood.setColorB(255);
			}
		}

		for (Food food: foods) {
			shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			shapeRenderer.setColor(food.getColorR()/255f, food.getColorG()/255f, food.getColorB()/255f, 1);
			shapeRenderer.circle(food.getX(), food.getY(), food.getWidth());
			shapeRenderer.end();
		}
	}

	private void moveToNearestFood() {

	}

	private Food findNearestFood() {
		Food closestFood = new Food();
		double shortestDistance = 0, distance;

		for (Food food : foods) {
			distance = Math.sqrt(Math.pow((cell.getX() - food.getX()), 2) + Math.pow((cell.getY() - cell.getY()), 2));
			if (distance < shortestDistance) {
				shortestDistance = distance;
				closestFood = food;
			} else if (shortestDistance == 0) {
				shortestDistance = distance;
				closestFood = food;
			}
		}
		System.out.println("Shortest distance - " + shortestDistance);
		System.out.println("Cell - " + cell.getX() + " Food - " + closestFood.getX());

		if (cell.getX() > closestFood.getX()) {
			cell.setX((int)(cell.getX() - ((cell.getX() / closestFood.getX()) * cell.getStepSize())));
		}

		if (cell.getX() < closestFood.getX()) {
			cell.setX((int)(cell.getX() + ((closestFood.getX() / cell.getX()) * cell.getStepSize())));
		}

		if (cell.getY() > closestFood.getY()) {
			cell.setY((int)(cell.getY() - ((cell.getY() / closestFood.getY()) * cell.getStepSize())));
		}

		if (cell.getY() < closestFood.getY()) {
			cell.setY((int)(cell.getY() + ((closestFood.getY() / cell.getY()) * cell.getStepSize())));
		}

		return closestFood;
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		shapeRenderer.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		foods.add(new Food((float)screenX, (float)(Gdx.graphics.getHeight() - screenY), 50.0f, 125, 125, 125));
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
