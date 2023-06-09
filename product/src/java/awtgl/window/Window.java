package awtgl.window;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import awtgl.window.event.MouseHandler;

public class Window extends JFrame {

    private InnerDisplay innerDisplay;

    public final static int WINDOWED = 0;
    public final static int FULLSCREEN = 1;

    public Window(int width, int height, String title, int mode) {

        System.setProperty("sun.java2d.opengl", "true");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);

        if (mode == WINDOWED) {
        
            this.setPreferredSize(new Dimension(width, height));
            this.setResizable(true);

        } else if (mode == FULLSCREEN) {

            GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = environment.getDefaultScreenDevice();

            this.setUndecorated(true);
            this.setResizable(false);

            if (device.isFullScreenSupported()) {

                device.setFullScreenWindow(this);

            } else {

                System.err.println("Fullscreen not supported");
        
                this.setPreferredSize(new Dimension(width, height));
                this.setResizable(true);

            }

        }

    }



    public void setInnerDisplay(InnerDisplay innerDisplay) {

        this.innerDisplay = innerDisplay;

        MouseHandler mouseButtonHandler = new MouseHandler();
        this.addMouseListener(mouseButtonHandler);

        this.add(innerDisplay);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }



    public void start() {

        this.innerDisplay.startThread();

    }

}