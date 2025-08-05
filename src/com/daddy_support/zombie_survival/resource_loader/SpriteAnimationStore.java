package com.daddy_support.zombie_survival.resource_loader;

public class SpriteAnimationStore {


    public enum PLAYER_SPRITE_ACTION{
        PLAYER_IDLE(13),
        PLAYER_WALK(13);

        int spriteAnimationCounts;

        PLAYER_SPRITE_ACTION(int spriteAnimationCounts){
            this.spriteAnimationCounts = spriteAnimationCounts;
        }

        public int getSpriteAnimationCounts(){
            return spriteAnimationCounts;
        }
    }


}
