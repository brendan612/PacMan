package pacman.entities;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;
import pacman.graphics.Map;
import pacman.graphics.tiles.Tile;

/**
 *
 * @author Bren
 */
public class Player extends Entity implements LoopPart {

    private BufferedImage current;
    private Map map;
    private InputDevice id;
    private int oldDir;

    public static int points = 0;
    public static Point pos2;
    private Animate anim;
    
    public Player(InputDevice id, GraphicsLoop gl, Point pos, Map map) {
        super(gl, pos);
        this.id = id;
        this.map = map;
        super.setPos(Map.playerSpawn);
        current = Map.pacmanTexture[0];
        pos2 = pos;
        anim = new Animate(250);
    }
    //skillfully assigning responsibilities to objects
    //identifying the problem and its requirements
    //Finding a conceptual solution
    //finding conceptual objects

    @Override
    public void tick() {
        move();
        checkMove();
        anim.tick(current,Map.pacmanTexture[4]);
        super.getGl().getG().drawImage(anim.getCurrent(), super.getPos().x, super.getPos().y, 32, 32, null);
        
        Tile t = Tile.tiles[Map.tiles[Player.pos2.x /(Tile.TILE_WIDTH * 2)][Player.pos2.y / (Tile.TILE_HEIGHT * 2)]];
        if(bounds.x == t.getBounds().x && bounds.y == t.getBounds().y && (t.id == 1 || t.id == 2)){
            t.texture = Map.emptyTexture;
            points+=5;
            System.out.println("his");
        }
    }

    private void move() {
        Point newPos = super.getPos();
        Tile[] t = getTiles();
        if (!t[0].isSolid() && !t[1].isSolid() && !t[2].isSolid() && !t[3].isSolid()) {
            switch (id.direction()) {
                case 0:
                    newPos.y -= 2;
                    oldDir = id.direction();
                   current = Map.pacmanTexture[1];
                    break;
                case 1:
                    newPos.x -= 2;
                    oldDir = id.direction();
                    current = Map.pacmanTexture[0];
                    break;
                case 2:
                    newPos.y += 2;
                    oldDir = id.direction();
                    current = Map.pacmanTexture[3];
                    break;
                case 3:
                    newPos.x += 2;
                    oldDir = id.direction();
                    current = Map.pacmanTexture[2];
                    break;
            }
            if (super.getGl().getG() != null) {
                bounds.x = newPos.x;
                bounds.y = newPos.y;
            }
        }
        pos2 = pos;
    }

    private void checkMove() {
        Tile[] t = getTiles();
        Point newPos = super.getPos();
        if (t[0].isSolid()) {
            newPos.y += 2;
        }
        if (t[1].isSolid()) {
            newPos.x += 2;
        }
        if (t[2].isSolid()) {
            newPos.y -= 2;
        }
        if (t[3].isSolid()) {
            newPos.x -= 2;
        }
    }

    private Tile[] getTiles() {
        Tile[] ret = {Tile.tiles[Map.tiles[super.getPos().x / (Tile.TILE_WIDTH * 2)][super.getPos().y / (Tile.TILE_HEIGHT * 2)]],
            Tile.tiles[Map.tiles[super.getPos().x / (Tile.TILE_WIDTH * 2)][super.getPos().y / (Tile.TILE_HEIGHT * 2)]],
            Tile.tiles[Map.tiles[super.getPos().x / (Tile.TILE_WIDTH * 2)][(super.getPos().y - 1) / (Tile.TILE_HEIGHT * 2) + 1]],
            Tile.tiles[Map.tiles[(super.getPos().x - 1) / (Tile.TILE_WIDTH * 2) + 1][super.getPos().y / (Tile.TILE_HEIGHT * 2)]]};
        
        return ret;
    }
}
