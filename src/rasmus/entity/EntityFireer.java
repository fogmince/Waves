package rasmus.entity;

import rasmus.graphics.*;

public class EntityFireer extends Entity {

    public EntityFireer(Sprite sprite, double x, double y, int dir) {
        super(sprite, x, y);
        setSpeed(4);

        if(dir == 0 || dir == 2) xa = 0;
        if(dir == 1 || dir == 3) ya = 0;

        //Firering dir
        this.dir = dir;
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
