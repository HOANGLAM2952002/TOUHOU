package Scene.welcomeScene;

import Scene.GamePlayScene;
import Scene.SceneManager;
import bases.GameObject;
import bases.KeyPressed;
import renderer.ImageRenderer;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome(){
        this.renderer = new ImageRenderer("assets/images/scenes/menu.png");
    }

    @Override
    public void run() {
        super.run();
        if (KeyPressed.getInstance().anyKeyPressed){
            SceneManager.signNewScene(new GamePlayScene());
        }
    }
}
