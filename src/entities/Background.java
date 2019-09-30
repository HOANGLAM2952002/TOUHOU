package entities;

import bases.GameObject;
import bases.SpriteUtils;
import renderer.ImageRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background extends GameObject {
    /**
     * Contractor load image
     */
    public Background(){
        this.renderer = new ImageRenderer("assets/images/background/0.png");
        // background
        this.position.x = 0;
        this.position.y = 600 - 3109;
        this.anchor.set(0,0);
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

