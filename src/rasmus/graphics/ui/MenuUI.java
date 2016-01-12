package rasmus.graphics.ui;

import rasmus.*;
import rasmus.graphics.Sprite;
import rasmus.graphics.ui.components.*;
import rasmus.util.*;

import java.awt.Graphics;

public class MenuUI {

    private UIHandler handler;

    private UISprite title;

    public MenuUI() {
        handler = new UIHandler();

        title = new UISprite(new Vector2i(Game.WIDTH / 2 - Sprite.gameTitle.getSprite().getWidth() / 2, 20), Sprite.gameTitle);
        handler.addComponent(title);
    }

    public void update() {
        handler.update();
    }

    public void render(Graphics g) {
        handler.render(g);
    }

    public void addButton(UIButton b) {
        handler.addComponent(b);
    }
}
