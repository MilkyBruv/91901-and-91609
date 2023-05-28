package awtgl.window.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import awtgl.math.Vector2i;
import awtgl.window.InnerDisplay;

public class MouseHandler extends MouseAdapter {

    private static final Map<Integer, Boolean> pressedMouseButtons = new HashMap<Integer, Boolean>();
    private static Vector2i pos = new Vector2i(0);
    private static Vector2i prevPos = new Vector2i(0);
    private static InnerDisplay innerDisplay;

    public MouseHandler(InnerDisplay innerDisplay) {

        MouseHandler.innerDisplay = innerDisplay;

    }



    @Override
    public synchronized void mousePressed(MouseEvent e) {

        pressedMouseButtons.put(e.getButton(), true);

    }



    @Override
    public synchronized void mouseReleased(MouseEvent e) {

        pressedMouseButtons.put(e.getButton(), false);

    }



    @Override
    public synchronized void mouseMoved(MouseEvent e) {

        MouseHandler.pos.zero();

        try {

            MouseHandler.pos.x = Math.round(Math.round(e.getX() / (MouseHandler.innerDisplay.getWindow().getContentPane().getWidth() / MouseHandler.innerDisplay.getInnerWidth()) / MouseHandler.innerDisplay.getScale()) - ((MouseHandler.innerDisplay.getInnerX() / MouseHandler.innerDisplay.getScale())));
            MouseHandler.pos.y = Math.round(Math.round(e.getY() / (MouseHandler.innerDisplay.getWindow().getContentPane().getHeight() / MouseHandler.innerDisplay.getInnerHeight()) / MouseHandler.innerDisplay.getScale()) - ((MouseHandler.innerDisplay.getInnerY() / MouseHandler.innerDisplay.getScale())));

            MouseHandler.prevPos = MouseHandler.pos;

        } catch (NullPointerException err) {

            MouseHandler.pos = MouseHandler.prevPos;

        }

    }



    @Override
    public synchronized void mouseDragged(MouseEvent e) {

        MouseHandler.pos.zero();

        try {

            MouseHandler.pos.x = Math.round(Math.round(e.getX() / (MouseHandler.innerDisplay.getWindow().getContentPane().getWidth() / MouseHandler.innerDisplay.getInnerWidth()) / MouseHandler.innerDisplay.getScale()) - ((MouseHandler.innerDisplay.getInnerX() / MouseHandler.innerDisplay.getScale())));
            MouseHandler.pos.y = Math.round(Math.round(e.getY() / (MouseHandler.innerDisplay.getWindow().getContentPane().getHeight() / MouseHandler.innerDisplay.getInnerHeight()) / MouseHandler.innerDisplay.getScale()) - ((MouseHandler.innerDisplay.getInnerY() / MouseHandler.innerDisplay.getScale())));

            MouseHandler.prevPos = MouseHandler.pos;

        } catch (NullPointerException err) {

            MouseHandler.pos = MouseHandler.prevPos;

        }

    }



    public static boolean isButtonPressed(int button) {

        return pressedMouseButtons.getOrDefault(button, false);

    }



    public static boolean isButtonReleased(int button) {

        return pressedMouseButtons.getOrDefault(button, true);

    }



    public static Vector2i getPosition() {

        return MouseHandler.pos;

    }

}
