package com.daddy_support.zombie_survival;

import com.daddy_support.zombie_survival.entity.Direction;
import com.daddy_support.zombie_survival.entity.Player;
import com.daddy_support.zombie_survival.game_obj.GameObj;
import com.daddy_support.zombie_survival.game_screen_template.DSGameScreen;
import com.daddy_support.zombie_survival.game_screen_template.helper.RenderCallback;
import com.daddy_support.zombie_survival.game_screen_template.helper.UpdateCallback;

import java.awt.Graphics;
import java.util.List;

import static com.daddy_support.zombie_survival.constants.GameConstants.*;

public class GameWorld implements RenderCallback, UpdateCallback {

    private DSGameScreen gameScreen;
    private List<GameObj> gameObjList;
    private GameObj player;

    public GameWorld() {
        loadResources();
        gameScreen = new DSGameScreen(GAME_TITLE,GAME_WIDTH,GAME_HEIGHT,IS_RESIZABLE,this);
        gameScreen.setGameCallbacks(this, this);
        gameScreen.startGame();
    }

    private void loadResources() {
        player = new Player(100,100, 128, 128, Direction.W);
    }

    @Override
    public void render(Graphics g) {
        //TODO: Game Objects Rendering
        player.render(g);
    }

    @Override
    public void update() {
        //TODO: Game Objects Update
        player.update();
    }

    public Player getPlayer() {
        return (Player) player;
    }

}
