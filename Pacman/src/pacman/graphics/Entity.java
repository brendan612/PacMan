/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.graphics;

import javafx.scene.effect.Light.Point;

/**
 *
 * @author Bren
 */
public abstract class Entity {
    
    public Entity(){
        
    }
    
    public Point getPos(){
        return null;
    }
    
    public boolean isAlive(){
        return false;
    }
}
