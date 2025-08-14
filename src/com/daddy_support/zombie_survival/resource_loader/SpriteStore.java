package com.daddy_support.zombie_survival.resource_loader;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.PLAYER_SPRITE_ACTION.*;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.ZOMBIE_SPRITE_ACTION;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.ZOMBIE_SPRITE_ACTION.*;
import static com.daddy_support.zombie_survival.resource_loader.SpriteAnimationStore.MAP_TYPE;

public class SpriteStore {

    private static final int PLAYER_SPRITE_WIDTH = 128;
    private static final int PLAYER_SPRITE_HEIGHT = 128;

    private static final EnumMap<PLAYER_SPRITE_ACTION, BufferedImage[][]> playerActions =
            new EnumMap<>(PLAYER_SPRITE_ACTION.class);

    private static final EnumMap<ZOMBIE_SPRITE_ACTION, BufferedImage[][]> zombieActions =
            new EnumMap<>(ZOMBIE_SPRITE_ACTION.class);

    private static final Map<String, BufferedImage> maps = new HashMap<>();

    static {
        loadAnimations();
        loadMaps();
    }

    private static void loadAnimations() {
        playerActions.put(PLAYER_ATTACK_1, loadAnimation("player/Attack1.png",
                PLAYER_ATTACK_1.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_1.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_ATTACK_2, loadAnimation("player/Attack2.png",
                PLAYER_ATTACK_2.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_2.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_ATTACK_3, loadAnimation("player/Attack3.png",
                PLAYER_ATTACK_3.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_3.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_ATTACK_4, loadAnimation("player/Attack4.png",
                PLAYER_ATTACK_4.getSpriteAnimationColumnCounts(),
                PLAYER_ATTACK_4.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_DIE, loadAnimation("player/Die.png",
                PLAYER_DIE.getSpriteAnimationColumnCounts(),
                PLAYER_DIE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_IDLE, loadAnimation("player/Idle.png",
                PLAYER_IDLE.getSpriteAnimationColumnCounts(),
                PLAYER_IDLE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_IDLE_2, loadAnimation("player/Idle2.png",
                PLAYER_IDLE_2.getSpriteAnimationColumnCounts(),
                PLAYER_IDLE_2.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_IDLE_3, loadAnimation("player/Idle3.png",
                PLAYER_IDLE_3.getSpriteAnimationColumnCounts(),
                PLAYER_IDLE_3.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN, loadAnimation("player/Run.png",
                PLAYER_RUN.getSpriteAnimationColumnCounts(),
                PLAYER_RUN.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN_ATTACK, loadAnimation("player/RunAttack.png",
                PLAYER_RUN_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_RUN_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN_BACKWARDS, loadAnimation("player/RunBackwards.png",
                PLAYER_RUN_BACKWARDS.getSpriteAnimationColumnCounts(),
                PLAYER_RUN_BACKWARDS.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_RUN_BACKWARDS_ATTACK, loadAnimation("player/RunBackwardsAttack.png",
                PLAYER_RUN_BACKWARDS_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_RUN_BACKWARDS_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_LEFT, loadAnimation("player/StrafeLeft.png",
                PLAYER_STRAFE_LEFT.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_LEFT.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_LEFT_ATTACK, loadAnimation("player/StrafeLeftAttack.png",
                PLAYER_STRAFE_LEFT_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_LEFT_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_RIGHT, loadAnimation("player/StrafeRight.png",
                PLAYER_STRAFE_RIGHT.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_RIGHT.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_STRAFE_RIGHT_ATTACK, loadAnimation("player/StrafeRightAttack.png",
                PLAYER_STRAFE_RIGHT_ATTACK.getSpriteAnimationColumnCounts(),
                PLAYER_STRAFE_RIGHT_ATTACK.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_TAKE_DAMAGE, loadAnimation("player/TakeDamage.png",
                PLAYER_TAKE_DAMAGE.getSpriteAnimationColumnCounts(),
                PLAYER_TAKE_DAMAGE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_TAUNT, loadAnimation("player/Taunt.png",
                PLAYER_TAKE_DAMAGE.getSpriteAnimationColumnCounts(),
                PLAYER_TAKE_DAMAGE.getSpriteAnimationRowCounts()));
        playerActions.put(PLAYER_WALK, loadAnimation("player/Walk.png",
                PLAYER_WALK.getSpriteAnimationColumnCounts(),
                PLAYER_WALK.getSpriteAnimationRowCounts()));


        zombieActions.put(ZOMBIE_ATTACK_1, loadAnimation("zombie/zombie_female_1/Attack1.png",
                ZOMBIE_ATTACK_1.getSpriteAnimationColumnCounts(),
                ZOMBIE_ATTACK_1.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_ATTACK_2, loadAnimation("zombie/zombie_female_1/Attack2.png",
                ZOMBIE_ATTACK_2.getSpriteAnimationColumnCounts(),
                ZOMBIE_ATTACK_3.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_ATTACK_3, loadAnimation("zombie/zombie_female_1/Attack3.png",
                ZOMBIE_ATTACK_3.getSpriteAnimationColumnCounts(),
                ZOMBIE_ATTACK_3.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_ATTACK_4, loadAnimation("zombie/zombie_female_1/Attack4.png",
                ZOMBIE_ATTACK_4.getSpriteAnimationColumnCounts(),
                ZOMBIE_ATTACK_4.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_ATTACK_5, loadAnimation("zombie/zombie_female_1/Attack5.png",
                ZOMBIE_ATTACK_5.getSpriteAnimationColumnCounts(),
                ZOMBIE_ATTACK_5.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_DIE, loadAnimation("zombie/zombie_female_1/Die.png",
                ZOMBIE_DIE.getSpriteAnimationColumnCounts(),
                ZOMBIE_DIE.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_DIE2, loadAnimation("zombie/zombie_female_1/Die2.png",
                ZOMBIE_DIE2.getSpriteAnimationColumnCounts(),
                ZOMBIE_DIE2.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_IDLE, loadAnimation("zombie/zombie_female_1/Idle.png",
                ZOMBIE_IDLE.getSpriteAnimationColumnCounts(),
                ZOMBIE_IDLE.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_IDLE_2, loadAnimation("zombie/zombie_female_1/Idle2.png",
                ZOMBIE_IDLE_2.getSpriteAnimationColumnCounts(),
                ZOMBIE_IDLE_2.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_RUN, loadAnimation("zombie/zombie_female_1/Run.png",
                ZOMBIE_RUN.getSpriteAnimationColumnCounts(),
                ZOMBIE_RUN.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_TAKE_DAMAGE, loadAnimation("zombie/zombie_female_1/TakeDamage.png",
                ZOMBIE_TAKE_DAMAGE.getSpriteAnimationColumnCounts(),
                ZOMBIE_TAKE_DAMAGE.getSpriteAnimationRowCounts()));
        zombieActions.put(ZOMBIE_WALK, loadAnimation("zombie/zombie_female_1/Walk.png",
                ZOMBIE_WALK.getSpriteAnimationColumnCounts(),
                ZOMBIE_WALK.getSpriteAnimationRowCounts()));
    }

    private static void loadMaps() {
        BufferedImage map  = SpriteLoader.GetResourceImage(MAP_TYPE.MAP_1.getResourcePath());
        maps.put(MAP_TYPE.MAP_1.getKey(), map);
    }

    private static BufferedImage[][] loadAnimation(String fileName, int frameColumnCount, int frameRowCount) {
        BufferedImage image = SpriteLoader.GetResourceImage(fileName);
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

    public static BufferedImage[][] getPlayerActions(PLAYER_SPRITE_ACTION action) {
        return playerActions.get(action);
    }

    public static BufferedImage[][] getZombieActions(ZOMBIE_SPRITE_ACTION action) {
        return zombieActions.get(action);
    }

    public static BufferedImage getMap(MAP_TYPE mapType) {
        return maps.get(mapType.getKey());
    }
}
