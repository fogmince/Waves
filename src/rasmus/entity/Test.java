package rasmus.entity;


import rasmus.entity.particle.*;
import rasmus.graphics.*;

import java.awt.*;

public class Test extends Entity {

    public Test(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        setXSpeed(5);
        setYSpeed(3);
    }

    int time = 0;

    public void update() {
        time++;
        if(time % (30 + random.nextInt(90)) == 0) {
            xa = random.nextInt(3) - 1;
            ya = random.nextInt(3) - 1;
        }

        if(time % 120 + random.nextInt(120) == 0) {
            xSpeed = random.nextDouble() + random.nextInt(8) + 1;
            ySpeed = random.nextDouble() + random.nextInt(8) + 1;
        }

        if(time % (5 + random.nextInt(15)) == 0) {
            for(int i = 0; i < random.nextInt(3); i++) {
                level.add(new Particle(Sprite.test_particle, (int) x + 8 + random.nextInt(8), (int) y + 2 + random.nextInt(30), 30 + random.nextInt(20), xa, ya));
                level.add(new Particle(Sprite.test_particle, (int) x + 8 + random.nextInt(8), (int) y + 2 + random.nextInt(30), 30 + random.nextInt(20), xa, ya));
            }
        }

        move();
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, width, height);
    }
}
