package entities;

import bases.GameObject;
import bases.SpriteUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background extends GameObject {
    /**
     * Contractor load image
     */
    public Background(){
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        // background
        this.position.x = 0;
        this.position.y = 600 - 3109;
    }

    /**
     * Handle background logic
     */
    public void run() {
        if (this.position.y < 0){
            this.position.y += 10;
        } else {
            this.position.y = 600 - 3109;
        }
    }
}

