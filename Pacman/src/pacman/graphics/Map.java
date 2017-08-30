package pacman.graphics;

import java.awt.image.BufferedImage;
import pacman.LoopPart;
import pacman.utils.ImageLoader;

/**
 *
 * @author Bren
 */
public class Map implements LoopPart {
    
    private final int WIDTH = 28, HEIGHT = 28;
    private BufferedImage wallTexture, pelletTexture, superPelletTexture, pacmanTexture, gateTexture;
    private BufferedImage[] ghostTextures;
    public Map(){
        init();
    }
    
    public void init(){
        wallTexture = ImageLoader.loadImage("/images/world/wall.jpg");
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
        
    }
    
}
