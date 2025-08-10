package com.daddy_support.zombie_survival.game_screen_template;

public class Camera {

    private float x,y;
    private int viewportWidth,viewportHeight;
    private int mapWidth,mapHeight;
    private double threshold = 0.40;// 40% threshold  0.0 <- between -> 1.0

    public Camera(int viewportWidth, int viewportHeight, int mapWidth, int mapHeight) {
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public void update(float playerX, float playerY) {
        float relativeX = (playerX - x) / viewportWidth; //0.16
        float relativeY = (playerY - y) / viewportHeight;

        if (relativeX < threshold) { //0.16 < 0.40
            x -= (float) ((threshold - relativeX) * viewportWidth);
        } else if (relativeX > 1 - threshold) {
            x += (float) ((relativeX - (1 - threshold)) * viewportWidth);
        }

        if (relativeY < threshold) {
            y -= (float) ((threshold - relativeY) * viewportHeight);
        } else if (relativeY > 1 - threshold) {
            y += (float) ((relativeY - (1 - threshold)) * viewportHeight);
        }

        //clamping the map
        float maxX = mapWidth - viewportWidth;
        if (x < 0) {
            x = 0;
        } else if (x > maxX) {
            x = maxX;
        }

        float maxY = mapHeight - viewportHeight;
        if (y < 0) {
            y = 0;
        } else if (y > maxY) {
            y = maxY;
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
