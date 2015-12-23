package rasmus.entity.particle;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;

public class Particle extends Entity {

    protected double life;

    private int time;

    public Particle(Sprite sprite, double x, double y, double life, double speed) {
        super(sprite, x, y);
        this.life = life;

        xa = random.nextInt(3) - 1;
        ya = random.nextInt(3) - 1;
        setSpeed(speed);
    }

    public void update() {
        time++;
        if(time >= 7400) time = 0;
        if(time > life * 60) remove();

        move();
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), (int) x, (int) y, null);
    }
}
