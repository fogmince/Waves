package rasmus.entity.item;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;


public class Item extends Entity {

    public Item(Sprite sprite, double x, double y) {
        super(sprite, x, y);
    }

    public void update() {

    }

    public void render(Graphics g) {
        super.render(g);
    }

    protected boolean pickedUp() {
        if(level.entityCollision(level.getPlayer(), this)) return true;

        return false;
    }
}
