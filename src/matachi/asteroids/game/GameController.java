package matachi.asteroids.game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * The controller class of the game. It initialize the game graphics, manage the
 * updating and make sure that the graphics get drawn. It also listens to user
 * keystrokes and passes them on to the current game (GameModel).
 * 
 * @author Daniel "MaTachi" Jonsson
 * @verion 1.0
 * @since 0.1
 * 
 */
public class GameController extends BasicGame {

	/** The game model describes the running game. */
	private GameModel gameModel;

	/** The spaceship sprite. */
	private Image shipSprite;

	/** The asteroid sprite. */
	private Image asteroidSprite;

	/** What the position are supposed to be multiplied with are saved in these.
	 * Then these calculations won't be done for each frame. */
	private float scaleX;
	private float scaleY;

	/**
	 * Construct the game.
	 * 
	 * @param title Title of the game. Will be shown in the title bar.
	 */
	public GameController(String title) {
		super(title);
		gameModel = new GameModel();
		scaleX = (float) (Constants.getGameRealSize().getWidth()
				/ Constants.getGameSize().getWidth());
		scaleY = (float) (Constants.getGameRealSize().getHeight()
				/ Constants.getGameSize().getHeight());
	}

	/**
	 * Initialize the game graphics and similar stuff.
	 * 
	 * @throws SlickException
	 */
	@Override
	public void init(GameContainer g) throws SlickException {
		shipSprite = new Image("data/ship.png");
		asteroidSprite = new Image("data/asteroid.png");
	}

	/**
	 * Update game logic and stuff. This doesn't draw any graphics to the
	 * screen.
	 * 
	 * @throws SlickException
	 */
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		try {
			// Update the game model and also feed it with the inputs.
			Input input = gc.getInput();
			this.gameModel.gameUpdate(input);
		} catch (GameOverException e) {
			// e.printStackTrace();
		}
	}

	/**
	 * This renders the graphics.
	 * 
	 * @throws SlickException
	 */
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = 0; i < gameModel.getAsteroids().size(); i++) {
			asteroidSprite.draw(gameModel.getAsteroids().get(i).position.x
					* this.scaleX, gameModel.getAsteroids().get(i).position.y
					* this.scaleY);
		}
		shipSprite.setRotation((float) Math.toDegrees(gameModel.getSpaceship()
				.getAngle()));
		shipSprite.draw(
				gameModel.getSpaceship().position.x * this.scaleX,
				gameModel.getSpaceship().position.y * this.scaleY);
//		g.drawOval(
//				gameModel.getSpaceship().position.x * this.scaleX,
//				gameModel.getSpaceship().position.y * this.scaleY, 121, 122);
	}
}
