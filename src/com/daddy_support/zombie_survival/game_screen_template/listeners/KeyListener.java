package com.daddy_support.zombie_survival.game_screen_template.listeners;

import com.daddy_support.zombie_survival.GameWorld;
import com.daddy_support.zombie_survival.collision.CollisionManager;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private GameWorld gameWorld;
    private CollisionManager collisionManager;

    public KeyListener(GameWorld gameWorld, CollisionManager collisionManager) {
        this.gameWorld = gameWorld;
        this.collisionManager = collisionManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gameWorld.getPlayer().setMoving(true);
            case KeyEvent.VK_C -> collisionManager.toggleEditMode();
            case KeyEvent.VK_SPACE -> collisionManager.snapShotMap(gameWorld.getMap().getMapType().getKey());
        }

        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_Z && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)){
            collisionManager.removeLastShape();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gameWorld.getPlayer().setMoving(false);
        }
    }
}
