package awtgl.window.event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class MouseHandler extends MouseAdapter {

    private static final Map<Integer, Boolean> pressedMouseButtons = new HashMap<Integer, Boolean>();

    @Override
    public synchronized void mousePressed(MouseEvent e) {

        pressedMouseButtons.put(e.getButton(), true);

    }



    @Override
    public synchronized void mouseReleased(MouseEvent e) {

        pressedMouseButtons.put(e.getButton(), false);

    }



    public static boolean isButtonPressed(int button) {

        return pressedMouseButtons.getOrDefault(button, false);

    }



    public static boolean isButtonReleased(int button) {

        return pressedMouseButtons.getOrDefault(button, true);

    }

}
