package entities.player;
import Scene.GameOverScene.GameOverScene;
import Scene.SceneManager;
import bases.*;
import entities.SphereLEFT.SphereLeft;
import entities.SphereLEFT.SphereLeftSpell;
import entities.SphereRIGHT.SphereRight;
import entities.SphereRIGHT.SphereRightSpell;
import renderer.Animation;


public class Player extends GameObject {
    long cnt = 0;
    public SphereRight sphereRight;
    public SphereLeft sphereLeft;
    public Player(){
        this.renderer = new Animation(10,
                SpriteUtils.loadImage("assets/images/players/straight/0.png"),
                SpriteUtils.loadImage("assets/images/players/straight/1.png"),
                SpriteUtils.loadImage("assets/images/players/straight/2.png"),
                SpriteUtils.loadImage("assets/images/players/straight/3.png"),
                SpriteUtils.loadImage("assets/images/players/straight/4.png"),
                SpriteUtils.loadImage("assets/images/players/straight/5.png"),
                SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.position = new Vector2D(175, 500);
        this.cnt = 0;
        this.boxCollider = new BoxCollider(this, 32, 48);
        this.sphereLeft = new SphereLeft();
        this.sphereRight = new SphereRight();
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
        float vx = 0, vy = 0;
        if (KeyPressed.getInstance().upPressed){
            vy = - 5;
        }
        if (KeyPressed.getInstance().downPressed){
            vy = 5;
        }
        if (KeyPressed.getInstance().rightPressed){
            vx = 5;
        }
        if (KeyPressed.getInstance().leftPressed){
            vx = -5;
        }

        if (KeyPressed.getInstance().shootPresed && cnt >= 20){
            this.castSpell();
            cnt = 0;
        } else {
            cnt++;
        }

        this.position.x = Utils.clamp(this.position.x, 0, 384 - 44);
        this.position.y = Utils.clamp(this.position.y, 0, 600 - 100);
        this.velocity.set(vx, vy);

        sphereLeft.position.x = this.position.x - 20;
        sphereRight.position.x = this.position.x + 35;
        sphereLeft.position.y = this.position.y;
        sphereRight.position.y = this.position.y;
        super.run();
    }

    /**
     * create a new spell
     * set original x,y the same with player
     * add into array list playerSpells
     */
    private void castSpell() {
        int numberB = 3;
        double startAngle = -120;
        double endAngle = -60;
        double step = (endAngle - startAngle) / (numberB - 1);
        for (int i = 0; i < numberB; i++){
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(this.position.x, this.position.y);
            newSpell.velocity.setAngle(Math.toRadians(startAngle + step*i));
        }

        SphereLeftSpell sphereLeftSpell = GameObject.recycle(SphereLeftSpell.class);
        SphereRightSpell sphereRightSpell = GameObject.recycle(SphereRightSpell.class);
        sphereLeftSpell.position.x = this.position.x - 20;
        sphereLeftSpell.position.y = this.position.y;
        sphereRightSpell.position.x = this.position.x + 35;
        sphereRightSpell.position.y = this.position.y;
    }

    @Override
    public void deActive() {
        super.deActive();
        SceneManager.signNewScene(new GameOverScene());
    }
}

