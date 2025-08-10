package com.daddy_support.zombie_survival.game_screen_template.listeners;

import com.daddy_support.zombie_survival.GameWorld;
import com.daddy_support.zombie_survival.game_screen_template.Camera;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class MouseListener implements MouseMotionListener , java.awt.event.MouseListener {

    private GameWorld gameWorld;
    private Camera camera;

    public MouseListener(GameWorld gameWorld, Camera camera) {
        this.gameWorld = gameWorld;
        this.camera = camera;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        float worldCameraX = camera.getX() + e.getX();
        float worldCameraY = camera.getY() + e.getY();
        gameWorld.getPlayer().updateDirectionBasedOnMouseMovement(worldCameraX, worldCameraY);
    }
}
