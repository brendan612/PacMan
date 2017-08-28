/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import pacman.game.GameLoop;
import pacman.graphics.GraphicsLoop;

/**
 *
 * @author David
 */
public class Pacman {
	private static final long ONE_SECOND = 1000;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		GameLoop gameL = new GameLoop();
		GraphicsLoop graphL = new GraphicsLoop();
		while(true){
			long start = System.currentTimeMillis();
			gameL.tick();
			graphL.tick();
			while(System.currentTimeMillis() - start < (ONE_SECOND/60));
		}
	}
	
}
