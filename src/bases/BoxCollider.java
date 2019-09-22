package bases;

public class BoxCollider {
    Vector2D positon;
    float width, height;

    public BoxCollider(GameObject master, float width, float height) {
        this.positon = master.position;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.positon.y;
    }

    public float bot() {
        return this.positon.y + this.height;
    }

    public float left() {
        return this.positon.x;
    }

    public float right() {
        return this.positon.x + this.width;
    }

    //ToDo: can lam gi dodo
    public boolean collideWith(BoxCollider other) {
        /**
         * xét vị trí nằm trọn trong box
         */
        return  this.right() >= other.left() &&
                this.left() <= other.right() &&
                this.bot() >= other.top() &&
                this.top() <= other.bot();
    }
}

