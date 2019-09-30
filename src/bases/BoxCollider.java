package bases;

import java.awt.*;

public class BoxCollider {
    Vector2D positon;
    Vector2D anchor;
    float width, height;

    public BoxCollider(GameObject master, float width, float height) {
        this.positon = master.position;
        this.width = width;
        this.height = height;
        this.anchor = master.anchor;
    }

    public float top() {
        return this.positon.y - this.anchor.y*this.height;
    }

    public float bot() {
        return this.positon.y + this.height;
    }

    public float left() {
        return this.positon.x - this.anchor.x*this.width;
    }

    public float right() {
        return this.positon.x + this.anchor.x*this.width;
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

