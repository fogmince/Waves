package rasmus.entity;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;

public class EntityCircle extends Entity {

    public EntityCircle(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        setXSpeed(7);
        setYSpeed(10);
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, width, height);
    }
}
