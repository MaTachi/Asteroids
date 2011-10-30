package matachi.asteroids.game;

/**
 * Interface that says that a class implementing it has a method called update
 * which will update movements and stuff.
 * 
 * @author Daniel "MaTachi" Jonsson
 * @version 1.0
 * @since 1.0
 * 
 */
public interface IUpdateable {
	
	/**
	 * Update the object.
	 */
	public void move();
}
