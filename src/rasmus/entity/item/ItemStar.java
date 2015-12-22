package rasmus.entity.item;

import rasmus.graphics.*;

import java.awt.*;

public class ItemStar extends Item {

    private int score;

    public ItemStar(Sprite sprite, double x, double y) {
        super(sprite, x, y);

        score = 500;

        setText("+ " + score + " Score");
        setTextTime(1);
        setTextColor(Color.YELLOW);
    }

    public void update() {
        if (pickedUp()) {
            level.getPlayer().addScore(score);
            remove();
            level.getPlayer().getUI().addPickUpText(getText(), getTextTime(), getTextX(), getTextY(), getTextColor());
        }
    }
}
