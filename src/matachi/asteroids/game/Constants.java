package matachi.asteroids.game;

import java.awt.Dimension;

/** Provides a fixed size for various games. */
public class Constants {
	;
	// Safe Singleton pattern, prevent instantiation.
	/** 
	 * An immutable Dimension object of constant size. 
	 * This variable specifies how large the game area will be. However, it will
	 * of course be scaled down later, so this is only for calculation's sake.
	 * Why the width and height are so large are because I want to make it more
	 * accurate.
	 */
	private static final Dimension SIZE = new Dimension(100000, 100000);
	
	/** @return an copy of the Dimension constant. */
	public static Dimension getGameSize() {
		// Dimension is a mutable class, copy to prevent mutation.
		return new Dimension(SIZE);
	}

	private static final Dimension RESOLUTION = new Dimension(800, 800);

	/** @return an copy of the Dimension constant. */
	public static Dimension getGameRealSize() {
		// Dimension is a mutable class, copy to prevent mutation.
		return new Dimension(RESOLUTION);
	}

	public static final int SCALE_X = SIZE.width / RESOLUTION.width;
	public static final int SCALE_Y = SIZE.height / RESOLUTION.height;
	
	public static final int THRUST = 10;
	
	public static final double THRUST_ANGLE = 0.05;
}
