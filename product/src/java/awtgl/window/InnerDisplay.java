package awtgl.window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.Updater;

public class InnerDisplay extends JPanel implements Runnable {
    
    private Thread thread;
    private Window window;
    private Updater updater;

    private int innerX;
    private int innerY;
    private int innerHeight;
    private int innerWidth;
    private int baseInnerHeight;
    private int baseInnerWidth;
    private float scale;
    private BufferedImage innerDisplayImage;

    public InnerDisplay(int width, int height, Window window) {

        this.window = window;
        this.updater = new Updater(window, this);

        this.innerX = 0;
        this.innerY = 0;
        this.innerWidth = width;
        this.innerHeight = height;
        this.baseInnerWidth = width;
        this.baseInnerHeight = height;
        this.innerDisplayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        this.setPreferredSize(new Dimension(window.getContentPane().getWidth(), window.getContentPane().getHeight()));
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }



    public void update() {

        this.updater.update();

    }



    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D idg2d = (Graphics2D) this.innerDisplayImage.getGraphics();
        
            this.updater.draw(this.innerDisplayImage.getGraphics());
        
        idg2d.dispose();

        Graphics2D g2d = (Graphics2D) g;

            this.scale = Math.min(this.window.getContentPane().getWidth() / this.baseInnerWidth, this.window.getContentPane().getHeight() / this.baseInnerHeight);
            this.innerWidth = Math.round(this.baseInnerWidth * this.scale);
            this.innerHeight = Math.round(this.baseInnerHeight * this.scale);
            this.innerX = (this.window.getContentPane().getWidth() / 2) - (this.innerWidth / 2);
            this.innerY = (this.window.getContentPane().getHeight() / 2) - (this.innerHeight / 2);

            g2d.drawImage(this.innerDisplayImage, this.innerX, this.innerY, this.innerWidth, this.innerHeight, null);

        g2d.dispose();

    }



    public void startThread() {

        this.thread = new Thread(this);
        this.thread.start();

    }



    @Override
    public void run() {

        double drawInterval = 1000000000 / 60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (this.thread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                this.update();
                this.repaint();

                delta--;

            }

        }

    }



    public Window getWindow() {

        return this.window;

    }



    public Thread getThread() {
        return thread;
    }



    public void setThread(Thread thread) {
        this.thread = thread;
    }



    public void setWindow(Window window) {
        this.window = window;
    }



    public Updater getUpdater() {
        return updater;
    }



    public void setUpdater(Updater updater) {
        this.updater = updater;
    }



    public int getInnerX() {
        return innerX;
    }



    public void setInnerX(int innerX) {
        this.innerX = innerX;
    }



    public int getInnerY() {
        return innerY;
    }



    public void setInnerY(int innerY) {
        this.innerY = innerY;
    }



    public int getInnerHeight() {
        return innerHeight;
    }



    public void setInnerHeight(int innerHeight) {
        this.innerHeight = innerHeight;
    }



    public int getInnerWidth() {
        return innerWidth;
    }



    public void setInnerWidth(int innerWidth) {
        this.innerWidth = innerWidth;
    }



    public int getBaseInnerHeight() {
        return baseInnerHeight;
    }



    public void setBaseInnerHeight(int baseInnerHeight) {
        this.baseInnerHeight = baseInnerHeight;
    }



    public int getBaseInnerWidth() {
        return baseInnerWidth;
    }



    public void setBaseInnerWidth(int baseInnerWidth) {
        this.baseInnerWidth = baseInnerWidth;
    }



    public float getScale() {
        return scale;
    }



    public void setScale(float scale) {
        this.scale = scale;
    }



    public BufferedImage getInnerDisplayImage() {
        return innerDisplayImage;
    }



    public void setInnerDisplayImage(BufferedImage innerDisplayImage) {
        this.innerDisplayImage = innerDisplayImage;
    }
    
}
