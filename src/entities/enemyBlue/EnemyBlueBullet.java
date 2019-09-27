package entities.enemyBlue;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.SphereRIGHT.SphereRight;
import entities.player.Player;
import renderer.ImageRenderer;

public class EnemyBlueBullet extends GameObject {
    double spellDistance = 5;
    double newAngle;

    public EnemyBlueBullet(){
        this.renderer = new ImageRenderer("assets/images/enemies/bullets/red.png");
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 12, 12);
    }

    public void run() {
        this.deactiveIfNeeded();
        this.position.x += spellDistance*Math.sin(newAngle);
        this.position.y += spellDistance*Math.cos(newAngle);
        Player player = GameObject.checkCollider(this, Player.class);
        if (player != null){
            System.out.println("dang va cham");
            player.deActive();
            this.deActive();
            player.sphereRight.deActive();
            player.sphereLeft.deActive();
        }
    }

    private void deactiveIfNeeded() {
        if (this.position.y > 600 | this.position.y < 0 | this.position.x > 384 | this.position.x < 0){
            deActive();
        }
    }
}
