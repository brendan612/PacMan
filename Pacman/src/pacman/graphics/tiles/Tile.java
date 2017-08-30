package pacman.graphics.tiles;

import java.awt.image.BufferedImage;
import pacman.entities.Ghost;
import pacman.entities.Player;

public class Tile {
   
//    public static Tile[] tiles = new Tile[4];
//    public static Tile pellet = new PelletTile(1);
//    public static Tile superPellet = new SuperPelletTile(2);
//    public static Tile wall = new WallTile(3);
//    public static Tile gate = new GateTile(4);
    
    public static final int TILE_WIDTH = 8,
                            TILE_HEIGHT = 8;
    
    public BufferedImage texture;
    public final int id;
    
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
    }
}
