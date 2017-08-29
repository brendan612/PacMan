/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import pacman.game.GameLoop;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;
import pacman.userinput.KeyboardInput;

/**
 *
 * @author David
 */
public class Pacman {
	private static final long ONE_SECOND = 1000;
	private static InputDevice id;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		id = new KeyboardInput();
		GraphicsLoop graphL = new GraphicsLoop(id);
		GameLoop gameL = new GameLoop(id, graphL);
		while(true){
		long start = System.currentTimeMillis();
			graphL.tick();
			gameL.tick();
			//controls the FPS currently set up to run at 60 (Will probably shorten this time later)
			while(System.currentTimeMillis() - start < (ONE_SECOND/60));
		}
	}
	
}
