/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
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

    private Image[] playerImage = new Image[2];
    private Map map;
    private InputDevice id;
    private int oldDir;

    private AffineTransform identity,trans;
    private long lastPic, coolDown = 10, timer = coolDown;

    public Player(InputDevice id, GraphicsLoop gl, Point pos, Map map) {
        super(gl, pos);
        this.id = id;
        this.map = map;
        super.setPos(Map.playerSpawn);
        playerImage[0] = Map.pacmanTexture[0];
        playerImage[1] = Map.pacmanTexture[1];

        identity = new AffineTransform();
        trans = new AffineTransform();
        trans.setTransform(identity);
        
        
    }
    //skillfully assigning responsibilities to objects
    //identifying the problem and its requirements
    //Finding a conceptual solution
    //finding conceptual objects

    @Override
    public void tick() {
        timer += System.currentTimeMillis() - lastPic;
        lastPic = System.currentTimeMillis();
        move();
        checkMove();
        if (timer > 0) {
            super.getGl().getG().drawImage(playerImage[0], super.getPos().x, super.getPos().y, 32, 32, null);
            timer--;
        } else if (timer > -10) {
            super.getGl().getG().drawImage(playerImage[1], super.getPos().x, super.getPos().y, 32, 32, null);
            timer--;
        } else {
            timer = coolDown;
            super.getGl().getG().drawImage(playerImage[0], super.getPos().x, super.getPos().y, 32, 32, null);
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
                    trans.rotate(Math.toRadians(90));
                    break;
                case 1:
                    newPos.x -= 2;
                    oldDir = id.direction();
                    trans.rotate(Math.toRadians(0));
                    break;
                case 2:
                    newPos.y += 2;
                    oldDir = id.direction();
                    trans.rotate(Math.toRadians(270));
                    break;
                case 3:
                    newPos.x += 2;
                    oldDir = id.direction();
                    trans.rotate(Math.toRadians(180));
                    break;
            }
            if (super.getGl().getG() != null) {
                bounds.x = newPos.x;
                bounds.y = newPos.y;
            }
        }
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
