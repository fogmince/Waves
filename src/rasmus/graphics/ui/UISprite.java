package rasmus.graphics.ui;

import rasmus.graphics.*;
import rasmus.util.*;

import java.awt.*;

public class UISprite extends UIComponent {

    private Sprite sprite;

    public UISprite(Vector2i position, Sprite sprite) {
        super(position);
        this.sprite = sprite;
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), position.x, position.y, null);
    }
}
