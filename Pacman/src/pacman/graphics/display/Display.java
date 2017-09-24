package pacman.graphics.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import pacman.userinput.InputDevice;

public class Display {
    
    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    private int width, height;
    
    public Display(String title, int width, int height, InputDevice id[]){
        this.title = title;
        this.width = width;
        this.height = height;
  
        createDisplay(id); //Initialize JFrame and Canvas
        
    }
    private void createDisplay(InputDevice id[]){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("Resources/images/external/pacLogo.jpg").getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	frame.addKeyListener((KeyListener)id[0].getEventListener());
        frame.addMouseListener((MouseListener)id[1]);
        frame.addMouseMotionListener((MouseMotionListener)id[1]);
        
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        canvas.setBackground(Color.black);
        
        canvas.addMouseListener((MouseListener)id[1]);
        canvas.addMouseMotionListener((MouseMotionListener)id[1]);
        frame.add(canvas);
        frame.pack();
		canvas.createBufferStrategy(3);
    }
    public Canvas getCanvas(){
        return canvas;
    }
    public JFrame getFrame(){
        return frame;
    }
}
