package pacman.userinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements InputDevice{
	KeyListener kl;
	private int directionMoving;
	
	public KeyboardInput(){
		directionMoving = 0;
		kl = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				switch (ke.getKeyChar()) {
					case KeyEvent.VK_W:
						directionMoving = 0;
						break;
					case KeyEvent.VK_A:
						directionMoving = 1;
						break;
					case KeyEvent.VK_S:
						directionMoving = 2;
						break;
					case KeyEvent.VK_D:
						directionMoving = 3;
						break;
					default:
				}
			}
		};
	}

	@Override
	public int direction() {
		return directionMoving;
	}
}
