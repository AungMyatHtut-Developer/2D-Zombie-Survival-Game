package com.daddy_support.zombie_survival;

import com.daddy_support.zombie_survival.collision.CollisionManager;
import com.daddy_support.zombie_survival.entity.Direction;
import com.daddy_support.zombie_survival.entity.Map;
import com.daddy_support.zombie_survival.entity.Player;
import com.daddy_support.zombie_survival.entity.Zombie;
import com.daddy_support.zombie_survival.game_obj.GameObj;
import com.daddy_support.zombie_survival.game_screen_template.Camera;
import com.daddy_support.zombie_survival.game_screen_template.DSGameScreen;
import com.daddy_support.zombie_survival.game_screen_template.helper.RenderCallback;
import com.daddy_support.zombie_survival.game_screen_template.helper.UpdateCallback;
import com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.MAP_TYPE;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.daddy_support.zombie_survival.constants.GameConstants.*;

public class GameWorld implements RenderCallback, UpdateCallback {

    private DSGameScreen gameScreen;
    private GameObj player;
    private List<GameObj> zombies;
    private boolean isZombiePlacing;

    private Map map;
    private Camera camera;

    private CollisionManager collisionManager;

    public GameWorld() {
        collisionManager = new CollisionManager();
        loadResources();
        gameScreen = new DSGameScreen(GAME_TITLE, GAME_WIDTH, GAME_HEIGHT, IS_RESIZABLE, this, camera, collisionManager);
        gameScreen.setGameCallbacks(this, this);
        gameScreen.startGame();
    }

    private void loadResources() {
        map = new Map(MAP_TYPE.MAP_1);
        collisionManager.loadMap(map.getMapType().getKey());
        camera = new Camera(GAME_WIDTH, GAME_HEIGHT, map.getWidth(), map.getHeight());
        player = new Player(
                MAP_TYPE.MAP_1.getPlayerStartPointX(),
                MAP_TYPE.MAP_1.getPlayerStartPointY(),
                PLAYER_WIDTH, PLAYER_HEIGHT, Direction.W, this);
        zombies = new ArrayList<>();
    }

    @Override
    public void render(Graphics g) {
        map.render(g, camera.getX(), camera.getY());
        collisionManager.render(g, camera.getX(), camera.getY());
        player.render(g, camera.getX(), camera.getY());

        for(GameObj zombie: zombies) {
            zombie.render(g, camera.getX(), camera.getY());
        }

        drawHelperIndicator(g);
    }

    @Override
    public void update() {
        Player p = (Player) player;
        float oldX = p.getX();
        float oldY = p.getY();

        p.update();//player will move
        Rectangle playerHitBox = p.getHitBox();
        if(collisionManager.checkCollisions(playerHitBox)) {
            p.setPosition(oldX, oldY);
        }

        camera.update(p.getPlayerCenterX(), p.getPlayerCenterY());

        for (GameObj zombie: zombies) {
            zombie.update();
        }
    }

    public void drawHelperIndicator(Graphics g) {
        if (isZombiePlacing) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawString("Zombies Placing Mode: ON", 20, 50);
        }
    }

    public Player getPlayer() {
        return (Player) player;
    }

    public Map getMap(){
        return map;
    }

    public CollisionManager getCollisionManager() {
        return collisionManager;
    }

    public void insertNewZombie(float gameWorldX, float gameWorldY) {
        Zombie zombie = new Zombie(gameWorldX - ZOMBIE_WIDTH, gameWorldY - ZOMBIE_HEIGHT, Direction.NE, this);
        zombies.add(zombie);
    }

    public boolean isZombiePlacing() {
        return isZombiePlacing;
    }

    public void toggleIsZombiePlacing() {
        isZombiePlacing = !isZombiePlacing;
    }

}
