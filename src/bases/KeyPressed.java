package bases;

public class KeyPressed {
    public boolean upPressed;
    public boolean downPressed;
    public boolean rightPressed;
    public boolean leftPressed;
    public boolean shootPresed;
    public boolean anyKeyPressed;


    /**
     * can access globally
     */
    private static final KeyPressed INSTANCE = new KeyPressed();

    private KeyPressed(){
        this.upPressed = false;
        this.downPressed = false;
        this.rightPressed = false;
        this.leftPressed = false;
        this.shootPresed = false;
        this.anyKeyPressed = false;
    }

    public static KeyPressed getInstance(){
        /**
         * static have no 'this'
         */
        return INSTANCE;
    }
}
