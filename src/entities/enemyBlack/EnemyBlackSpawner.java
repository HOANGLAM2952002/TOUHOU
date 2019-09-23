package entities.enemyBlack;

import bases.FrameCounter;
import bases.GameObject;

public class EnemyBlackSpawner extends GameObject {
    FrameCounter frameCounter;

    public EnemyBlackSpawner(){
        frameCounter = new FrameCounter(300);
    }
    @Override
    public void run(){
        if (frameCounter.expired){
            EnemyBlack newEnemyBlack = GameObject.recycle(EnemyBlack.class);
            newEnemyBlack.position.set((float) Math.random() * 384, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
