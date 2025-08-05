package com.daddy_support.zombie_survival.resource_loader;

import java.awt.image.BufferedImage;

public class SpriteStore {

    private static final int PLAYER_SPRITE_WIDTH = 128;
    private static final int PLAYER_SPRITE_HEIGHT = 128;
    private static final int PLAYER_SPRITE_ROW = 8;
    private static final int PLAYER_SPRITE_COLUMN = 14;

    private static final BufferedImage playerIdleImage;
    private static final BufferedImage[][] playerIdle;
    private static final BufferedImage playerWalkImage;
    private static final BufferedImage[][] playerWalk;

    private static final String PLAYER_IDLE = "player/Idle.png";
    private static final String PLAYER_WALK = "player/Walk.png";

    static {
        playerIdleImage = SpriteLoader.GetResourceImage(PLAYER_IDLE);
        playerIdle = new BufferedImage[PLAYER_SPRITE_ROW][PLAYER_SPRITE_COLUMN];//rows / columns
        playerWalkImage = SpriteLoader.GetResourceImage(PLAYER_WALK);
        playerWalk = new BufferedImage[PLAYER_SPRITE_ROW][PLAYER_SPRITE_COLUMN];//rows / columns

        loadImages();
    }

    private static void loadImages(){
        spriteImageLoaderHelper(playerIdle, playerIdleImage, PLAYER_SPRITE_WIDTH, PLAYER_SPRITE_HEIGHT);
        spriteImageLoaderHelper(playerWalk, playerWalkImage, PLAYER_SPRITE_WIDTH, PLAYER_SPRITE_HEIGHT);
    }

    private static void spriteImageLoaderHelper(BufferedImage[][] spriteImage, BufferedImage image, int width, int height) {
        for (int y = 0; y < spriteImage.length; y++) {//y => rows, x => columns
            for (int x = 0; x < spriteImage[y].length; x++) {
                spriteImage[y][x] = image.getSubimage(x * width, y * height, width,height);
            }
        }
    }

    public static BufferedImage[][] PlayerIdleImageData() {
        return playerIdle;
    }

    public static BufferedImage[][] PlayerWalkImageData() {
        return playerWalk;
    }


}
