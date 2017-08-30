package pacman.graphics.tiles;

import pacman.graphics.Map;

/**
 *
 * @author Bren
 */
public class WallTile extends Tile {

    public WallTile(int id) {
        super(Map.wallTexture,id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
