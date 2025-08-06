package com.daddy_support.zombie_survival.resource_loader;

public class SpriteAnimationStore {


    public enum PLAYER_SPRITE_ACTION{

        PLAYER_ATTACK_1(8, 14, 3.0f),
        PLAYER_ATTACK_2(8, 14, 3.0f),
        PLAYER_ATTACK_3(8, 14, 3.0f),
        PLAYER_ATTACK_4(8, 14, 3.0f),
        PLAYER_DIE(8, 14, 5.0f),
        PLAYER_IDLE(8, 14, 3.0f),
        PLAYER_IDLE_2(8, 14, 3.0f),
        PLAYER_IDLE_3(8, 14, 3.0f),
        PLAYER_RUN(8, 14, 1.0f),
        PLAYER_RUN_ATTACK(8, 14, 1.0f),
        PLAYER_RUN_BACKWARDS(8, 14, 3.0f),
        PLAYER_RUN_BACKWARDS_ATTACK(8, 14, 3.0f),
        PLAYER_STRAFE_LEFT(8, 14, 3.0f),
        PLAYER_STRAFE_LEFT_ATTACK(8, 14, 3.0f),
        PLAYER_STRAFE_RIGHT(8, 14, 3.0f),
        PLAYER_STRAFE_RIGHT_ATTACK(8, 14, 3.0f),
        PLAYER_TAKE_DAMAGE(8, 14, 3.0f),
        PLAYER_TAUNT(8, 14, 3.0f),
        PLAYER_WALK(8, 14, 3.0f);

        int spriteAnimationColumnCounts;
        int spriteAnimationRowCounts;
        float animationDelay;

        PLAYER_SPRITE_ACTION(int spriteAnimationRowCounts, int spriteAnimationColumnCounts, float animationDelay){
          this.spriteAnimationColumnCounts = spriteAnimationColumnCounts;
          this.spriteAnimationRowCounts = spriteAnimationRowCounts;
          this.animationDelay = animationDelay;
        }

        public int getSpriteAnimationColumnCounts() {
            return spriteAnimationColumnCounts;
        }

        public int getSpriteAnimationRowCounts() {
            return spriteAnimationRowCounts;
        }

        public float getAnimationDelay() {
            return animationDelay;
        }
    }


}
