package bases;
import renderer.Renderer;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Vector;

public class GameObject {
    private static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void add(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive){
                gameObject.render(g);
            }
        }
    }

    public static void runAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive){
                gameObject.run();
            }
        }
        System.out.println(gameObjects.size());
    }

    public static <T extends GameObject>T checkCollider(GameObject master, Class<T> cls){
        for (int i = 0; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.getClass().equals(cls)  && gameObject.isActive){
                if(gameObject.boxCollider != null){
                    if(master.boxCollider.collideWith(gameObject.boxCollider)){
                        return (T) gameObject;
                    }
                }
            }
        }
        return null;
    }

    public static <E extends GameObject>E recycle(Class<E> cls){
        E gameObject = GameObject.findInactive(cls);
        if (gameObject != null) {
            gameObject.reset();
            return (E) gameObject;
        }

        try {
            /**
             * getContractor = lay class cls
             */
            GameObject go = cls.getConstructor().newInstance();
            return (E)go;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <E extends GameObject> E findInactive(Class<E> cls) {
        for (int i = 0; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            /**
             * isAssignableFrom = compare
             * tại sao không dùng cls.equals()
             */
            if (!gameObject.isActive && cls.isAssignableFrom(gameObject.getClass())){
                return (E) gameObject;
            }
        }
        return null;
    }

    public Renderer renderer;
    public Vector2D position;
    public BoxCollider boxCollider;
    public Vector2D velocity;

    /**
     * check xem co dang song ko
     */
    public boolean isActive;

    public GameObject() {
        GameObject.add(this);
        this.position = new Vector2D(0, 0);
        this.isActive = true;
        this.velocity = new Vector2D(0,0);
    }

    public void render(Graphics g) {
        if (renderer != null){
            renderer.render(g, this.position);
        }
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.velocity.set(0,0);

    }

    public void deActive(){
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
    }
}