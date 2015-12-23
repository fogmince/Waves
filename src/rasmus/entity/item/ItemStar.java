package rasmus.entity.item;

import rasmus.entity.particle.*;
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
        setDeSpawnTime(15);
    }

    public void update() {
        super.update();
        if (pickedUp()) {
            level.getPlayer().addScore(score);
            remove();
            level.getPlayer().getUI().addPickUpText(getText(), getTextTime(), getTextX(), getTextY(), getTextColor());

            spawnParticles();
        }
    }

    public void spawnParticles() {
        for(int i = 0; i < random.nextInt(5) + 6; i++) {
            level.add(new Particle(Sprite.yellow_particle, x + random.nextInt(3) - 1, y + random.nextInt(3) - 1, random.nextDouble(), 0.3));
        }
    }
}
