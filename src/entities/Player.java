package entities;

import bases.*;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends GameObject {
    long cnt = 0;
    ArrayList<PlayerSpell> playerSpells;


    public Player(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position = new Vector2D(175, 500);
        this.cnt = 0;
        playerSpells = new ArrayList<>();
        //this.boxCollider = new BoxCollider(this, 32, 48);
    }

//    /**
//     * run function run() of each spell
//     * @param g
//     */
//    public void render(Graphics g) {
//        g.drawImage(this.image, x, y, null);
//        for (int i = 0; i < this.playerSpells.size(); i++){
//            PlayerSpell playerSpell = this.playerSpells.get(i);
//            playerSpell.render(g);
//        }
//    }

    /**
     * input keyPressed from GameCanvas
     * @param keyPressed (no need)
     */
    public void run() {
        if (KeyPressed.getInstance().upPressed){
            position.y -= 5;
        }
        if (KeyPressed.getInstance().downPressed){
            position.y += 5;
        }
        if (KeyPressed.getInstance().rightPressed){
            position.x += 5;
        }
        if (KeyPressed.getInstance().leftPressed){
            position.x -= 5;
        }

        if (KeyPressed.getInstance().shootPresed && cnt >= 20){
            this.castSpell();
            cnt = 0;
        } else {
            cnt++;
        }

        this.position.x = Utils.clamp(this.position.x, 0, 384 - 44);
        this.position.y = Utils.clamp(this.position.y, 0, 600 - 100);

        for (int i = 0; i < this.playerSpells.size(); i++){
            PlayerSpell playerSpell = this.playerSpells.get(i);
            playerSpell.run();
        }
    }

    /**
     * create a new spell
     * set original x,y the same with player
     * add into array list playerSpells
     */
    private void castSpell() {
        PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
        newSpell.position.x = this.position.x;
        newSpell.position.y = this.position.y;
        playerSpells.add(newSpell);
    }
}

