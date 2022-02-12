package engineClasses;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Dimension;


public class Display {
    private JFrame frame;
    private Canvas canvas;

    private final String title;
    private final int width, height;

    //Getter
    public Canvas getCanvas(){
        return canvas;
    }
    //Constructor
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }
    public JFrame getFrame(){
        return frame;
    }

    //Setup the display
    private void createDisplay(){

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }
}
