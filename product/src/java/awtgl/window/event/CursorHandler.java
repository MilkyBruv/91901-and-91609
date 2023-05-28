package awtgl.window.event;

import awtgl.math.Vector2i;
import awtgl.window.InnerDisplay;

public class CursorHandler {

    private static InnerDisplay innerDisplay;
    private static Vector2i prevPos;

    public CursorHandler(InnerDisplay _innerDisplay) {

        innerDisplay = _innerDisplay;
        prevPos = new Vector2i(0);

    }



    public Vector2i getCursorPosition() {

        Vector2i pos = new Vector2i(0);

        try {

            pos.x = Math.round(Math.round(innerDisplay.getWindow().getContentPane().getMousePosition().x / (innerDisplay.getWindow().getContentPane().getWidth() / innerDisplay.getInnerWidth()) / innerDisplay.getScale()) - ((innerDisplay.getInnerX() / innerDisplay.getScale())));
            pos.y = Math.round(Math.round(innerDisplay.getWindow().getContentPane().getMousePosition().y / (innerDisplay.getWindow().getContentPane().getHeight() / innerDisplay.getInnerHeight()) / innerDisplay.getScale()) - ((innerDisplay.getInnerY() / innerDisplay.getScale())));

            prevPos.x = pos.x;
            prevPos.y = pos.y;

        } catch (NullPointerException e) {

            pos = prevPos;

        }

        return pos;

    }

}