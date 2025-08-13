package com.daddy_support.zombie_survival.entity;

import com.daddy_support.zombie_survival.GameWorld;
import com.daddy_support.zombie_survival.game_obj.GameObj;
import com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION;
import com.daddy_support.zombie_survival.resource_loader.SpriteStore;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION.*;

public class Player extends GameObj {
    private float x, y;
    private int width, height;
    private BufferedImage[][] playerSprites;
    private Direction direction;
    private PLAYER_SPRITE_ACTION playerAction;

    //Animation
    private int animationDelay;
    private int aniTick;
    private float movementSpeed = 2.5f;
    private float animationSpeed = 5.0f;

    //Player Movement
    private boolean isMoving = false;

    //Game World
    private GameWorld gameWorld;

    {
        playerSprites = SpriteStore.getPlayerActions(PLAYER_WALK);
    }

    public Player(int x, int y, int width, int height, Direction direction, GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction = direction;
        playerAction = PLAYER_WALK;
    }

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        if(isMoving){
            playerAction = PLAYER_WALK;
        }else{
            playerAction = PLAYER_IDLE;
        }
        playerSprites = SpriteStore.getPlayerActions(playerAction);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(playerSprites[direction.getValue()][aniTick], (int) x, (int) y, 2 * width, 2 * height, null);

        //playerVisualHelper(g2d);
    }

    @Override
    public void render(Graphics g, float cameraX, float cameraY) {
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        if(isMoving){
            playerAction = PLAYER_WALK;
        }else{
            playerAction = PLAYER_IDLE;
        }
        playerSprites = SpriteStore.getPlayerActions(playerAction);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(playerSprites[direction.getValue()][aniTick], (int) ((int) x - cameraX), (int) ((int) y - cameraY), 2 * width, 2 * height, null);

        //playerVisualHelper(g2d);
        if (gameWorld.getCollisionManager().isEditMode()) {
            g2d.setColor(Color.WHITE);
            Rectangle rectangle = getHitBox();
            g2d.fillRect((int) (rectangle.x - cameraX), (int) (rectangle.y - cameraY), rectangle.width, rectangle.height);
            drawPlayerGameWorldLocationIndicator(g2d);
        }

    }

    public void drawPlayerGameWorldLocationIndicator(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawString("X : " + (int) x + " Y : "+ (int) y, 20, 20);
    }

    public void playerVisualHelper(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawRect((int) x, (int) y, 2 * width, 2 * height);
        g2d.setColor(Color.GREEN);
        g2d.drawOval((int) (x + (width * 2) / 2), (int) (y + (height * 2) / 2),5, 5);
    }

    @Override
    public void update() {

        if(isMoving) {
            playerMoveBasedOnDirection();
        }

        animateCharacter();
    }

    private void playerMoveBasedOnDirection() {

        float diagonalMovement = movementSpeed * 0.7071f; //1.345324

        switch (direction) {
            case E -> x += movementSpeed;
            case W -> x -= movementSpeed;
            case S -> y += movementSpeed;
            case N -> y -= movementSpeed;
            case SE -> {
                x += diagonalMovement;
                y += diagonalMovement;
            }
            case SW -> {
                x -= diagonalMovement;
                y += diagonalMovement;
            }
            case NW -> {
                x -= diagonalMovement;
                y -= diagonalMovement;
            }
            case NE -> {
                x += diagonalMovement;
                y -= diagonalMovement;
            }
        }

    }

    public Rectangle getHitBox(){
        float hitBoxX = x + 115;
        float hitBoxY = y + 150;

        return new Rectangle((int) hitBoxX, (int) hitBoxY, width - 100, height - 110);
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

    public void updateDirectionBasedOnMouseMovement(float mouseX, float mouseY) {

        double playerCenterX = x + (width  * 2) / 2;
        double playerCenterY = y + (height * 2) / 2;

        double radian = Math.atan2(mouseY - playerCenterY, mouseX - playerCenterX);
        double actualDegree = (Math.toDegrees(radian) + 360) % 360;

        if(actualDegree > 20 && actualDegree < 70) {
            direction = Direction.SE;
        } else if (actualDegree > 70 && actualDegree < 110) {
            direction = Direction.S;
        }else if (actualDegree > 110 && actualDegree < 160) {
            direction = Direction.SW;
        }else if (actualDegree > 160 && actualDegree < 200) {
            direction = Direction.W;
        }else if (actualDegree > 200 && actualDegree < 245) {
            direction = Direction.NW;
        } else if (actualDegree > 245 && actualDegree < 290) {
            direction = Direction.N;
        } else if (actualDegree > 290 && actualDegree < 340) {
            direction = Direction.NE;
        }else {
            direction = Direction.E;
        }
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

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public float getPlayerCenterX() {
        return x + width;
    }

    public float getPlayerCenterY() {
        return y + height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
