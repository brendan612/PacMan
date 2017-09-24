package pacman.entities;

import java.awt.image.BufferedImage;

public class Animate{
    private long timer,lastTime;
    private int speed,index;
    private BufferedImage[] frames;
    public Animate(int speed){
        this.speed = speed;
        
    }
    
    public void tick(BufferedImage ... images){
        frames = images;
        
        timer+= System.currentTimeMillis()- lastTime;
        lastTime = System.currentTimeMillis();
        
        if(timer > speed){
            index++;
            timer = 0;
            if (index >= frames.length)
                index = 0;
        }
    }
    
    public BufferedImage getCurrent(){
        return frames[index];
    }
}
