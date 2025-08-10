package com.daddy_support.zombie_survival;

import com.daddy_support.zombie_survival.entity.Direction;
import com.daddy_support.zombie_survival.entity.Map;
import com.daddy_support.zombie_survival.entity.Player;
import com.daddy_support.zombie_survival.game_obj.GameObj;
import com.daddy_support.zombie_survival.game_screen_template.Camera;
import com.daddy_support.zombie_survival.game_screen_template.DSGameScreen;
import com.daddy_support.zombie_survival.game_screen_template.helper.RenderCallback;
import com.daddy_support.zombie_survival.game_screen_template.helper.UpdateCallback;
import com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.MAP_TYPE;

import java.awt.*;

import static com.daddy_support.zombie_survival.constants.GameConstants.*;

public class GameWorld implements RenderCallback, UpdateCallback {

    private DSGameScreen gameScreen;
    private GameObj player;

    private Map map;
    private Camera camera;

    public GameWorld() {
        loadResources();
        gameScreen = new DSGameScreen(GAME_TITLE, GAME_WIDTH, GAME_HEIGHT, IS_RESIZABLE, this, camera);
        gameScreen.setGameCallbacks(this, this);
        gameScreen.startGame();
    }

    private void loadResources() {
        map = new Map(MAP_TYPE.MAP_1);
        camera = new Camera(GAME_WIDTH, GAME_HEIGHT, map.getWidth(), map.getHeight());
        player = new Player(100, 100, 128, 128, Direction.W);
    }

    @Override
    public void render(Graphics g) {
        map.render(g, camera.getX(), camera.getY());
        player.render(g, camera.getX(), camera.getY());
    }

    @Override
    public void update() {
        Player p = (Player) player;
        p.update();
        camera.update(p.getPlayerCenterX(), p.getPlayerCenterY());
    }

    public Player getPlayer() {
        return (Player) player;
    }

}
