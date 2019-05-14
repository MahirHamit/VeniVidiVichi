package at.htlle.shooter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.htlle.shooter.gameobjects.Asteroid;
import at.htlle.shooter.gameobjects.HealthBar;
import at.htlle.shooter.gameobjects.Rocket;
import at.htlle.shooter.gameobjects.SpaceShip;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainStarter extends Application implements EventHandler<KeyEvent> {
	SpaceShip tortuga = new SpaceShip(50, 50);
	HealthBar hp = new HealthBar(tortuga.getX(), tortuga.getY(), 3);
	List<Asteroid> asteroiden = new ArrayList<Asteroid>();
	List<Rocket> raketen = new ArrayList<Rocket>();

	final int HEIGHT = 400;
	final int WIDTH = 600;
	/*
	 * // TODO Auto-generated method stub
	 * 
	 * System.out.println(s);
	 * 
	 * s.moveDown(10);
	 * 
	 * System.out.println(s); }
	 */

	public static void main(String[] args) {
		Application.launch(MainStarter.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("SpaceShooter - Fruehwald");

		Group root = new Group();

		Canvas canvas = new Canvas(600, 400);
		canvas.setFocusTraversable(true);
		canvas.setOnKeyPressed(this);
		root.getChildren().add(canvas);

		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		canvas.getGraphicsContext2D().fillText("Folcon1", 50, 50);

		int x = 0;
		int y = 0;
		int speed = 0;

		for (int i = 0; i < 100; i++) {
			Random r = new Random();
			x = r.nextInt(WIDTH);
			y = r.nextInt(HEIGHT);
			speed = r.nextInt(2) + 1;

			Asteroid a = new Asteroid(y, x, speed);
			asteroiden.add(a);
		}

		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				
				hp.setX(tortuga.getX()-10);
				hp.setY(tortuga.getY()+20);

				canvas.getGraphicsContext2D().clearRect(0, 0, 600, 400);
				tortuga.paint(canvas.getGraphicsContext2D());
				hp.paint(canvas.getGraphicsContext2D());

				for (Asteroid ast : asteroiden) {

					ast.paint(canvas.getGraphicsContext2D());
					ast.move();

					if (ast.isVisible() == false) {
						ast.reposition(WIDTH, HEIGHT);
					}
				}
				
				for(Asteroid ast : asteroiden) {
					if(ast.getBounds().intersects(tortuga.getBounds())) {
						if(hp.getHealth() == 1) {
							System.exit(1);
						}else {
							hp.setHealth(hp.getHealth()-1);
							
						}
					}
				}
				
				List<Rocket> zuLoeschen = new ArrayList<>();

				for (Rocket rocket : raketen) {

					rocket.paint(canvas.getGraphicsContext2D());
					rocket.move();

					if (rocket.isVisible() == false) {
						zuLoeschen.add(rocket);
					}

					
				
				
				for (Asteroid ast : asteroiden) {
					if (ast.getBounds().intersects(rocket.getBounds())) {
						ast.setAstroid("💥");
						ast.reposition(WIDTH, HEIGHT);
					}
					
				}
				
				raketen.removeAll(zuLoeschen);
				}
			}
		}.start();
	}

	public void handle(KeyEvent event) {
		System.out.println(event.getCode().getName());

		int acceleration = 1;

		if (event.isShiftDown()) {
			acceleration = 2;
		}

		switch (event.getCode().getName()) {
		case "W":
			tortuga.moveUp(10 * acceleration);
			break;
		case "S":
			tortuga.moveDown(10 * acceleration);
			break;
		case "A":
			tortuga.moveLeft(10 * acceleration);
			break;
		case "D":
			tortuga.moveRight(10 * acceleration);
			break;
		case "Space":
			Rocket r = tortuga.fire();
			raketen.add(r);
			break;
		}
	}

}
