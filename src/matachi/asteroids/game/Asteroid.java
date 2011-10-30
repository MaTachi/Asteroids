package matachi.asteroids.game;

public class Asteroid extends FlyingObject {

	public Asteroid() {
		super((int) (100 * Constants.SCALE_X), (int) (100 * Constants.SCALE_Y));
	}
}
