package entities.enemyPink;

import bases.FrameCounter;
import bases.GameObject;

public class EnemyPinkSpawner extends GameObject{
    FrameCounter frameCounter;
    public EnemyPinkSpawner(){
        frameCounter = new FrameCounter(300);
    }

    public void run(){
        if (frameCounter.expired){
            EnemyPink newEnemyPink = GameObject.recycle(EnemyPink.class);
            newEnemyPink.position.set((float) Math.random() * 384, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
