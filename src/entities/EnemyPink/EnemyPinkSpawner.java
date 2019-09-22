package entities.EnemyPink;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

public class EnemyPinkSpawner extends GameObject{
    FrameCounter frameCounter;
    public EnemyPinkSpawner(){
        frameCounter = new FrameCounter(500);
    }

    public void run(){
        if (frameCounter.expired){
            EnemyPink newEnemyPink = GameObject.recycle(EnemyPink.class);
            newEnemyPink.position = new Vector2D((float) Math.random() * 384, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
