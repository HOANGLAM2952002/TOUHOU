package entities;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.EnemyBlack.EnemyBlack;

public class PlayerSpell extends GameObject{

    public PlayerSpell(){
        this.image = SpriteUtils.loadImage("assets/images/player-spells/a/0.png");
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 24, 24);
        //Vector2D position - new Vector2D(0,0);
    }

    public void run() {
        deactiveIfNeeded();
        position.y -= 5;

        EnemyBlack enemyBlack = GameObject.checkCollider(this, EnemyBlack.class);
        if (enemyBlack != null){
            System.out.println("dang va cham");
            enemyBlack.deActive();
            this.deActive();
        }
    }


    public void deactiveIfNeeded(){
        if (this.position.y < 0){
            deActive();
        }
    }

}
