package at.htlle.shooter.gameobjects;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SpaceShip {

	private Color farbe;
	private String SpaceShip = "🚀";
	private Integer x, y;
	private int Range = 20;

	public SpaceShip(Integer x, Integer y) {
		this.farbe = farbe;
		this.x = x;
		this.y = y;
	}
	

	public Integer getX() {
		return x;
	}



	public Integer getY() {
		return y;
	}



	public void moveRight(int x) {
		this.x = this.x + x;
	}

	public void moveLeft(int x) {
		this.x = this.x - x;
	}

	public void moveDown(int y) {
		this.y = this.y + y;
	}

	public void moveUp(int y) {
		this.y = this.y - y;
	}

	@Override
	public String toString() {
		return "SpaceShip (Farbe = " + farbe + "| Raumschiff = " + SpaceShip + "| Koordinaten = " + x + "," + y + ")";
	}

	public void paint(GraphicsContext gc) {
		gc.fillText(this.SpaceShip, this.x, this.y);
	}

	public Rocket fire() {
		Rocket r = new Rocket(this.x, this.y, 2);
		return r;
	}
	
	public Bounds getBounds() {
		Circle c = new Circle(this.x, this.y, this.Range);
		return c.getBoundsInLocal();
	}
}
