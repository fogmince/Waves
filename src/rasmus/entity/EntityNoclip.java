package rasmus.entity;


import rasmus.*;
import rasmus.graphics.*;

public class EntityNoclip extends Entity {

    public EntityNoclip(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        setSpeed(6);
    }

    public void update() {
        if(random.nextInt(100) == 1) {
            if(random.nextBoolean()) {
                xa = random.nextInt(3) - 1;
            } else {
                ya = random.nextInt(3) - 1;
            }
        }

        move();
    }

    protected boolean collision(double xa, double ya) {
        if(x < -16) x = Game.WIDTH;

        if(x > Game.WIDTH) x = 0;


        if(y < -16) y = Game.HEIGHT;

        if(y > Game.HEIGHT) y = 0;

        return false;
    }
}
