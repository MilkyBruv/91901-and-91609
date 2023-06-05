package awtgl.entity;

import java.awt.image.BufferedImage;

import awtgl.math.Vector2i;

public abstract class Entity {
    
    protected Vector2i pos;
    protected Vector2i drawPos;
    protected Vector2i size;
    protected BufferedImage image;
    protected boolean raycastable;

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



    public Vector2i getDrawPos() {
        return drawPos;
    }



    public void setDrawPos(Vector2i drawPos) {
        this.drawPos = drawPos;
    }



    public BufferedImage getImage() {
        return image;
    }



    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
}
