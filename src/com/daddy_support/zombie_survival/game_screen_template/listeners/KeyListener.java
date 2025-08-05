package com.daddy_support.zombie_survival.game_screen_template.listeners;

import com.daddy_support.zombie_survival.GameWorld;
import com.daddy_support.zombie_survival.entity.Direction;

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
            case KeyEvent.VK_UP -> gameWorld.getPlayer().updateDirection(Direction.N);
            case KeyEvent.VK_RIGHT -> gameWorld.getPlayer().updateDirection(Direction.E);
            case KeyEvent.VK_DOWN -> gameWorld.getPlayer().updateDirection(Direction.S);
            case KeyEvent.VK_LEFT -> gameWorld.getPlayer().updateDirection(Direction.W);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
