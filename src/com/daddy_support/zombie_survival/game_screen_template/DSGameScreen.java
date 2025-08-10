package com.daddy_support.zombie_survival.game_screen_template;

import com.daddy_support.zombie_survival.GameWorld;
import com.daddy_support.zombie_survival.game_screen_template.helper.RenderCallback;
import com.daddy_support.zombie_survival.game_screen_template.helper.UpdateCallback;
import com.daddy_support.zombie_survival.game_screen_template.listeners.KeyListener;
import com.daddy_support.zombie_survival.game_screen_template.listeners.MouseListener;

public class DSGameScreen {

    private DSRenderFrame gameFrame;
    private DSPanel gamePanel;
    private GlobalGameLoop globalGameLoop;
    private GameWorld gameWorld;

    public DSGameScreen(String title, int width, int height, boolean isResizable, GameWorld gameWorld, Camera camera) {
        this.gameWorld = gameWorld;
        KeyListener keyListener = new KeyListener(this.gameWorld);
        MouseListener mouseListener = new MouseListener(this.gameWorld, camera);

        gamePanel = new DSPanel(width, height);
        gamePanel.addKeyListener(keyListener);
        gamePanel.addMouseListener(mouseListener);
        gamePanel.addMouseMotionListener(mouseListener);
        gameFrame = new DSRenderFrame(gamePanel, title, isResizable);
        gamePanel.setFocusable(true);
        globalGameLoop = new GlobalGameLoop(gamePanel);
    }

    public void setGameCallbacks(UpdateCallback gameUpdateCallback, RenderCallback renderCallback) {
        globalGameLoop.setUpdateCallback(gameUpdateCallback);
        gamePanel.setRenderCallback(renderCallback);
    }

    public void startGame() {
        gamePanel.createBuffer();
        globalGameLoop.start();
        gameFrame.show();
    }

}
