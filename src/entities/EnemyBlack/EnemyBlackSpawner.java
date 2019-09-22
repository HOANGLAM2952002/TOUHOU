package entities.EnemyBlack;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

public class EnemyBlackSpawner extends GameObject {
    FrameCounter frameCounter;

    public EnemyBlackSpawner(){
        frameCounter = new FrameCounter(500);
    }
    @Override
    public void run(){
        if (frameCounter.expired){
            EnemyBlack newEnemyBlack = GameObject.recycle(EnemyBlack.class);
            newEnemyBlack.position = new Vector2D((float) Math.random() * 384, 0);
            frameCounter.reset();
        } else {
            frameCounter.run();
        }
    }
}
