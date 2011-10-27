package matachi.asteroids.game;

/**
 * A class that describes a point with two doubles. Useful in game developing
 * for describing position, velocity and acceleration.
 * There is a Java class called Point, but it uses ints, which is more accurate
 * but not as "flexible". This class allows for smaller and smoothers movements.
 * 
 * 
 * @author Daniel "MaTachi" Jonsson
 * @version 1.0
 * @since 1.0
 * 
 */
public class DPoint {

	private double x;
	private double y;

	/**
	 * Creates an instance of a 2D double coordinate with (0, 0).
	 */
	public DPoint() {
		this(0, 0);
	}

	/**
	 * Creates an instance of a 2D double coordinate.
	 * @param x x coordiante
	 * @param y y coordinate
	 * 
	 */
	public DPoint(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates an instance of a 2D double coordinate from another DPoint.
	 * @param p a DPoint
	 */
	public DPoint(DPoint p) {
		this(p.x, p.y);
	}

	/**
	 * Returns the X coordinate.
	 * @return the x value of the coordinate
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * Returns the Y coordinate.
	 * @return the y value of the coordinate
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * Sets the X coordinate.
	 * @param x set the x coordiante
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Sets the Y coordinate.
	 * @param y set the y coordiante
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Sets the points coordinates from another point.
	 * @param p set the x and y coordinates from another DPont
	 */
	public void setXY(DPoint p) {
		setXY(p.getX(), p.getY());
	}

	/**
	 * Sets the X and Y coordinates at the same time.
	 * @param x set the x coordiante
	 * @param y set the y coordiante
	 */
	public void setXY(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Move the coordinate with amount given in the parameters.
	 * To clarify: This method doesn't move the point to the specified
	 * coordinate, but instead adds to the already exisiting location.
	 * @param x move the x coordiante
	 * @param y move the y coordiante
	 */
	public void move(double x, double y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Returns the distance to another (X,Y) coordinate.
	 * @param x the x coordinate
	 * @param y the y coordiante
	 */
	public double distance(double x, double y) {
		double deltaX = x - this.x;
		double deltaY = y - this.y;
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	}

	/**
	 * Returns the distance to another DPoint.
	 * @param p the other DPoint
	 */
	public double distance(DPoint p) {
		return distance(p.x, p.y);
	}

	/**
	 * Returns the distance between two points.
	 * @param p1 the first DPoint
	 * @param p2 the second DPoint
	 */
	public static double distance(DPoint p1, DPoint p2) {
		double deltaX = p1.x - p2.x;
		double deltaY = p1.y - p2.y;
		return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
	}

	@Override
	public int hashCode() {
		return (int)(23456789 * this.x + 56789123 * this.y);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		DPoint other = (DPoint) obj;
		return this.x == other.x && this.y == other.y;
	}
}
