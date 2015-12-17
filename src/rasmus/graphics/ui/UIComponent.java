package rasmus.graphics.ui;

import rasmus.util.*;

import java.awt.*;

public class UIComponent {

    protected Vector2i position;

    protected Color color;

    public UIComponent(Vector2i position) {
        this.position = position;
        color = Color.DARK_GRAY;
    }

    public void update() {

    }

    public void render(Graphics g) {

    }

    public void setPosition(Vector2i position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public UIComponent setColor(Color color) {
        this.color = color;
        return this;
    }
}
