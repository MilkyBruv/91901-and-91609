package awtgl.camera;

import awtgl.entity.DisplayEntity;
import awtgl.math.Vector2i;
import main.Updater;

public class Camera {
    
    private DisplayEntity target;
    private Vector2i[] bounds;

    public Updater updater;

    public Camera() {

        

    }



    public void update() {}



    public DisplayEntity getTarget() {
        return target;
    }



    public void setTarget(DisplayEntity target) {
        this.target = target;
    }



    public Vector2i[] getBounds() {
        return bounds;
    }



    public void setBounds(Vector2i[] bounds) {
        this.bounds = bounds;
    }



    public Updater getUpdater() {
        return updater;
    }



    public void setUpdater(Updater updater) {
        this.updater = updater;
    }

}
