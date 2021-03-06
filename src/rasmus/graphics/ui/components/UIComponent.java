package rasmus.graphics.ui.components;

import rasmus.util.*;

import java.awt.*;

public class UIComponent {

    protected Vector2i position;

    protected Color color;

    private boolean removed = false;

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

    public void remove() {
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }
}
