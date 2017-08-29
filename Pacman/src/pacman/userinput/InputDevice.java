/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
