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

/**
 *
 * @author Bren
 */
public class Player extends Entity implements LoopPart{
    
    private Image[] playerImage = new Image[1];
	private InputDevice id;
    
    public Player(InputDevice id, GraphicsLoop gl, Point pos){
		super(gl, pos);
		this.id = id;
        try{
            playerImage[0] = ImageIO.read(getClass().getResourceAsStream("/images/external/pacLogo.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void tick() {
		Point newPos = super.getPos();
		switch(id.direction()){
			case 0:
				newPos.y -= 2;
				break;
			case 1:
				newPos.x -=2;
				break;
			case 2:
				newPos.y += 2;
				break;
			case 3:
				newPos.x += 2;
				break;
		};
		if(super.getGl().getG() != null)
			super.getGl().getG().drawImage(playerImage[0], super.getPos().x, super.getPos().y, null);
    }
    
}
