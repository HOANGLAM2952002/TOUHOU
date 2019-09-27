package entities.SphereLEFT;

import bases.*;
import renderer.Animation;

public class SphereLeft extends GameObject {
    long cnt = 0;
    public SphereLeft(){
        this.renderer = new Animation(20,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png"));

        this.position = new Vector2D(150, 525);
        this.cnt = 0;
    }

    public void run(){
        float vx = 0, vy = 0;
        if (KeyPressed.getInstance().upPressed){
            vy = -5;
        }
        if (KeyPressed.getInstance().downPressed){
            vy = 5;
        }
        if (KeyPressed.getInstance().leftPressed){
            vx = -5;
        }
        if (KeyPressed.getInstance().rightPressed){
            vx = 5;
        }
        if (KeyPressed.getInstance().shootPresed && cnt >= 20){
            this.castSpell();
            cnt = 0;
        } else {
            cnt++;
        }

        this.position.x = Utils.clamp(this.position.x, -25, 384 - 44 - 25);
        this.position.y = Utils.clamp(this.position.y, 25, 600 - 100 + 25);
        this.velocity.set(vx,vy);
        super.run();
    }

    private void castSpell() {
        SphereLeftSpell newSpell = GameObject.recycle(SphereLeftSpell.class);
        newSpell.position.x = this.position.x;
        newSpell.position.y = this.position.y;
    }
}
