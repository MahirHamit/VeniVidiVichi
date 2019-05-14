package at.htlle.shooter.gameobjects;

import javafx.scene.canvas.GraphicsContext;

public class HealthBar {
	private String[] healthbar = {"🖤", "🖤🖤", "🖤🖤🖤"};
	private Integer x, y;
	private int health;
	
	
	public void setHealtbar(String[] healtbar) {
		this.healthbar = healtbar;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
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
	public HealthBar(Integer x, Integer y, int health) {
		this.x = x;
		this.y = y;
		this.health = health;
	}
	
	public void paint(GraphicsContext gc) {
		gc.fillText(this.healthbar[this.health-1], this.x, this.y);
	}
}

