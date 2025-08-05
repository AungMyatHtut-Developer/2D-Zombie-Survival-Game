package com.daddy_support.zombie_survival.entity;

import com.daddy_support.zombie_survival.game_obj.GameObj;
import com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION;
import com.daddy_support.zombie_survival.resource_loader.SpriteStore;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObj {

    private int x, y;
    private int width, height;
    private BufferedImage[][] playerIdleImageData;
    private BufferedImage[][] playerWalkImageData;
    private Direction direction;
    private PLAYER_SPRITE_ACTION playerAction;

    //Animation
    private int animationDelay;
    private int aniTick;
    private float movementSpeed = 1.0f;
    private float animationSpeed = 5.0f;

    {
        playerIdleImageData = SpriteStore.PlayerIdleImageData();
        playerWalkImageData = SpriteStore.PlayerWalkImageData();
    }

    public Player(int x, int y, int width, int height, Direction direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction = direction;
        playerAction = PLAYER_SPRITE_ACTION.PLAYER_WALK;
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(playerWalkImageData[direction.getValue()][aniTick], x, y, 2 * width, 2 * height, null);
    }

    @Override
    public void update() {
        animateCharacter();
    }

    private void animateCharacter() {
        if (animationDelay > animationSpeed) {
            if (aniTick < playerAction.getSpriteAnimationCounts()) {
                aniTick++;
            } else {
                aniTick = 0;
            }
            animationDelay = 0;
        }
        animationDelay++;
    }

    public void updateDirection(Direction direction) {
        this.direction = direction;
    }
}
