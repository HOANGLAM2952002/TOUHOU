package Scene;

import bases.GameObject;
import entities.Background;
import entities.enemyBlack.EnemyBlack;
import entities.enemyBlack.EnemyBlackSpawner;
import entities.enemyBlue.EnemyBlue;
import entities.enemyBlue.EnemyBlueSpawner;
import entities.enemyPink.EnemyPink;
import entities.enemyPink.EnemyPinkSpawner;
import entities.player.Player;

public class GamePlayScene extends Scene{
    @Override
    public void init() {
        Background background = new Background();
        Player player = GameObject.recycle(Player.class);
        EnemyBlack enemyBlack = new EnemyBlack();
        EnemyBlue enemyBlue = new EnemyBlue();
        EnemyPink enemyPink = new EnemyPink();
        EnemyBlackSpawner enemyBlackSpawner = new EnemyBlackSpawner();
        EnemyBlueSpawner enemyBlueSpawner = new EnemyBlueSpawner();
        EnemyPinkSpawner enemyPinkSpawner = new EnemyPinkSpawner();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
