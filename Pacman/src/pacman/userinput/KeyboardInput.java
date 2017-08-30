package pacman.userinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

public class KeyboardInput implements InputDevice{
	KeyListener kl;
	private int directionMoving;
	
	public KeyboardInput(){
		directionMoving = -1;
		kl = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
			}

			@Override
			public void keyPressed(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				switch (ke.getKeyCode()) {
					case KeyEvent.VK_W:
					case KeyEvent.VK_UP:
						directionMoving = 0;
						break;
					case KeyEvent.VK_A:
					case KeyEvent.VK_LEFT:
						directionMoving = 1;
						break;
					case KeyEvent.VK_S:
					case KeyEvent.VK_DOWN:
						directionMoving = 2;
						break;
					case KeyEvent.VK_D:
					case KeyEvent.VK_RIGHT:
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

	@Override
	public EventListener getEventListener() {
		return (EventListener) kl;
	}
}
