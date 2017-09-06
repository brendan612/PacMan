package pacman.graphics.tiles;

import pacman.graphics.Map;

/**
 *
 * @author Bren
 */
public class EmptyTile extends Tile {

    public EmptyTile(int id) {
        super(Map.emptyTexture,id,0,0);
    }
    
	@Override
	public boolean isSolid(){
		return false;
	}
	
}
