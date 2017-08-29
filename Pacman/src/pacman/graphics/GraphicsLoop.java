/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.graphics;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import pacman.LoopPart;
import pacman.graphics.display.Display;

public class GraphicsLoop implements LoopPart {
    private final String TITLE = "Pac-Man";
    private final int WIDTH = 500, HEIGHT = 500;
    
    private Display display;
    
    private BufferStrategy bs;
    private static Graphics g;
    
    public GraphicsLoop() {
        display = new Display(TITLE,WIDTH,HEIGHT);
    }

	public static Graphics getG() {
		return g;
	}

	public static void setG(Graphics g) {
		GraphicsLoop.g = g;
	}

    @Override
	//The tick method is overall a general method for what each 
	//object needs to do each tick 
	//(IT IS LITERALLY THE SAME AS THE RENDER METHOD)
    public void tick() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        GraphicsLoop.setG(bs.getDrawGraphics());
        GraphicsLoop.getG().clearRect(0, 0, WIDTH, HEIGHT);
        //End draw
        bs.show();
		GraphicsLoop.setG(null);
    }
    
}
