package pacman.graphics.tiles;
import java.awt.Graphics;
import pacman.graphics.Map;
/**
 *
 * @author Bren
 */
public class PelletTile extends Tile {
    public PelletTile(int id) {
        super(Map.pelletTexture, id,0,0);       
    }
    
}
