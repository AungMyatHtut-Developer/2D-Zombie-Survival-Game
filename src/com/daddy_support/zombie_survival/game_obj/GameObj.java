package com.daddy_support.zombie_survival.game_obj;

import java.awt.*;

public abstract class GameObj {
    public void render(Graphics g, float cameraX, float cameraY) {}
    public abstract void render(Graphics g);
    public abstract void update();
}
