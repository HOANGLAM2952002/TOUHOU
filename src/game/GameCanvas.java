package game;

import Scene.GamePlayScene;
import Scene.SceneManager;
import Scene.welcomeScene.GameWelcomeScene;
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
    int move[] = {-5,5};

    public GameCanvas(){
        SceneManager.signNewScene(new GameWelcomeScene());
        this.keyListener();
    }

    private void keyListener() {
        this.setFocusable(true);
        // catch event clicking buttons
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed = true;
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
                KeyPressed.getInstance().anyKeyPressed = false;
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
        g.fillRect(0, 0, 700, 600);
        GameObject.renderAll(g);
    }

}
