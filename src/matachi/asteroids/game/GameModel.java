package matachi.asteroids.game;

import java.util.List;

/**
 * This class describes the game and the rules.
 * 
 * @author Daniel "MaTachi" Jonsson
 * @version 1.0
 * @since 0.1
 * 
 */
public class GameModel {

	// List of all asteroids currently in the game.
	private List<Asteroid> asteroids;
	
	public GameModel() {
		asteroids.add(new Asteroid());
	}
	
	/**
	 * Update the game. This is supposed to be executed for every frame.
	 * @param lastKey the last key that the user pressed
	 * @throws GameOverException
	 */
	public void gameUpdate(final int lastKey) throws GameOverException {
		
		/*
		 * Go through all asteroids and update them.
		 */
		for (int i = 0; i < asteroids.size(); i++) {
			asteroids.get(i).update();
		}
	}
}
