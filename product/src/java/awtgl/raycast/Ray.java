package awtgl.raycast;

import awtgl.math.Vector2i;

public class Ray {
    
    private Vector2i start;
    private Vector2i end;
    private int length;
    private int angleFromNorthToRight;

    private Raycaster caster;

    public Ray(Raycaster caster, int angleFromNorthToRight) {

        this.caster = caster;
        this.length = 0;

    }



    public void update() {

        

    }



    public void checkHit() {

        

    }

}
