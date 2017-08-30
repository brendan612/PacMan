package pacman.graphics.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile{

    public static Tile[] tiles = new Tile[5];
    public static Tile empty = new EmptyTile(0);
    public static Tile pellet = new PelletTile(1);
    public static Tile superPellet = new SuperPelletTile(2);
    public static Tile wall = new WallTile(3);
    public static Tile gate = new GateTile(4);

    public static final int TILE_WIDTH = 8,
            TILE_HEIGHT = 8;

    public BufferedImage texture;
    public final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
    }

    public void tick(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, null);
    }

    public boolean isSolid() {
        return false;
    }
}
