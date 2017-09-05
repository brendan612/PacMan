package pacman.graphics.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import pacman.graphics.Map;

public class Tile{

    public static Tile[] tiles = new Tile[30];
    public static Tile empty = new EmptyTile(0);
    public static Tile pellet = new PelletTile(1);
    public static Tile superPellet = new SuperPelletTile(2);
    public static Tile wall = new WallTile(3,10,11,12,13,14,15,16,17,18,19,20);
    public static Tile gate = new GateTile(4);

    protected Rectangle bounds;
    public static final int TILE_WIDTH = 16,
            TILE_HEIGHT = 16;

    public BufferedImage texture;
    public int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
        bounds = new Rectangle(0,0,TILE_WIDTH,TILE_HEIGHT);
		tiles[5] = empty;
    }

    public void tick(Graphics g, int x, int y) {
        bounds.x = x;
        bounds.y = y;
        
        g.drawImage(texture, x, y,TILE_WIDTH*2,TILE_HEIGHT*2, null);
        
    }

    public boolean isSolid() {
        return false;
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
