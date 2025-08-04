package com.daddy_support.zombie_survival.game_screen_template;

import com.daddy_support.zombie_survival.game_screen_template.helper.UpdateCallback;

public class GlobalGameLoop implements Runnable{

    private DSPanel dsPanel;
    private Thread gameLoopThread;
    private boolean isGameRunning;

    private final int FPS = 60;//Frame Per Second
    private double framePerSecond = 1_000_000_000.00 / FPS;
    private long currentTimeTrackingFPS;
    private long recentTimeTrackingFPS;
    private long currentTimeTrackingUPS; //Update Per Second
    private long recentTimeTrackingUPS;
    private int fpsCounter;
    private int upsCounter;

    private UpdateCallback updateCallback;

    public GlobalGameLoop(DSPanel dsPanel) {
        this.dsPanel = dsPanel;
    }

    public void setUpdateCallback(UpdateCallback updateCallback) {
        this.updateCallback = updateCallback;
    }

    //start game loop
    public void start() {
        if(isGameRunning) return;

        isGameRunning = true;
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    //TODO : to add game pause and stop methods

    @Override
    public void run() {
        while (isGameRunning) {
            //main game loop (render and update)
            currentTimeTrackingUPS = System.nanoTime();
            if (currentTimeTrackingUPS - recentTimeTrackingUPS >= framePerSecond) {
                updateCallback.update();
                dsPanel.repaint();

                fpsCounter++;
                upsCounter++;
                recentTimeTrackingUPS = currentTimeTrackingUPS;
            }

            //fps tracker
            currentTimeTrackingFPS = System.nanoTime();
            if(currentTimeTrackingFPS - recentTimeTrackingFPS >= 1_000_000_000) {
                System.out.println("FPS: " + fpsCounter + " Ups: " + upsCounter);
                fpsCounter = 0;
                upsCounter = 0;
                recentTimeTrackingFPS = currentTimeTrackingFPS;
            }

        }
    }
}
