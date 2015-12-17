package rasmus.graphics.ui;

import rasmus.graphics.Sprite;
import rasmus.input.Mouse;
import rasmus.util.*;

import java.awt.*;

public class UIButton extends UIComponent {

    private Sprite sprite;
    private Vector2i position, size;

    public UIButton(Sprite sprite, Vector2i position, Vector2i size) {
        super(position);
        this.sprite = sprite;
        this.position = position;
        this.size = size;
    }

    public UIButton(Sprite sprite, Vector2i position) {
        super(position);
        this.sprite = sprite;
        this.position = position;
        size = new Vector2i(sprite.getSprite().getWidth(), sprite.getSprite().getHeight());
    }

    public boolean isClicked() {
        if(isInSquare() && Mouse.getButton() == 1) return true;

        return false;
    }

    private boolean isInSquare() {
        if(Mouse.getX() > position.x && Mouse.getX() < position.x + size.x && Mouse.getY() > position.y && Mouse.getY() < position.y + size.y) return true;

        return false;
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), position.x, position.y, size.x, size.y, null);
    }
}
