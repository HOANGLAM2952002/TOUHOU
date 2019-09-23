package entities.enemyBlue;

import bases.FrameCounter;
import bases.GameObject;

public class EnemyBlueSpawner extends GameObject{
    FrameCounter frameCounter;

    public EnemyBlueSpawner(){
        frameCounter = new FrameCounter(300);
    }

    @Override
    public void run(){
        if (frameCounter.expired){
            EnemyBlue newEnemyBlue = GameObject.recycle(EnemyBlue.class);
            newEnemyBlue.position.set((float) Math.random() * 384, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
