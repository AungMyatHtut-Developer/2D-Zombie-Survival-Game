package com.daddy_support.zombie_survival;

import com.daddy_support.zombie_survival.game_screen_template.DSGameScreen;
import com.daddy_support.zombie_survival.game_screen_template.helper.RenderCallback;
import com.daddy_support.zombie_survival.game_screen_template.helper.UpdateCallback;

import java.awt.*;

import static com.daddy_support.zombie_survival.constants.GameConstants.*;

public class GameWorld implements RenderCallback, UpdateCallback {

    private DSGameScreen gameScreen;
    private int x, y;

    public GameWorld() {
        gameScreen = new DSGameScreen(GAME_TITLE,GAME_WIDTH,GAME_HEIGHT,IS_RESIZABLE,this);
        gameScreen.setGameCallbacks(this, this);
        gameScreen.startGame();
    }


    @Override
    public void render(Graphics g) {
        //TODO: Game Objects Rendering
        g.setColor(Color.WHITE);
        g.fillRect(x,y, 40,40);
    }

    @Override
    public void update() {
        //TODO: Game Objects Update
    }

    public void move(int x, int y) {
        this.x+= x;
        this.y+= y;
    }

}
