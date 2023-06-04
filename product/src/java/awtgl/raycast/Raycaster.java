package awtgl.raycast;

import java.util.List;

import awtgl.math.Vector2i;

import java.util.ArrayList;

public class Raycaster {
    
    private List<Ray> rays;
    private Vector2i pos;

    public Raycaster() {

        this.rays = new ArrayList<Ray>();

    }
    


    public void cast(int rayCount) {

        int degreeInterval = 360 / rayCount;
        int angle = 0;

        for (int i = 0; i < rayCount; i++) {
            
            Ray ray = new Ray(this, angle);

            angle += degreeInterval;

        }

    }



    public List<Ray> getRays() {
        return rays;
    }



    public void setRays(List<Ray> rays) {
        this.rays = rays;
    }



    public Vector2i getPos() {
        return pos;
    }



    public void setPos(Vector2i pos) {
        this.pos = pos;
    }

}
