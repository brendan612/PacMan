/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.Image;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;

/**
 *
 * @author Bren
 */
public class Player extends Entity implements LoopPart{
    
    private Image[] playerImage = new Image[1];
	private GraphicsLoop graphL;
    
    public Player(GraphicsLoop gl){
		graphL = gl;
        try{
            playerImage[0] = ImageIO.read(getClass().getResourceAsStream("/images/external/pacman.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void tick() {
		if(graphL.getG() != null)
			graphL.getG().drawImage(playerImage[0], 250, 250, null);
    }
    
}
