/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

import java.util.ArrayList;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;

/**
 *
 * @author Bren
 */
public class EntityManager implements LoopPart {
	GraphicsLoop graphL;
	ArrayList<Entity> entities = new ArrayList<>();
    public EntityManager(GraphicsLoop gl){
		entities.add(new Player(gl));
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
