package com.daddy_support.zombie_survival.game_screen_template.listeners;

import com.daddy_support.zombie_survival.GameWorld;
import com.daddy_support.zombie_survival.collision.CollisionManager;
import com.daddy_support.zombie_survival.game_screen_template.Camera;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public class MouseListener implements MouseMotionListener , java.awt.event.MouseListener {

    private GameWorld gameWorld;
    private Camera camera;
    private CollisionManager collisionManager;

    public MouseListener(GameWorld gameWorld, Camera camera, CollisionManager collisionManager) {
        this.gameWorld = gameWorld;
        this.camera = camera;
        this.collisionManager = collisionManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (collisionManager.isEditMode()) {

            float gameWorldX = e.getX() + camera.getX();
            float gameWorldY = e.getY() + camera.getY();

            if(e.getButton() == MouseEvent.BUTTON1) {
                collisionManager.startNewShape();
                collisionManager.addVertexToCurrentShape((int) gameWorldX, (int) gameWorldY);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                collisionManager.closeCurrentShape();
            }


        }
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
