package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private final boolean[] keys;
    public boolean esc, keyW, keyS, keyA, keyD, space, lshift, keyX;
    public boolean up, down, left, right;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        esc = keys[KeyEvent.VK_ESCAPE];
        keyX = keys[KeyEvent.VK_X];

        keyW = keys[KeyEvent.VK_W];
        keyS = keys[KeyEvent.VK_S];
        keyA = keys[KeyEvent.VK_A];
        keyD = keys[KeyEvent.VK_D];

        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];

        space = keys[KeyEvent.VK_SPACE];
        lshift = keys[KeyEvent.VK_SHIFT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
