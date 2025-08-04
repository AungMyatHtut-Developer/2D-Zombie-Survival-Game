package com.daddy_support.zombie_survival.game_screen_template.listeners;

import com.daddy_support.zombie_survival.GameWorld;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private GameWorld gameWorld;

    public KeyListener(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> gameWorld.move(0, -5);
            case KeyEvent.VK_RIGHT -> gameWorld.move(5, 0);
            case KeyEvent.VK_DOWN -> gameWorld.move(0, 5);
            case KeyEvent.VK_LEFT -> gameWorld.move(-5, 0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
