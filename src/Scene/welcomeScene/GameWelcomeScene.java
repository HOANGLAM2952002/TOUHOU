package Scene.welcomeScene;
import Scene.Scene;
import bases.GameObject;

public class GameWelcomeScene extends Scene {

    @Override
    public void init() {
        BackgroundWelcome backgroundWelcome = new BackgroundWelcome();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
