package bases;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SpriteUtils {
    /**
     * create image static
     * Load image
     * @param url image
     * @return
     */
    public static Image loadImage(String url){
        Image image;
        try {
            image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
