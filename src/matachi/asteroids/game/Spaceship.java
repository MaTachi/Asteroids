package matachi.asteroids.game;

import org.newdawn.slick.Input;

/**
 * The spaceship that the player controls.
 * 
 * @author Daniel "MaTachi" Jonsson
 * @version 1.0
 * @since 1.0
 *
 */
public class Spaceship extends FlyingObject {

	// The angle the ship is poiting
	private double angle;
	
	/**
	 * Construct the spaceship.
	 */
	public Spaceship() {
		super((int) (122 * Constants.SCALE_X), (int) (121 * Constants.SCALE_Y));
		// Start the spaceship pointed upwards
		angle = 0;
	}
	
	/**
	 * Update the spaceship based on the keyboard inputs. This method doesn't
	 * directly move the spaceship however. Movements handles the method
	 * move() in the class FlyingObject.
	 * @param input input from the keyboard and such
	 * @return if the ship shoots a bullet a Bullet is returned, otherwise is 
	 * null returned
	 */
	public Bullet updateControl(final Input input) {
		if (input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)) {
			this.angle -= Constants.THRUST_ANGLE;
		} else if (input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
			this.angle += Constants.THRUST_ANGLE;
		}
		if (input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) {
			this.acceleration.x = (int)(Math.sin(angle) * Constants.THRUST);
			this.acceleration.y = -(int)(Math.cos(angle) * Constants.THRUST);
		} else if (input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
			this.acceleration.x = -(int)(Math.sin(angle) * Constants.THRUST);
			this.acceleration.y = (int)(Math.cos(angle) * Constants.THRUST);
		}
		if (input.isKeyDown(Input.KEY_SPACE)) {
			return new Bullet();
		}
		return null;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
}
