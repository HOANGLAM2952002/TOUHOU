package Scene.GameOverScene;

import Scene.Scene;
import bases.GameObject;

public class GameOverScene extends Scene {
    @Override
    public void init() {
        BackgroundOver backgroundOver = GameObject.recycle(BackgroundOver.class);
    }

    @Override
    public void clear() {
        GameObject.clear();
    }

}
