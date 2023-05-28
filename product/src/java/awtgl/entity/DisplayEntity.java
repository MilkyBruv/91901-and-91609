package awtgl.entity;

import awtgl.math.Vector2i;
import main.Updater;

public abstract class DisplayEntity extends Entity {
    
    public Vector2i drawPos;

    public DisplayEntity(Updater updater) {

        super(updater);

    }



    public abstract void update();

}
