package pacman.graphics.tiles;

import pacman.graphics.Map;

/**
 *
 * @author Bren
 */
public class EmptyTile extends Tile {

    public EmptyTile(int id) {
        super(Map.emptyTexture,id);
    }
    
}
