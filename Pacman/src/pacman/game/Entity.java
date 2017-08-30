/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

import java.awt.Point;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;

/**
 *
 * @author Bren
 */
public abstract class Entity implements LoopPart {
	GraphicsLoop gl;
	Point pos;
    
    public Entity( GraphicsLoop gl, Point pos){
		this.gl = gl;
		this.pos = pos;
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
}
