package pacman.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pacman.LoopPart;
import pacman.graphics.tiles.Tile;
import pacman.utils.ImageLoader;
import pacman.utils.Utils;

/**
 *
 * @author Bren
 */
public class Map implements LoopPart {
    
    private GraphicsLoop gl;
    private final int WIDTH = 28, HEIGHT = 30;
    public static BufferedImage emptyTexture, wallTexture, pelletTexture, superPelletTexture, pacmanTexture, gateTexture;
    public static BufferedImage[] ghostTextures;
    private int[][] tiles;
    public Map(GraphicsLoop gl){
        this.gl = gl;
        init();
    }
    
    public void init(){
        emptyTexture = ImageLoader.loadImage("/images/map/empty.jpg");
        wallTexture = ImageLoader.loadImage("/images/map/wall.jpg");
        pelletTexture = ImageLoader.loadImage("images/entities/pellet.jpg");
        superPelletTexture = ImageLoader.loadImage("images/entities/super-pellet.jpg");
        pacmanTexture = ImageLoader.loadImage("/images/entities/pacman.jpg");
        ghostTextures[0] = ImageLoader.loadImage("/images/entities/blinky.jpg");
        ghostTextures[1] = ImageLoader.loadImage("/images/entities/pinky.jpg");
        ghostTextures[2] = ImageLoader.loadImage("/images/entities/inky.jpg");
        ghostTextures[3] = ImageLoader.loadImage("/images/entities/clyde.jpg");
    }

    @Override
    public void tick() {
        for (int y = 0; y < 30*16; y++){
            for(int x = 0; x < 28*16; x++){
                getTile(x,y).tick(gl.getG(), (int) (x * Tile.TILE_WIDTH), 
                                       (int) (y * Tile.TILE_HEIGHT));
            }
        }
    }
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= WIDTH || y >= HEIGHT)
            return Tile.empty;
        
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.empty;
        return t;
    }
    
    private void loadMapAsString(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        
        tiles = new int[WIDTH][HEIGHT];
        
        for (int y = 0; y < HEIGHT; y++){
            for(int x = 0; x < WIDTH; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * WIDTH)]);
            }
        }
    }
    
}
