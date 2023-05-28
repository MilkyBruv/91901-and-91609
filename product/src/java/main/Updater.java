package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import awtgl.math.Vector2f;
import awtgl.math.Vector2i;
import awtgl.window.GameUpdater;
import awtgl.window.InnerDisplay;
import awtgl.window.Renderer;
import awtgl.window.Window;
import awtgl.window.event.KeyHandler;
import awtgl.window.event.Keys;
import awtgl.window.event.MouseHandler;

public class Updater extends GameUpdater {

    int x;
    int y;
    Vector2i pos;
    BufferedImage testImage;
    Random random;
    int rot = 0;

    public Updater(Window window, InnerDisplay innerDisplay) {
        
        super(window, innerDisplay);

        this.x = 0;
        this.y = 0;

        this.pos = new Vector2i(20, 20);
        
        this.random = new Random();

        try {

            this.testImage = ImageIO.read(new File("src/res/anim.png"));

        } catch (IOException e) {
            
            e.printStackTrace();

        }

    }

    @Override
    public void update() {

        if (KeyHandler.isKeyPressed(Keys.RIGHT)) {

            this.pos.x += 3;

        } if (KeyHandler.isKeyPressed(Keys.LEFT)) {
        
            this.pos.x -= 3;

        } if (KeyHandler.isKeyPressed(Keys.UP)) {

            this.pos.y -= 3;

        } if (KeyHandler.isKeyPressed(Keys.DOWN)) {

            this.pos.y += 3;

        }

        if (KeyHandler.isKeyPressed(Keys.R)) {

            this.rot += 1;

        } if (KeyHandler.isKeyPressed(Keys.L)) {

            this.rot -= 1;

        }

    }

    @Override
    public void draw(Graphics g) {

        Renderer.clear(g);
        
        Renderer.drawLine(new Vector2i(0), MouseHandler.getPosition(), 0xffffff, g);
        Renderer.drawBlendImage(this.testImage, this.pos, this.rot, 1, g);

    }
    
}
