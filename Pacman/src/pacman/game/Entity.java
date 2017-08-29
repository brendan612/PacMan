/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.game;

import java.awt.Point;
import pacman.LoopPart;

/**
 *
 * @author Bren
 */
public abstract class Entity implements LoopPart {
    
    public Entity(){
        
    }
    
    public Point getPos(){
        return null;
    }
    
    public boolean isAlive(){
        return false;
    }
}
