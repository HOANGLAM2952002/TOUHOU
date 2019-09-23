package entities.enemyBlue;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import renderer.ImageRenderer;

public class EnemyBlue extends GameObject {
    int spellNum = 4;
    int bullet_cnt = 0;

    public EnemyBlue(){
        this.renderer = new ImageRenderer("assets/images/enemies/level0/blue/0.png");
        this.position = new Vector2D((float) Math.random() * 384, 0);
        this.boxCollider = new BoxCollider(this, 32, 32);
    }

    @Override
    public void run(){
        this.deactiveIfNeeded();
        if (bullet_cnt >= 20){
            bullet_cnt = 0;
            this.castSpell();
        } else {
            bullet_cnt++;
        }
        this.position.addUp(0,1);
        super.run();
    }

    private void castSpell() {
        for (int i = 0; i < spellNum; i++){
            double divideAng = (360/spellNum) * i;
            double radConvert = Math.toRadians(divideAng);
            EnemyBlueBullet newBullet = GameObject.recycle(EnemyBlueBullet.class);
            newBullet.newAngle = radConvert;
            newBullet.position.x = this.position.x + 8;
            newBullet.position.y = this.position.y + 32;
        }
    }

    public void deactiveIfNeeded(){
        if (this.position.y > 600 | this.position.y < 0 | this.position.x > 384 | this.position.x < 0){
            deActive();
        }
    }
}
