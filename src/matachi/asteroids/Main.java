package matachi.asteroids;

import matachi.asteroids.game.GameController;
import matachi.asteroids.game.GameView;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * The Main class that starts up the game by invoking the AppGameContainer with
 * the gameController.
 * 
 * @author Daniel "MaTachi" Jonsson
 * @version 1.0
 * @since 0.1
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GameController gameController = new GameController("Asteroids");
			AppGameContainer app = new AppGameContainer(gameController);
			app.setDisplayMode(800, 800, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
