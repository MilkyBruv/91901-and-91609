package awtgl.entity;

import java.awt.image.BufferedImage;

import awtgl.math.Vector2i;
import main.Updater;

public abstract class DisplayEntity extends Entity {
    
    protected Vector2i drawPos;
    protected BufferedImage image;

    public DisplayEntity(Updater updater) {

        super(updater);

    }



    public abstract void update();

}
