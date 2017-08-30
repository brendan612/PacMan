/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;

import java.awt.Point;
import java.util.ArrayList;
import pacman.LoopPart;
import pacman.entities.ghostHelp.GhostNames;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;

/**
 *
 * @author Bren
 */
public class EntityManager implements LoopPart {
	GraphicsLoop graphL;
	ArrayList<Entity> entities = new ArrayList<>();
	InputDevice id;//Will add a settings page once we want to add more devices
	
    public EntityManager(InputDevice id, GraphicsLoop gl){
		this.id = id;
		entities.add(new Player(id, gl, new Point(150,150)));
        entities.add(new Ghost(gl,new Point(150,250),GhostNames.Blinky));
        entities.add(new Ghost(gl,new Point(150,250),GhostNames.Pinky));
        entities.add(new Ghost(gl,new Point(150,250),GhostNames.Inky));
        entities.add(new Ghost(gl,new Point(150,250),GhostNames.Clyde));
                
		graphL = gl;
	}
	
	@Override
	public void tick(){
		entities.forEach((e) -> {
			e.tick();
		});
		graphL.getBs().show();
	}
}
