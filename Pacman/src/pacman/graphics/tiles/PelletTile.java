package pacman.graphics.tiles;
import java.awt.Point;
import pacman.graphics.GraphicsLoop;
import pacman.graphics.Map;
/**
 *
 * @author Bren
 */
public class PelletTile extends Tile {
    public PelletTile(int id) {
        super(Map.pelletTexture, id);       
    }
    
}
