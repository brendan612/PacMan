package pacman.graphics;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    public static final int WIDTH = 28, HEIGHT = 31;
    public static BufferedImage emptyTexture, pelletTexture, superPelletTexture, gateTexture;
    public static BufferedImage[] ghostTextures = new BufferedImage[4],pacmanTexture = new BufferedImage[2];
    public static HashMap<String, BufferedImage> walls = new HashMap<>();
    public static Point playerSpawn, ghostSpawn1, ghostSpawn2, ghostSpawn3, ghostSpawn4;
    
    public static int[][] tiles, detailedTiles;
    public ArrayList<Tile> tileMap = new ArrayList<>();
    private String[] tokens = new String[868];
    public Map(GraphicsLoop gl) {
        this.gl = gl;
        init();
    }

    public void init() {
        emptyTexture = ImageLoader.loadImage("/images/map/empty.jpg");
        loadWallTextures();
        gateTexture = ImageLoader.loadImage("/images/map/gate.jpg");
        pelletTexture = ImageLoader.loadImage("/images/entities/pellet.jpg");
        superPelletTexture = ImageLoader.loadImage("/images/entities/super-pellet.jpg");
        pacmanTexture[0] = ImageLoader.loadImage("/images/entities/pacman-animated.gif");
        pacmanTexture[1] = ImageLoader.loadImage("/images/entities/pacman2.gif");
        ghostTextures[0] = ImageLoader.loadImage("/images/entities/blinky.jpg");
        ghostTextures[1] = ImageLoader.loadImage("/images/entities/pinky.jpg");
        ghostTextures[2] = ImageLoader.loadImage("/images/entities/inky.jpg");
        ghostTextures[3] = ImageLoader.loadImage("/images/entities/clyde.jpg");

        loadMapAsString("mapLayout.txt");
        
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                tileMap.add(new Tile(null,Utils.parseInt(tokens[(x +y * WIDTH)]),x*Tile.TILE_WIDTH*2,y*Tile.TILE_HEIGHT*2));
            }
        }
    }
    @Override
    public void tick() {
        
        tileMap.forEach((t) -> {
            t.tick(gl.getG());
        });
        
    }
    private void loadMapAsString(String path) {
        String file = Utils.loadFileAsString(path);
        tokens = file.split("\\s+");

        detailedTiles = new int[WIDTH][HEIGHT];
        tiles = new int[WIDTH][HEIGHT];
        
        int ghostCount = 0;
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if(Utils.parseInt(tokens[(x + y * WIDTH)]) > 9){
                    detailedTiles[x][y] = Utils.parseInt(tokens[(x +y * WIDTH)]);
                    tiles[x][y] = 3;
                } else{
                    detailedTiles[x][y] = Utils.parseInt(tokens[(x + y * WIDTH)]);
                    tiles[x][y] = Utils.parseInt(tokens[(x + y * WIDTH)]);
                }
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
        walls.put("DBL-Horizontal", ImageLoader.loadImage("/images/map/walls/width1/DBL-Horizontal.jpg"));
        walls.put("DBL-Vertical", ImageLoader.loadImage("/images/map/walls/width1/DBL-Vertical.jpg"));
        walls.put("DBL-TR-Corner", ImageLoader.loadImage("/images/map/walls/width1/DBL-TR-Corner.jpg"));
        walls.put("DBL-BR-Corner", ImageLoader.loadImage("/images/map/walls/width1/DBL-BR-Corner.jpg"));
        walls.put("DBL-BL-Corner", ImageLoader.loadImage("/images/map/walls/width1/DBL-BL-Corner.jpg"));
        walls.put("DBL-TL-Corner", ImageLoader.loadImage("/images/map/walls/width1/DBL-TL-Corner.jpg"));
        
        walls.put("SNG-Horizontal", ImageLoader.loadImage("/images/map/walls/width2/SNG-Horizontal.jpg"));
        walls.put("SNG-Vertical", ImageLoader.loadImage("/images/map/walls/width2/SNG-Vertical.jpg"));
        walls.put("SNG-TR-Corner", ImageLoader.loadImage("/images/map/walls/width2/SNG-TR-Corner.jpg"));
        walls.put("SNG-BR-Corner", ImageLoader.loadImage("/images/map/walls/width2/SNG-BR-Corner.jpg"));
        walls.put("SNG-BL-Corner", ImageLoader.loadImage("/images/map/walls/width2/SNG-BL-Corner.jpg"));
        walls.put("SNG-TL-Corner", ImageLoader.loadImage("/images/map/walls/width2/SNG-TL-Corner.jpg"));
        
        
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    
}
