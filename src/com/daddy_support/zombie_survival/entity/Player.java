package com.daddy_support.zombie_survival.entity;

import com.daddy_support.zombie_survival.game_obj.GameObj;
import com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION;
import com.daddy_support.zombie_survival.resource_loader.SpriteStore;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.daddy_support.zombie_survival.constants.GameConstants.GAME_HEIGHT;
import static com.daddy_support.zombie_survival.constants.GameConstants.GAME_WIDTH;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION.*;

public class Player extends GameObj {

    private int x, y;
    private int width, height;
    private BufferedImage[][] playerSprites;
    private Direction direction;
    private PLAYER_SPRITE_ACTION playerAction;

    //Animation
    private int animationDelay;
    private int aniTick;
    private float movementSpeed = 1.0f;
    private float animationSpeed = 5.0f;

    {
        playerSprites = SpriteStore.getPlayerActions(PLAYER_WALK);
    }

    public Player(int x, int y, int width, int height, Direction direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction = direction;
        playerAction = PLAYER_WALK;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(playerSprites[direction.getValue()][aniTick], x, y, 2 * width, 2 * height, null);
    }

    @Override
    public void update() {
        animateCharacter();
    }

    private void animateCharacter() {
        if (animationDelay > playerAction.getAnimationDelay()) {
            if (aniTick < playerAction.getSpriteAnimationColumnCounts() - 1) {
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

    int actionNumber = 0;
    public void updateAnimation() {
        switch (actionNumber) {
            case 0  ->  {
                this.playerAction = PLAYER_ATTACK_1;
            }
            case 1  ->  {
                this.playerAction = PLAYER_ATTACK_2;
            }
            case 2  ->  {
                this.playerAction = PLAYER_ATTACK_3;
            }
            case 3  ->  {
                this.playerAction = PLAYER_ATTACK_4;
            }
            case 4  ->  {
                this.playerAction = PLAYER_DIE;
            }
            case 5  ->  {
                this.playerAction = PLAYER_IDLE;
            }
            case 6  ->  {
                this.playerAction = PLAYER_IDLE_2;
            }
            case 7  ->  {
                this.playerAction = PLAYER_IDLE_3;
            }
            case 8  ->  {
                this.playerAction = PLAYER_RUN;
            }
            case 9  ->  {
                this.playerAction = PLAYER_RUN_ATTACK;
            }
            case 10 ->  {
                this.playerAction =  PLAYER_RUN_BACKWARDS;
            }
            case 11 ->  {
                this.playerAction =  PLAYER_RUN_BACKWARDS_ATTACK;
            }
            case 12 ->  {
                this.playerAction =  PLAYER_STRAFE_LEFT;
            }
            case 13 ->  {
                this.playerAction =  PLAYER_STRAFE_LEFT_ATTACK;
            }
            case 14 ->  {
                this.playerAction =  PLAYER_STRAFE_RIGHT;
            }
            case 15 ->  {
                this.playerAction =  PLAYER_STRAFE_RIGHT_ATTACK;
            }
            case 16 ->  {
                this.playerAction =  PLAYER_TAKE_DAMAGE;
            }
            case 17 ->  {
                this.playerAction =  PLAYER_TAUNT;
            }
            case 18 ->  {
                this.playerAction =  PLAYER_WALK;
            }
            default -> actionNumber = 0;
        }
        this.playerSprites = SpriteStore.getPlayerActions(playerAction);
        actionNumber++;
    }
}
