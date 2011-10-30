package matachi.asteroids.game;

import java.awt.Point;

/**
 * This class models a flying object. Which can be an asteroid or the spaceship.
 * 
 * @author Daniel "MaTachi" Jonsson
 * @version 1.0
 * @since 0.1
 *
 */
abstract class FlyingObject implements IUpdateable, Cloneable {

	// These variables are set to protected, so Asteroid won't have to manage
	// them directly.
	public Point position;
	public Point velocity;
	public Point acceleration;
	
	private int width;
	private int height;
	
	/**
	 * Constructs an asteroid with position, velocity and acceleration set to
	 * zero.
	 */
	public FlyingObject(final int width, final int height) {
		position = new Point();
		velocity = new Point();
		acceleration = new Point();
		this.width = width;
		this.height = height;
	}
	
//	public FlyingObject(FlyingObject object) {
//		this.position = (Point) object.position.clone();
//		this.velocity = (Point) object.velocity.clone();
//		this.acceleration = (Point) object.acceleration.clone();
//		this.width = object.width;
//		this.height = object.height;
//	}

	/**
	 * Update the asteroid
	 */
	@Override
	public void move() {
		/*
		 * Update the velocity and the position of the asteroid.
		 */
		this.velocity.setLocation(velocity.x + acceleration.x, velocity.y
				+ acceleration.y);
		this.position.setLocation(position.x + velocity.x, position.y
				+ velocity.y);
		this.acceleration.setLocation(0, 0);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	//public FlyingObject clone() {
	//	return new FlyingObject(this);
	//}
}
