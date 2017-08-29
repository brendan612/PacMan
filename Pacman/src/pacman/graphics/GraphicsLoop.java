/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.graphics;

import pacman.LoopPart;
import pacman.graphics.display.Display;

public class GraphicsLoop implements LoopPart {
    private final String TITLE = "Pac-Man";
    private final int WIDTH = 500, HEIGHT = 500;
    private Display display;
    public GraphicsLoop() {
        display = new Display(TITLE,WIDTH,HEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
