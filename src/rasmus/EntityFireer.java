package rasmus;

import rasmus.entity.*;
import rasmus.graphics.*;

public class EntityFireer extends Entity {

    /**
     * TODO: BE ABLE TO SPAWN IN MULTIPLE POSITIONS AND DIRE IN THE RIGHT DIRECTION
     */

    public EntityFireer(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        setSpeed(4);
        xa = 0;

        //Firering dir
        dir = 0;
    }

    public void update() {
        fireProjectilesRand(20, Sprite.red_particle);

        move();
    }

    protected void move() {
        if(collision(xa, 0)) xa *= -1;
        if(collision(0, ya)) ya *= -1;

        x += xa * xSpeed;
        y += ya * ySpeed;
    }
}
