package awtgl.camera;

import awtgl.entity.Entity;
import awtgl.entity.EntityGroup;
import awtgl.entity.tile.Tile;
import awtgl.math.Vector2i;

public class Camera {
    
    private Entity target;
    private Vector2i pos;
    private Vector2i size;
    private EntityGroup<Tile> tiles;
    private boolean[] lockedDirsTBLR = {false, false, false, false};

    public Camera(Entity target) {

        this.target = target;

    }



    private void alignPos() {

        this.pos.x = (this.target.getPos().x + (this.target.getSize().x / 2)) - (this.size.x / 2);
        this.pos.y = (this.target.getPos().y + (this.target.getSize().y / 2)) - (this.size.y / 2);

    }



    private void checkBounds() {

        this.alignPos();

    }



    public void update() {



    }



    public Entity getTarget() {
        return target;
    }



    public void setTarget(Entity target) {
        this.target = target;
    }



    public Vector2i getPos() {
        return pos;
    }



    public void setPos(Vector2i pos) {
        this.pos = pos;
    }



    public EntityGroup<Tile> getTiles() {
        return tiles;
    }



    public void setTiles(EntityGroup<Tile> tiles) {
        this.tiles = tiles;
    }



    public Vector2i getSize() {
        return size;
    }



    public void setSize(Vector2i size) {
        this.size = size;
    }



    public boolean[] getLockedDirsTBLR() {
        return lockedDirsTBLR;
    }



    public void setLockedDirsTBLR(boolean[] lockedAreas) {
        this.lockedDirsTBLR = lockedAreas;
    }

}
