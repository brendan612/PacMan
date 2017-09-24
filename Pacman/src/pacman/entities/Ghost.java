/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;

import java.awt.Point;
import pacman.entities.ghostHelp.GhostMovements;
import pacman.graphics.GraphicsLoop;
import pacman.entities.ghostHelp.GhostNames;
import pacman.graphics.Map;
import pacman.graphics.tiles.Tile;

/**
 *
 * @author Bren
 */
public class Ghost extends Entity {
	GhostNames name;
	
	public Ghost(GraphicsLoop gl, Point pos, GhostNames name) {
		super(gl, pos);
		this.name = name;
	}

	@Override
	public void tick() {
		switch(name){
			case Inky:
				GhostMovements.inky(pos);
				super.getGl().getG().drawImage(Map.ghostTextures[1], Map.ghostSpawn2.x, Map.ghostSpawn2.y,Tile.TILE_WIDTH ,Tile.TILE_HEIGHT , null);
				break;
			case Blinky:
				super.getGl().getG().drawImage(Map.ghostTextures[0], Map.ghostSpawn1.x, Map.ghostSpawn1.y,Tile.TILE_WIDTH ,Tile.TILE_HEIGHT , null);
				break;
			case Pinky:
				super.getGl().getG().drawImage(Map.ghostTextures[2], Map.ghostSpawn3.x, Map.ghostSpawn3.y,Tile.TILE_WIDTH ,Tile.TILE_HEIGHT , null);
				break;
			case Clyde:
				super.getGl().getG().drawImage(Map.ghostTextures[3], Map.ghostSpawn4.x, Map.ghostSpawn4.y,Tile.TILE_WIDTH ,Tile.TILE_HEIGHT , null);
				break;
		}
	}
    
}
