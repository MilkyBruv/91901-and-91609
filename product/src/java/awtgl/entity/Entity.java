package awtgl.entity;

import awtgl.math.Vector2i;
import main.Updater;

public abstract class Entity {
    
    protected Vector2i pos;
    protected Vector2i size;
    protected boolean raycastable;

    public Updater updater;

    public Entity(Updater updater) {

        this.updater = updater;

    }



    public abstract void update();



    public Vector2i getPos() {
        return pos;
    }



    public void setPos(Vector2i pos) {
        this.pos = pos;
    }



    public Vector2i getSize() {
        return size;
    }



    public void setSize(Vector2i size) {
        this.size = size;
    }



    public boolean isRaycastable() {
        return raycastable;
    }



    public void setRaycastable(boolean raycastable) {
        this.raycastable = raycastable;
    }



    public Updater getUpdater() {
        return updater;
    }



    public void setUpdater(Updater updater) {
        this.updater = updater;
    }

}
