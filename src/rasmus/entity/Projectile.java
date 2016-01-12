package rasmus.entity;

import rasmus.graphics.*;

public class Projectile extends Entity {

    protected double damage;

    public Projectile(Sprite sprite, double x, double y, int dir) {
        super(sprite, x, y);
        setSpeed(4);
        damage = 0.3;

        if (dir == 0) {
            xa = -1;
            ya = 0;
        } else if (dir == 2) {
            xa = 1;
            ya = 0;
        } else if (dir == 1) {
            ya = -1;
            xa = 0;
        } else if (dir == 3) {
            ya = 1;
            xa = 0;
        }
    }

    public void update() {
        if (collision(xa, ya)) remove();
        move();
    }

    public double getDamage() {
        return damage;
    }
}
