package at.htlle.shooter.gameobjects;

import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

public class Rocket {

	private String Rocket = "○";
	private Integer x, y;
	private int speed;
	private int Range = 5;

	@Override
	public String toString() {
		return "Rakete=" + Rocket + ", x=" + x + ", y=" + y + ", speed=" + speed;
	}

	public Rocket(Integer x, Integer y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public void move() {
		this.x += this.speed;
	}

	public boolean isVisible() {
		return this.x < 600;
				}

	public void reposition(int width, int height) {
		Random rnd = new Random();

		this.x = width + rnd.nextInt(width);
		this.y = rnd.nextInt(height);
		this.speed = 1 + rnd.nextInt(3);
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

	public void paint(GraphicsContext gc) {
		gc.fillText(this.Rocket, this.x, this.y);
	}
	
	public Bounds getBounds() {
		Circle c = new Circle(this.x, this.y, this.Range);
		return c.getBoundsInLocal();
	}

}
