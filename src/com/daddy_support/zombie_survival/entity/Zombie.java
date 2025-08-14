package com.daddy_support.zombie_survival.entity;

import com.daddy_support.zombie_survival.GameWorld;
import com.daddy_support.zombie_survival.game_obj.GameObj;
import com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.ZOMBIE_SPRITE_ACTION;
import com.daddy_support.zombie_survival.resource_loader.SpriteStore;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.daddy_support.zombie_survival.constants.GameConstants.ZOMBIE_HEIGHT;
import static com.daddy_support.zombie_survival.constants.GameConstants.ZOMBIE_WIDTH;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION.PLAYER_IDLE;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION.PLAYER_WALK;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.ZOMBIE_SPRITE_ACTION.*;

public class Zombie extends GameObj {

    private float x, y;
    private int width, height;
    private BufferedImage[][] zombieSprites;
    private Direction direction;
    private ZOMBIE_SPRITE_ACTION zombieAction;

    //Animation
    private int animationDelay;
    private int aniTick;
    private float movementSpeed = 2.5f;
    private float animationSpeed = 5.0f;

    private GameWorld gameWorld;

    {
        zombieSprites = SpriteStore.getZombieActions(ZOMBIE_IDLE);
    }

    public Zombie(float x, float y, Direction direction, GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        this.x = x;
        this.y = y;
        this.width = ZOMBIE_WIDTH;
        this.height = ZOMBIE_HEIGHT;
        this.direction = direction;
        zombieAction = ZOMBIE_ATTACK_1;
    }

    @Override
    public void render(Graphics g, float cameraX, float cameraY) {
        zombieSprites = SpriteStore.getZombieActions(zombieAction);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(zombieSprites[direction.getValue()][aniTick], (int) ((int) x - cameraX), (int) ((int) y - cameraY), 2 * width, 2 * height, null);

        if (gameWorld.getCollisionManager().isEditMode()) {
            Rectangle hitBox = getHitBox();
            g2d.setColor(new Color(200, 0 , 0 , 100));
            g2d.fillRect((int) (hitBox.x - cameraX), (int) (hitBox.y - cameraY), hitBox.width, hitBox.height);
        }

    }

    @Override
    public void update() {
        animateCharacter();
    }

    private void animateCharacter() {
        if (animationDelay > zombieAction.getAnimationDelay()) {
            if (aniTick < zombieAction.getSpriteAnimationColumnCounts() - 1) {
                aniTick++;
            } else {
                aniTick = 0;
            }
            animationDelay = 0;
        }
        animationDelay++;
    }

    public Rectangle getHitBox(){
        float hitBoxX = x + 120;
        float hitBoxY = y + 140;

        return new Rectangle((int) hitBoxX, (int) hitBoxY, width - 100, height - 90);
    }
}
