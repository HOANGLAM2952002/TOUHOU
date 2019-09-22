package entities.EnemyBlue;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

public class EnemyBlueSpawner extends GameObject{
    FrameCounter frameCounter;

    public EnemyBlueSpawner(){
        frameCounter = new FrameCounter(500);
    }

    @Override
    public void run(){
        if (frameCounter.expired){
            EnemyBlue newEnemyBlue = GameObject.recycle(EnemyBlue.class);
            newEnemyBlue.position = new Vector2D((float) Math.random() * 384, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
