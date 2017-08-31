package pacman.graphics;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
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
    private final int WIDTH = 28, HEIGHT = 31;
    public static BufferedImage emptyTexture, wallTexture, pelletTexture, superPelletTexture, pacmanTexture, gateTexture;
    public static BufferedImage[] ghostTextures = new BufferedImage[4];
    public static HashMap<BufferedImage,String> walls = new HashMap<>();
    public static Point playerSpawn, ghostSpawn1, ghostSpawn2, ghostSpawn3, ghostSpawn4;
    
    public static int[][] tiles;

    public Map(GraphicsLoop gl) {
        this.gl = gl;
        init();
    }

    public void init() {
        emptyTexture = ImageLoader.loadImage("/images/map/empty.jpg");
        loadWallTextures();
        wallTexture = ImageLoader.loadImage("/images/map/wall.jpg");
        gateTexture = ImageLoader.loadImage("/images/map/gate.jpg");
        pelletTexture = ImageLoader.loadImage("/images/entities/pellet.jpg");
        superPelletTexture = ImageLoader.loadImage("/images/entities/super-pellet.jpg");
        pacmanTexture = ImageLoader.loadImage("/images/entities/pacman.jpg");
        ghostTextures[0] = ImageLoader.loadImage("/images/entities/blinky.jpg");
        ghostTextures[1] = ImageLoader.loadImage("/images/entities/pinky.jpg");
        ghostTextures[2] = ImageLoader.loadImage("/images/entities/inky.jpg");
        ghostTextures[3] = ImageLoader.loadImage("/images/entities/clyde.jpg");
        loadMapAsString("mapLayout.txt");
    }

    @Override
    public void tick() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                getTile(x, y).tick(gl.getG(), (int) (x * Tile.TILE_WIDTH * 2),
                        (int) (y * Tile.TILE_HEIGHT * 2));
                //  System.out.println(getTile(x,y).id);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= WIDTH || y >= HEIGHT) {
            return Tile.empty;
        }
        try {
            Tile t = Tile.tiles[tiles[x][y]];
            if (t == null) {
                return Tile.empty;
            }
            return t;
        } catch (IndexOutOfBoundsException e) {
            return Tile.empty;
        }

    }

    private void loadMapAsString(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        tiles = new int[WIDTH][HEIGHT];
        int ghostCount = 0;
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * WIDTH)]);
                
                if (Utils.parseInt(tokens[(x + y * WIDTH)]) == 5) {
                    playerSpawn = new Point(x * Tile.TILE_WIDTH*2, y * Tile.TILE_HEIGHT*2);
                    
                } else if (Utils.parseInt(tokens[(x + y * WIDTH)]) == 6) {
                    ghostCount++;
                    switch (ghostCount) {
                        case 1:
                            ghostSpawn1 = new Point(x * Tile.TILE_WIDTH*2, y * Tile.TILE_HEIGHT*2);
                            break;
                        case 2:
                            ghostSpawn2 = new Point(x * Tile.TILE_WIDTH*2, y * Tile.TILE_HEIGHT*2);
                            break;
                        case 3:
                            ghostSpawn3 = new Point(x * Tile.TILE_WIDTH*2, y * Tile.TILE_HEIGHT*2);
                            break;
                        case 4:
                            ghostSpawn4 = new Point(x * Tile.TILE_WIDTH*2, y * Tile.TILE_HEIGHT*2);
                            break;

                    }
                }
            }
        }
    }
    private void loadWallTextures(){
        walls.put(ImageLoader.loadImage("/images/map/walls/width1/DBL-Horizontal.jpg"), "DBL-Horizontal");
        walls.put(ImageLoader.loadImage("/images/map/walls/width1/DBL-Vertical.jpg"), "DBL-Vertical");
        walls.put(ImageLoader.loadImage("/images/map/walls/width1/TR-Corner.jpg"), "DBL-TR-Corner");
        walls.put(ImageLoader.loadImage("/images/map/walls/width1/BR-Corner.jpg"), "DBL-BR-Corner");
        walls.put(ImageLoader.loadImage("/images/map/walls/width1/BL-Corner.jpg"), "DBL-BL-Corner");
        walls.put(ImageLoader.loadImage("/images/map/walls/width1/TL-Corner.jpg"), "DBL-TL-Corner");
        
        walls.put(ImageLoader.loadImage("/images/map/walls/width2/SNG-Horizontal.jpg"), "SNG-Horizontal");
        walls.put(ImageLoader.loadImage("/images/map/walls/width2/SNG-Vertical.jpg"), "SNG-Vertical");
        walls.put(ImageLoader.loadImage("/images/map/walls/width2/TR-Corner.jpg"), "SNG-TR-Corner");
        walls.put(ImageLoader.loadImage("/images/map/walls/width2/BR-Corner.jpg"), "SNG-BR-Corner");
        walls.put(ImageLoader.loadImage("/images/map/walls/width2/BL-Corner.jpg"), "SNG-BL-Corner");
        walls.put(ImageLoader.loadImage("/images/map/walls/width2/TL-Corner.jpg"), "SNG-TL-Corner");
        
        
    }
    public Point getPlayerSpawn() {
        return playerSpawn;
    }

    public void setPlayerSpawn(Point playerSpawn) {
        this.playerSpawn = playerSpawn;
    }

    public Point getGhostSpawn1() {
        return ghostSpawn1;
    }

    public void setGhostSpawn1(Point ghostSpawn1) {
        this.ghostSpawn1 = ghostSpawn1;
    }

    public Point getGhostSpawn2() {
        return ghostSpawn2;
    }

    public void setGhostSpawn2(Point ghostSpawn2) {
        this.ghostSpawn2 = ghostSpawn2;
    }

    public Point getGhostSpawn3() {
        return ghostSpawn3;
    }

    public void setGhostSpawn3(Point ghostSpawn3) {
        this.ghostSpawn3 = ghostSpawn3;
    }

    public Point getGhostSpawn4() {
        return ghostSpawn4;
    }

    public void setGhostSpawn4(Point ghostSpawn4) {
        this.ghostSpawn4 = ghostSpawn4;
    }

}
