package rasmus.entity.item;

import rasmus.entity.particle.*;
import rasmus.graphics.*;

import java.awt.*;

public class ItemHeart extends Item {

    private int health = 25;

    public ItemHeart(Sprite sprite, double x, double y) {
        super(sprite, x, y);

        setText("+ " + health + " Health");
        setTextTime(1);
        setTextColor(Color.RED);
        setDeSpawnTime(15);
    }

    public void update() {
        super.update();
        if(pickedUp()) {
            if(level.getPlayer().getHealth() + health > 100) {
                setText("+ " + ((level.getPlayer().getHealth() - 100) * -1) + " Health");
            }

            level.getPlayer().addHealth(health);

            remove();
            level.getPlayer().getUI().addPickUpText(getText(), getTextTime(), getTextX(), getTextY(), getTextColor());

            spawnParticles();
        }
    }

    public void spawnParticles() {
        for(int i = 0; i < random.nextInt(5) + 6; i++) {
            level.add(new Particle(Sprite.red_particle, x + random.nextInt(3) - 1, y + random.nextInt(3) - 1, random.nextDouble(), 0.3));
        }
    }
}
