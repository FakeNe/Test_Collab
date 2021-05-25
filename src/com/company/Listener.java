package com.company;

import java.awt.*;
import java.awt.event.*;

public class Listener {

    private MouseMotionAdapter mouseMotionAdapter;
    private MouseAdapter mouseAdapter;
    private KeyAdapter keyAdapter;

    public static class Mouse{
        int x, y;
        boolean pressed = false;
    }

    public static class Key{
        boolean pressed = false;
    }

    public Mouse mouse = new Mouse();
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key space = new Key();

    public Listener(Component component){
        createAdapters();
        component.addMouseMotionListener(mouseMotionAdapter);
        component.addMouseListener(mouseAdapter);
        component.addKeyListener(keyAdapter);
    }

    private void createAdapters() {
        mouseMotionAdapter = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouse.x = e.getX();
                mouse.y = e.getY();
            }
        };
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouse.pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouse.pressed = false;
            }
        };
        keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    up.pressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    down.pressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    left.pressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    right.pressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    space.pressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    up.pressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    down.pressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    left.pressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    right.pressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    space.pressed = false;
                }
            }
        };
    }
}
