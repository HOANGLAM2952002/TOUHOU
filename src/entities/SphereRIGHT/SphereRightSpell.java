package entities.SphereRIGHT;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.enemyBlack.EnemyBlack;
import entities.enemyBlue.EnemyBlue;
import entities.enemyPink.EnemyPink;
import renderer.Animation;

public class SphereRightSpell extends GameObject {
    public SphereRightSpell(){
        this.renderer = new Animation(20,
                SpriteUtils.loadImage("assets/images/sphere-spells/0.png"),
                SpriteUtils.loadImage("assets/images/sphere-spells/1.png"),
                SpriteUtils.loadImage("assets/images/sphere-spells/2.png"),
                SpriteUtils.loadImage("assets/images/sphere-spells/3.png"));

        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 24, 24);
    }

    public void run(){
        deactiveIfNeeded();
        position.y -= 5;

        EnemyBlack enemyBlack = GameObject.checkCollider(this, EnemyBlack.class);
        if (enemyBlack != null){
            System.out.println("dang va cham");
            enemyBlack.deActive();
            this.deActive();
        }

        EnemyPink enemyPink = GameObject.checkCollider(this, EnemyPink.class);
        if (enemyPink != null){
            System.out.println("dang va cham");
            enemyPink.deActive();
            this.deActive();
        }

        EnemyBlue enemyBlue = GameObject.checkCollider(this, EnemyBlue.class);
        if (enemyBlue != null){
            System.out.println("dang va cham");
            enemyBlue.deActive();
            this.deActive();
        }


    }

    private void deactiveIfNeeded() {
        if (this.position.y < 0){
            this.deActive();
        }
    }
}
