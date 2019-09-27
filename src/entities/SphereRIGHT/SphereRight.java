package entities.SphereRIGHT;

import bases.*;
import renderer.Animation;

public class SphereRight extends GameObject {
    long cnt = 0;
    public SphereRight(){
        this.renderer = new Animation(20,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png"));

        this.position = new Vector2D(215, 525);
        this.cnt = 0;
    }
}
