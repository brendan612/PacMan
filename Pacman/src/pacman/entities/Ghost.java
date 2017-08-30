/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;

import java.awt.Point;
import pacman.graphics.GraphicsLoop;

/**
 *
 * @author Bren
 */
public class Ghost extends Entity {

	public Ghost(GraphicsLoop gl, Point pos) {
		super(gl, pos);
	}

	@Override
	public void tick() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
    
}
