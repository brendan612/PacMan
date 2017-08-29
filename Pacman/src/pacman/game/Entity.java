/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

import java.awt.Point;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;

/**
 *
 * @author Bren
 */
public abstract class Entity implements LoopPart {
	InputDevice mover;
	GraphicsLoop gl;
	Point pos;
    
    public Entity(InputDevice id, GraphicsLoop gl, Point pos){
        mover = id;
		this.gl = gl;
		this.pos = pos;
    }

	public InputDevice getMover() {
		return mover;
	}

	public void setMover(InputDevice mover) {
		this.mover = mover;
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
