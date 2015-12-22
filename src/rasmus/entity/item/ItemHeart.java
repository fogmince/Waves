package rasmus.entity.item;

import rasmus.graphics.*;

import java.awt.*;

public class ItemHeart extends Item {

    private int health = 25;

    public ItemHeart(Sprite sprite, double x, double y) {
        super(sprite, x, y);

        setText("+ " + health + " Health");
        setTextTime(1);
        setTextColor(Color.RED);
    }

    public void update() {
        if(pickedUp()) {

            if(level.getPlayer().getHealth() + health > 100) {
                setText("+ " + ((level.getPlayer().getHealth() - 100) * -1) + " Health");
            }

            level.getPlayer().addHealth(health);

            remove();
            level.getPlayer().getUI().addPickUpText(getText(), getTextTime(), getTextX(), getTextY(), getTextColor());
        }
    }
}
