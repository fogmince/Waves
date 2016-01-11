package rasmus.entity;

import rasmus.graphics.*;

public class EntityChaser extends Entity {

    public EntityChaser(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        setSpeed(2);
    }

    public void update() {
        double px = level.getPlayer().getX() + 8;
        double py = level.getPlayer().getY() + 8;

        if (x < px) xa = 1;
        if (x > px) xa = -1;
        if (y < py) ya = 1;
        if (y > py) ya = -1;

        if (Math.floor(x) == Math.floor(px)) xa = 0;
        if (Math.floor(y) == Math.floor(py)) ya = 0;


        move();
    }
}
