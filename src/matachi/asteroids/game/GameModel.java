package matachi.asteroids.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.Input;

/**
 * This class describes the game and the rules. It also manages the gameUpdate
 * method that updates everything in the game.
 * 
 * @author Daniel "MaTachi" Jonsson
 * @version 1.0
 * @since 0.1
 * 
 */
public class GameModel {

	// List of all asteroids currently in the game.
	private ArrayList<Asteroid> asteroids;
	
	// The bullets on the screen.
	private ArrayList<Bullet> bullets;
	
	// The spaceship
	private Spaceship spaceship;
	
	public GameModel() {
		// Construct all asteroids and add them to the game.
		asteroids = new ArrayList<Asteroid>();
		for (int i = 0; i < 10; i++) {
			asteroids.add(new Asteroid());
			Random r = new Random();
			asteroids.get(i).velocity.setLocation((r.nextInt(2) * 2 - 1) * 50, (r.nextInt(2) * 2 - 1) * 50);
			asteroids.get(i).position.setLocation(r.nextInt(100000),
					r.nextInt(100000));
		}
		
		// Initialize the spaceship that the player will control and place it
		// in the middle of the screen
		spaceship = new Spaceship();
		spaceship.position.x = (int) (Constants.getGameSize().getWidth() / 2 -
				spaceship.getWidth() / 2);
		spaceship.position.y = (int) (Constants.getGameSize().getHeight() / 2 -
				spaceship.getHeight() / 2);
	}
	
	/**
	 * Update the game. This is supposed to be executed for every frame.
	 * @param lastKey the last key that the user pressed
	 * @throws GameOverException
	 */
	public void gameUpdate(final Input input) throws GameOverException {
		
		// Update the spaceship based on inputs. If a bullet is returned it will
		// be added to the bullets list.
		Bullet bullet = spaceship.updateControl(input);
		if (bullet != null) {
			bullets.add(bullet);
		}
		
		// Update the spaceship's position velocity.
		spaceship.move();
		checkObjectPosition(spaceship);
		
		// Go through all asteroids and update them.
		for (int i = 0; i < asteroids.size(); i++) {
			asteroids.get(i).move();
			checkObjectPosition(asteroids.get(i));
		}
	}
	
	/**
	 * Help method that checks a FlyingObject's position and make it possible to
	 * wrap to the other side of the game.
	 * @param flyingObject the flyingObject that should be checked and eventually updated
	 */
	private void checkObjectPosition(FlyingObject flyingObject) {
		if (flyingObject.position.x >= Constants.getGameSize().width) {
			flyingObject.position.x = -flyingObject.getWidth() + (flyingObject.position.x - Constants.getGameSize().width);
		} else if (flyingObject.position.x + flyingObject.getWidth() <= 0) {
			flyingObject.position.x = Constants.getGameSize().width + flyingObject.position.x + flyingObject.getWidth();
		}

		if (flyingObject.position.y >= Constants.getGameSize().height) {
			flyingObject.position.y = flyingObject.position.y - flyingObject.getHeight() - Constants.getGameSize().height;
		} else if (flyingObject.position.y + flyingObject.getHeight() <= 0) {
			flyingObject.position.y = Constants.getGameSize().height + flyingObject.position.y + flyingObject.getHeight();
		}
	}

	public ArrayList<Asteroid> getAsteroids() {
		return asteroids;
	}

	public void setAsteroids(ArrayList<Asteroid> asteroids) {
		this.asteroids = asteroids;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	public Spaceship getSpaceship() {
		return spaceship;
	}

	public void setSpaceship(Spaceship spaceship) {
		this.spaceship = spaceship;
	}
}
