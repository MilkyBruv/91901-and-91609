package awtgl.entity.tile;

import awtgl.entity.Entity;

public class Tile extends Entity {

    protected int id;

    public Tile(int id) {
        
        this.id = id;
        
    }
    
    
    
    public void update() {

        //

    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

}
