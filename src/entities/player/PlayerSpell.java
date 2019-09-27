package entities.player;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.enemyBlack.EnemyBlack;
import entities.enemyBlue.EnemyBlue;
import entities.enemyPink.EnemyPink;
import renderer.Animation;

import javax.swing.*;

public class PlayerSpell extends GameObject{

    public PlayerSpell(){
        this.velocity.set(0, -5);
        this.renderer = new Animation(20,
                SpriteUtils.loadImage("assets/images/player-spells/a/0.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/1.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/2.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/3.png"));
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 24, 24);
    }

    public void run() {
        deactiveIfNeeded();

        EnemyBlack enemyBlack = GameObject.checkCollider(this, EnemyBlack.class);
        if (enemyBlack != null){
            System.out.println("dang va cham");
            enemyBlack.deActive();
            this.deActive();
        }

        EnemyBlue enemyBlue = GameObject.checkCollider(this, EnemyBlue.class);
        if (enemyBlue != null){
            System.out.println("dang va cham");
            enemyBlue.deActive();
            this.deActive();
        }

        EnemyPink enemyPink = GameObject.checkCollider(this, EnemyPink.class);
        if (enemyPink != null){
            System.out.println("dang va cham");
            enemyPink.deActive();
            this.deActive();
        }
        super.run();
    }


    public void deactiveIfNeeded(){
        if (this.position.y < 0){
            deActive();
        }
    }

}
