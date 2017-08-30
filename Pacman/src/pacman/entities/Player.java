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
    @Override
    public void tick() {
		Point newPos = super.getPos();
                Tile t = map.getTile(super.getPos().x, super.getPos().y);
                if(!t.isSolid()){
                    System.out.println("test");
                    switch (id.direction()) {
                        case 0:
                            newPos.y -= 2;
                            break;
                        case 1:
                            newPos.x -= 2;
                            break;
                        case 2:
                            newPos.y += 2;
                            break;
                        case 3:
                            newPos.x += 2;
                            break;
                    }
                    if (super.getGl().getG() != null) {

                        bounds.x = super.getPos().x;
                        bounds.x = super.getPos().x;
                        super.getGl().getG().drawImage(playerImage[0], super.getPos().x, super.getPos().y, 32, 32, null);
                    }     
                } else
                    System.out.println("testicles");
		
                        
    }
    
}
