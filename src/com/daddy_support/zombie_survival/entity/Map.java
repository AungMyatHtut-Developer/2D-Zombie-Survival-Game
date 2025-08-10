package com.daddy_support.zombie_survival.entity;

import com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.MAP_TYPE;
import com.daddy_support.zombie_survival.resource_loader.SpriteStore;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map {

    private MAP_TYPE mapType;
    private int width, height;
    private BufferedImage mapImage;

    public Map(MAP_TYPE mapType) {
        this.mapType = mapType;
        mapImage = SpriteStore.getMap(mapType);
        width = mapImage.getWidth();
        height = mapImage.getHeight();
    }

    public void render(Graphics g, float cameraX, float cameraY) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(mapImage, (int) -cameraX, (int) -cameraY, width, height, null);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
