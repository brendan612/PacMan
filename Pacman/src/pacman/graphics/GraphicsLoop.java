/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.graphics;

import java.awt.Color;
import pacman.entities.Player;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import pacman.LoopPart;
import pacman.graphics.display.Display;
import pacman.graphics.tiles.Tile;
import pacman.userinput.InputDevice;

public class GraphicsLoop implements LoopPart{
    private final String TITLE = "Pac-Man";
    private final int WIDTH = 28*32, HEIGHT = 31*32 + 100;
    
    private Display display;
    private Map map;
    public static final int mapOffset = 100;
    private BufferStrategy bs;
    private Graphics g;
    
    public GraphicsLoop(InputDevice id) {
        display = new Display(TITLE,WIDTH,HEIGHT, id);
        map = new Map(this);
    }

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public BufferStrategy getBs() {
		return bs;
	}

	public void setBs(BufferStrategy bs) {
		this.bs = bs;
	}
	

    @Override
    public void tick() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = (bs.getDrawGraphics());
        g.clearRect(0, 0, WIDTH, HEIGHT);
        map.tick();
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    
}
