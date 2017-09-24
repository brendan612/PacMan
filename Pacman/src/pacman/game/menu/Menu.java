package pacman.game.menu;

import java.awt.Graphics2D;
import pacman.LoopPart;
import pacman.graphics.GraphicsLoop;
import pacman.userinput.InputDevice;

public class Menu implements LoopPart{

    private GraphicsLoop gl;
    private InputDevice id[];

    
    private boolean active = true;
    public Menu(GraphicsLoop gl, InputDevice id[]) {
        this.gl = gl;
        this.id = id;
    }

    @Override
    public void tick() {
        render((Graphics2D)gl.getG());
    }

    
    private void render(Graphics2D g){
        
    }
    public GraphicsLoop getGl() {
        return gl;
    }

    public void setGl(GraphicsLoop gl) {
        this.gl = gl;
    }

    public InputDevice[] getId() {
        return id;
    }

    public void setId(InputDevice id[]) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
