package pacman.graphics.tiles;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import pacman.entities.Player;
import pacman.graphics.Map;

public class Tile {

    public static Tile[] tiles = new Tile[30];
    public static Tile empty = new EmptyTile(0);
    public static Tile pellet = new PelletTile(1);
    public static Tile superPellet = new SuperPelletTile(2);
    public static Tile wall = new WallTile(3);
    public static Tile gate = new GateTile(4);

    protected Rectangle bounds;
    public static final int TILE_WIDTH = 16,
            TILE_HEIGHT = 16;

    public BufferedImage texture;
    public int id;

    private final int X, Y;
    
    public Tile(BufferedImage texture, int id, int x, int y) {
        this.texture = texture;
        this.id = id;
        this.X = x;
        this.Y = y;
        tiles[id] = this;
        bounds = new Rectangle(x, y, TILE_WIDTH, TILE_HEIGHT);
        tiles[5] = empty;

        getRealTextureAndID();
    }

    public void tick(Graphics g) {

         g.drawImage(texture, X, Y, TILE_WIDTH * 2, TILE_HEIGHT * 2, null);

    }

    private void getRealTextureAndID() {
        switch (id) {
            case 0:
                texture = Map.emptyTexture;
                break;
            case 1:
                texture = Map.pelletTexture;
                break;
            case 2:
                texture = Map.superPelletTexture;
                break;
            case 4:
                texture = Map.gateTexture;
                break;
            case 10:
                texture = Map.walls.get("DBL-BR-Corner");
                break;
            case 11:
                texture = Map.walls.get("DBL-Horizontal");
                break;
            case 12:
                texture = Map.walls.get("DBL-TL-Corner");
                break;
            case 13:
                texture = Map.walls.get("DBL-TR-Corner");
                break;
            case 14:
                texture = Map.walls.get("DBL-Vertical");
                break;
            case 15:
                texture = Map.walls.get("SNG-BL-Corner");
                break;
            case 16:
                texture = Map.walls.get("SNG-BR-Corner");
                break;
            case 17:
                texture = Map.walls.get("SNG-Horizontal");
                break;
            case 18:
                texture = Map.walls.get("SNG-TL-Corner");
                break;
            case 19:
                texture = Map.walls.get("SNG-TR-Corner");
                break;
            case 20:
                texture = Map.walls.get("SNG-Vertical");
                break;
            case 21:
                texture = Map.walls.get("DBL-BL-Corner");
                break;

        }
    }

    public boolean isSolid() {
        return id == 3 || id == 6 || id > 9;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
