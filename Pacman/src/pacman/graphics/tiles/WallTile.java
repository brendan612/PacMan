package pacman.graphics.tiles;

import pacman.graphics.Map;

/**
 *
 * @author Bren
 */
public class WallTile extends Tile {

    public WallTile(int... id) {
        super(null, 3,0,0);

    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
