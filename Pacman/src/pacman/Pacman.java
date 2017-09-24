package pacman;

import pacman.game.GameLoop;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;
import pacman.userinput.KeyboardInput;
import pacman.userinput.MouseInput;

/**
 *
 * @author David
 */
public class Pacman {
	private static final long ONE_SECOND = 1000;
	private static InputDevice id[] = {new KeyboardInput(),
                                           new MouseInput()};
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		GraphicsLoop graphL = new GraphicsLoop(id);
		GameLoop gameL = new GameLoop(id[0], graphL);
		while(true){
		long start = System.currentTimeMillis();
			graphL.tick();
			gameL.tick();
			//controls the FPS currently set up to run at 60 (Will probably shorten this time later)
			while(System.currentTimeMillis() - start < (ONE_SECOND/60));
		}
	}
	
}
