package com.daddy_support.zombie_survival.resource_loader;

import java.awt.image.BufferedImage;
import java.util.EnumMap;

import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION.*;

public class SpriteStore {

    private static final int PLAYER_SPRITE_WIDTH = 128;
    private static final int PLAYER_SPRITE_HEIGHT = 128;

    private static final EnumMap<SpriteAnimationStore.PLAYER_SPRITE_ACTION, BufferedImage[][]> playerActions =
            new EnumMap<>(SpriteAnimationStore.PLAYER_SPRITE_ACTION.class);

    static {
        loadAnimations();
    }

    private static void loadAnimations() {
        playerActions.put(PLAYER_ATTACK_1, loadAnimation("Attack1.png",
                PLAYER_ATTACK_1.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_1.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_ATTACK_2, loadAnimation("Attack2.png",
                PLAYER_ATTACK_2.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_2.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_ATTACK_3, loadAnimation("Attack3.png",
                PLAYER_ATTACK_3.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_3.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_ATTACK_4, loadAnimation("Attack4.png",
                PLAYER_ATTACK_4.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_4.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_DIE, loadAnimation("Die.png",
                PLAYER_DIE.getSpriteAnimationColumnCounts(),
                PLAYER_DIE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_IDLE, loadAnimation("Idle.png",
                PLAYER_IDLE.getSpriteAnimationColumnCounts(),
                PLAYER_IDLE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_IDLE_2, loadAnimation("Idle2.png",
                PLAYER_IDLE_2.getSpriteAnimationColumnCounts(),
                PLAYER_IDLE_2.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_IDLE_3, loadAnimation("Idle3.png",
                PLAYER_IDLE_3.getSpriteAnimationColumnCounts(),
                PLAYER_IDLE_3.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN, loadAnimation("Run.png",
                PLAYER_RUN.getSpriteAnimationColumnCounts(),
                PLAYER_RUN.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN_ATTACK, loadAnimation("RunAttack.png",
                PLAYER_RUN_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_RUN_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN_BACKWARDS, loadAnimation("RunBackwards.png",
                PLAYER_RUN_BACKWARDS.getSpriteAnimationColumnCounts(),
                PLAYER_RUN_BACKWARDS.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN_BACKWARDS_ATTACK, loadAnimation("RunBackwardsAttack.png",
                PLAYER_RUN_BACKWARDS_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_RUN_BACKWARDS_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_LEFT, loadAnimation("StrafeLeft.png",
                PLAYER_STRAFE_LEFT.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_LEFT.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_LEFT_ATTACK, loadAnimation("StrafeLeftAttack.png",
                PLAYER_STRAFE_LEFT_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_LEFT_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_RIGHT, loadAnimation("StrafeRight.png",
                PLAYER_STRAFE_RIGHT.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_RIGHT.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_RIGHT_ATTACK, loadAnimation("StrafeRightAttack.png",
                PLAYER_STRAFE_RIGHT_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_RIGHT_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_TAKE_DAMAGE, loadAnimation("TakeDamage.png",
                PLAYER_TAKE_DAMAGE.getSpriteAnimationColumnCounts(),
                PLAYER_TAKE_DAMAGE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_TAUNT, loadAnimation("Taunt.png",
                PLAYER_TAKE_DAMAGE.getSpriteAnimationColumnCounts(),
                PLAYER_TAKE_DAMAGE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_WALK, loadAnimation("Walk.png",
                PLAYER_WALK.getSpriteAnimationColumnCounts(),
                PLAYER_WALK.getSpriteAnimationRowCounts()));
    }

    private static BufferedImage[][] loadAnimation(String fileName, int frameColumnCount, int frameRowCount) {
        BufferedImage image = SpriteLoader.GetResourceImage("player/" + fileName);
        BufferedImage[][] animation = new BufferedImage[frameRowCount][frameColumnCount];

        for (int row = 0; row < frameRowCount; row++) {
            for (int column = 0; column < frameColumnCount; column++) {
                animation[row][column] = image.getSubimage(
                        column * PLAYER_SPRITE_WIDTH,
                        row * PLAYER_SPRITE_HEIGHT,
                        PLAYER_SPRITE_WIDTH,
                        PLAYER_SPRITE_HEIGHT
                );
            }
        }

        return animation;
    }

    public static BufferedImage[][] getPlayerActions(SpriteAnimationStore.PLAYER_SPRITE_ACTION action) {
        return playerActions.get(action);

    }
}
