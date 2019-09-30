package renderer;
import bases.GameObject;
import java.awt.*;

public interface Renderer {
    void render(Graphics g, GameObject master);
}
