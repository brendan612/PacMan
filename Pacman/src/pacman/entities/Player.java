/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.entities;

import pacman.entities.Entity;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.Image;
import pacman.LoopPart;

/**
 *
 * @author Bren
 */
public class Player extends Entity implements LoopPart{
    
    private Image playerImage;
    
    public Player(){
        try{
            playerImage = ImageIO.read(getClass().getResourceAsStream("/images/external/pacman.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void tick() {

    }
    
}
