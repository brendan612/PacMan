package pacman.userinput;

import java.util.EventListener;

/**
 *
 * @author David
 */
public interface InputDevice {
	public int direction();

	/**
	 *
	 * @return
	 */
	public EventListener getEventListener();
}
