/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Point;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;
import pacman.graphics.Map;
import pacman.graphics.tiles.Tile;

/**
 *
 * @author Bren
 */
public class Player extends Entity implements LoopPart{
    
    private Image[] playerImage = new Image[1];
    private Map map;
	private InputDevice id;
	private int oldDir;
        
    public Player(InputDevice id, GraphicsLoop gl, Point pos, Map map){
		super(gl, pos);
		this.id = id;
                this.map = map;
                super.setPos(Map.playerSpawn);
                System.out.println(Map.playerSpawn);
        try{
            playerImage[0] = ImageIO.read(getClass().getResourceAsStream("/images/entities/pacman.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	//skillfully assigning responsibilities to objects
	//identifying the problem and its requirements
	//Finding a conceptual solution
	//finding conceptual objects
    @Override
    public void tick() {
		Point newPos = super.getPos();
		Tile t = Tile.tiles[Map.tiles[super.getPos().x/(Tile.TILE_WIDTH*2)][super.getPos().y/(Tile.TILE_HEIGHT*2)]];
		Tile t2 = Tile.tiles[Map.tiles[super.getPos().x/(Tile.TILE_WIDTH*2)][super.getPos().y/(Tile.TILE_HEIGHT*2)]];
		Tile t3 = Tile.tiles[Map.tiles[super.getPos().x/(Tile.TILE_WIDTH*2)][(super.getPos().y-1)/(Tile.TILE_HEIGHT*2)+1]];
		Tile t4 = Tile.tiles[Map.tiles[(super.getPos().x-1)/(Tile.TILE_WIDTH*2)+1][super.getPos().y/(Tile.TILE_HEIGHT*2)]];
		if(!t.isSolid() && !t2.isSolid() && !t3.isSolid() && !t4.isSolid()){
			System.out.println("all not solid");
			switch (id.direction()) {
				case 0:
					newPos.y -= 2;
					oldDir = id.direction();
					break;
				case 1:
					newPos.x -= 2;
					oldDir = id.direction();
					break;
				case 2:
					newPos.y += 2;
					oldDir = id.direction();
					break;
				case 3:
					newPos.x += 2;
					oldDir = id.direction();
					break;
			}
			if (super.getGl().getG() != null) {
				bounds.x = newPos.x;
				bounds.y = newPos.y;
			}     
		}
		
		t = Tile.tiles[Map.tiles[super.getPos().x/(Tile.TILE_WIDTH*2)][super.getPos().y/(Tile.TILE_HEIGHT*2)]];
		t2 = Tile.tiles[Map.tiles[super.getPos().x/(Tile.TILE_WIDTH*2)][super.getPos().y/(Tile.TILE_HEIGHT*2)]];
		t3 = Tile.tiles[Map.tiles[super.getPos().x/(Tile.TILE_WIDTH*2)][(super.getPos().y-1)/(Tile.TILE_HEIGHT*2)+1]];
		t4 = Tile.tiles[Map.tiles[(super.getPos().x-1)/(Tile.TILE_WIDTH*2)+1][super.getPos().y/(Tile.TILE_HEIGHT*2)]];
		if(t.isSolid()){
			newPos.y += 2;
		}
		if(t2.isSolid()){
			newPos.x += 2;
		}
		if(t3.isSolid()){
			newPos.y -= 2;
		}
		if(t4.isSolid()){
			newPos.x -=2;
		}
		super.getGl().getG().drawImage(playerImage[0], super.getPos().x, super.getPos().y, 32, 32, null);           
    }
    
}
