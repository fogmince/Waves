package rasmus.graphics.ui;

import rasmus.graphics.Sprite;
import rasmus.util.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class MenuUI {

    private UIHandler handler;

    public MenuUI() {
        handler = new UIHandler();
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
