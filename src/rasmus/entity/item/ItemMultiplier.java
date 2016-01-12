package rasmus.entity.item;

import rasmus.graphics.*;

import java.awt.*;

public class ItemMultiplier extends Item {

    private final double multiplier = 2;
    private final int multiplierTime = 5;

    public ItemMultiplier(Sprite sprite, double x, double y) {
        super(sprite, x, y);

        setText("+ x " + multiplier + " Score");
        setTextTime(1);
        setTextColor(Color.CYAN);
        setDeSpawnTime(15);
    }

    public void update() {
        super.update();
        if(pickedUp()) {

            level.getPlayer().setMultiplier(multiplier, multiplierTime);

            remove();
            level.getPlayer().getUI().addPickUpText(getText(), getTextTime(), getTextX(), getTextY(), getTextColor());

            spawnParticles();
        }
    }
}
