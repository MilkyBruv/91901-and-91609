package awtgl.window;

import java.awt.Graphics;

public abstract class GameUpdater {

    protected Window window;
    protected InnerDisplay innerDisplay;

    public GameUpdater(Window window, InnerDisplay innerDisplay) {

        this.window = window;
        this.innerDisplay = innerDisplay;

    }

    public abstract void update();

    public abstract void draw(Graphics g);

}
