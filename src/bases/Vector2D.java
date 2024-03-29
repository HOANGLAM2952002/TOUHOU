package bases;

import java.util.Vector;

public class Vector2D {
    public float x;
    public float y;
    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void addUp(float x, float y){
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other){
        this.addUp(other.x, other.y);
    }

    public Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D other){
        return this.add(other.x, other.y);
    }

    public void subtractBy(float x, float y){
        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D other){
        this.subtractBy(other.x, other.y);
    }

    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D other){
        return this.subtract(other.x, other.y);
    }

    public void multiply(int k){
        this.x *= k;
        this.y *= k;
    }

    public float length(){
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D normalize(){
        return new Vector2D(this.x / this.length(), this.y / this.length());
    }

    @Override
    public String toString() {
        return "bases.Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1,1);
        v1.addUp(1, 1);
        System.out.println(v1.toString());
    }
}





