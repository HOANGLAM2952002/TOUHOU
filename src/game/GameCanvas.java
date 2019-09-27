package game;

import bases.GameObject;
import bases.KeyPressed;
import entities.*;
import entities.SphereLEFT.SphereLeft;
import entities.SphereRIGHT.SphereRight;
import entities.enemyBlack.EnemyBlack;
import entities.enemyBlack.EnemyBlackSpawner;
import entities.enemyBlue.EnemyBlue;
import entities.enemyBlue.EnemyBlueSpawner;
import entities.enemyPink.EnemyPink;
import entities.enemyPink.EnemyPinkSpawner;
import entities.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameCanvas extends JPanel {
    Random rand = new Random();

    Background background;
    Player player;
    EnemyBlack enemyBlack;
    EnemyBlue enemyBlue;
    EnemyPink enemyPink;
    EnemyBlackSpawner enemyBlackSpawner;
    EnemyBlueSpawner enemyBlueSpawner;
    EnemyPinkSpawner enemyPinkSpawner;
    SphereLeft sphereLeft;
    SphereRight sphereRight;
    int move[] = {-5,5};

    public GameCanvas(){
        this.background = new Background();
        this.player = new Player();
        this.enemyBlack = new EnemyBlack();
        this.enemyBlue = new EnemyBlue();
        this.enemyPink = new EnemyPink();

        this.enemyBlackSpawner = new EnemyBlackSpawner();
        this.enemyBlueSpawner = new EnemyBlueSpawner();
        this.enemyPinkSpawner = new EnemyPinkSpawner();

        this.sphereLeft = new SphereLeft();
        this.sphereRight = new SphereRight();
        this.player = GameObject.recycle(Player.class);
//        // load image
//        try {
//            // try to catch read phrase
//        } catch (IOException e) {
//            // print errors if try wrong
//            e.printStackTrace();
//        }

        this.keyListener();
    }

    private void keyListener() {
        this.setFocusable(true);
        // catch event clicking buttons
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    /**
                     * get static from KeyPressed
                     */
                    KeyPressed.getInstance().upPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = true;
                }

                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyPressed.getInstance().shootPresed = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyPressed.getInstance().upPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = false;
                }

                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyPressed.getInstance().shootPresed = false;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        GameObject.renderAll(g);
    }

}
