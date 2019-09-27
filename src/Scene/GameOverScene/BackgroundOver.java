package Scene.GameOverScene;

import Scene.GamePlayScene;
import Scene.SceneManager;
import Scene.welcomeScene.GameWelcomeScene;
import bases.FrameCounter;
import bases.GameObject;
import bases.KeyPressed;
import entities.player.Player;
import renderer.ImageRenderer;

public class BackgroundOver extends GameObject {
    public BackgroundOver(){
        this.renderer = new ImageRenderer("assets/images/scenes/game-over-background.jpg");
    }

    @Override
    public void run() {
        SceneManager.signNewScene(new GameOverScene());
        super.run();
        if (KeyPressed.getInstance().anyKeyPressed){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SceneManager.signNewScene(new GameWelcomeScene());
        }
    }
}
