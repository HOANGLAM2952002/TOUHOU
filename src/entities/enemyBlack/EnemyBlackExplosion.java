package entities.enemyBlack;

import bases.GameObject;
import bases.SpriteUtils;
import renderer.Animation;

public class EnemyBlackExplosion extends GameObject {
    public EnemyBlackExplosion(){
        this.renderer = new Animation(5, true,
                SpriteUtils.loadImage("assets/images/enemies/explosion/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/3.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/4.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/5.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/6.png"),
                SpriteUtils.loadImage("assets/images/enemies/explosion/7.png"));
    }

    @Override
    public void run() {
        super.run();
        Animation animation = (Animation) this.renderer;
        if (animation.finished){
            this.deActive();
            animation.reset();
        }
    }
}
