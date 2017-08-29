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
				System.out.println("key Typed");
			}

			@Override
			public void keyPressed(KeyEvent ke) {
				System.out.println("keyPressed");
			}

			@Override
			public void keyReleased(KeyEvent ke) {
				System.out.println("key released" + ke.getKeyCode());
				switch (ke.getKeyCode()) {
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

	@Override
	public EventListener getEventListener() {
		return (EventListener) kl;
	}
}
