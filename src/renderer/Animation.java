package renderer;
import bases.FrameCounter;
import bases.Vector2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Animation implements Renderer{
    ArrayList<Image> images = new ArrayList<>();
    int imageIndex;
    FrameCounter frameCounter;
    boolean oneTime;
    public boolean finished;

    /**
     * ghi de len ham Animation
     * ham mac dinh false
     * @param frameDelay
     * @param imgs
     */
    public Animation(int frameDelay, Image... imgs){
        this(frameDelay, false, imgs);
    }
    public Animation(int frameDelay,boolean oneTime, Image... imgs){
        this.images = new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));
        this.frameCounter = new FrameCounter(frameDelay);
        this.imageIndex = 0;
        this.oneTime = oneTime;
        this.finished = false;
    }
    @Override
    public void render(Graphics g, Vector2D position) {
        this.renderCurrentImage(g, position);
        this.changeCurrentImage();
    }

    private void changeCurrentImage() {
        frameCounter.run();
        if (frameCounter.expired){
            frameCounter.reset();
            if (this.imageIndex < this.images.size() - 1){
                imageIndex++;
            } else {
                if (this.oneTime){
                    this.finished = true;
                } else {
                    imageIndex = 0;

                }
            }
        }
    }

    private void renderCurrentImage(Graphics g, Vector2D position) {
        Image currentImage = images.get(imageIndex);
        g.drawImage(currentImage, (int)position.x, (int)position.y, null);
    }

    public void reset(){
        this.finished = false;
        this.imageIndex = 0;
    }
}
