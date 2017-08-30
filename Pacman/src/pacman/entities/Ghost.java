/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;

import java.awt.Point;
import pacman.graphics.GraphicsLoop;
import pacman.graphics.Map;
import pacman.graphics.tiles.Tile;

/**
 *
 * @author Bren
 */
public class Ghost extends Entity {

    private int id;

    public Ghost(GraphicsLoop gl, Point pos, int id) {
        super(gl, pos);
        this.id = id;
    }

    @Override
    public void tick() {
        switch (id) {
            case 0:
                super.gl.getG().drawImage(Map.ghostTextures[0], Map.ghostSpawn1.x, Map.ghostSpawn1.y, Tile.TILE_WIDTH*2,Tile.TILE_WIDTH*2, null);
                break;
            case 1:
                super.gl.getG().drawImage(Map.ghostTextures[1], Map.ghostSpawn2.x, Map.ghostSpawn2.y,Tile.TILE_WIDTH*2,Tile.TILE_WIDTH*2, null);
                break;
            case 2:
                super.gl.getG().drawImage(Map.ghostTextures[2], Map.ghostSpawn3.x, Map.ghostSpawn3.y,Tile.TILE_WIDTH*2,Tile.TILE_WIDTH*2, null);
                break;
            case 3:
                super.gl.getG().drawImage(Map.ghostTextures[3], Map.ghostSpawn4.x, Map.ghostSpawn4.y,Tile.TILE_WIDTH*2,Tile.TILE_WIDTH*2, null);
                break;
        }

    }

}
