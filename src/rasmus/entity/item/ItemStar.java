package rasmus.entity.item;

import rasmus.graphics.*;

public class ItemStar extends Item {

    public ItemStar(Sprite sprite, double x, double y) {
        super(sprite, x, y);
    }

    public void update() {
        if(pickedUp()) {
            level.getPlayer().addScore(500);
            remove();
        }
    }

}
