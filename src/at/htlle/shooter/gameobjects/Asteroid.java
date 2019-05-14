package at.htlle.shooter.gameobjects;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

public class Asteroid {

	private String Asteroid = "✨";
	private Integer x, y;
	private int speed;
	private int Range = 7;

	@Override
	public String toString() {
		return "Asteriod=" + Asteroid + ", x=" + x + ", y=" + y + ", speed=" + speed;
	}

	public Asteroid(Integer x, Integer y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public void move() {
		this.x -= this.speed;
	}

	public boolean isVisible() {
		return this.x > 0;
				}
	
	public Bounds getBounds() {
		Circle c = new Circle(this.x, this.y, this.Range);
		return c.getBoundsInLocal();
	}
	
	public int getRange() {
		return Range;
	}

	public void setRange(int range) {
		Range = range;
	}

	public void setAstroid(String astroid) {
		this.Asteroid = astroid;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public void reposition(int width, int height) {
		Random rnd = new Random();

		this.x = width + rnd.nextInt(width);
		this.y = rnd.nextInt(height);
		this.speed = 1 + rnd.nextInt(3);
	}

	public void paint(GraphicsContext gc) {
		gc.fillText(this.Asteroid, this.x, this.y);
	}

}
