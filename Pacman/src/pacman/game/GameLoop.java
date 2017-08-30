/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman.game;

import pacman.entities.EntityManager;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;

public class GameLoop implements LoopPart{
	GraphicsLoop graphL;
	EntityManager em;
	public GameLoop(InputDevice id, GraphicsLoop gl){
		em = new EntityManager(id, gl);
		graphL = gl;
	}
	/*
	*This will tick every frame of the game and will delegate the tasks
	*to whatever else needs to be told to do it's stuff for the frame
	*/
	@Override
	public void tick(){
		em.tick();
	}

    public void render() {
    }
}
