package entities.SphereLEFT;

import bases.*;
import renderer.Animation;

public class SphereLeft extends GameObject {
    long cnt = 0;
    public SphereLeft() {
        this.renderer = new Animation(20,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png"));

        this.position = new Vector2D(150, 525);
        this.cnt = 0;
    }

}
