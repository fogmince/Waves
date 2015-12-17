package rasmus.entity.item;

import rasmus.graphics.*;

public class ItemHeart extends Item {

    public ItemHeart(Sprite sprite, double x, double y) {
        super(sprite, x, y);
    }

    public void update() {
        if(pickedUp()) {
            level.getPlayer().addHealth(25);
            remove();
        }
    }
}
