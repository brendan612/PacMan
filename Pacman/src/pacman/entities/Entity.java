/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;


import java.awt.Point;
import java.awt.Rectangle;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;
import pacman.graphics.tiles.Tile;

/**
 *
 * @author Bren
 */
public abstract class Entity implements LoopPart {
	GraphicsLoop gl;
	Point pos;
    
    protected Rectangle bounds;
    public Entity( GraphicsLoop gl, Point pos){
		this.gl = gl;
		this.pos = pos;
                bounds = new Rectangle(0,0,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
    }

	public GraphicsLoop getGl() {
		return gl;
	}

	public void setGl(GraphicsLoop gl) {
		this.gl = gl;
	}
    
    public Point getPos(){
        return pos;
    }
	
	public void setPos(Point pos){
		this.pos = pos;
	}

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
        
        
}
