package rasmus.entity.doodler;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;

public class EntityBasicYellow extends Entity {

    public EntityBasicYellow(double x, double y, int width, int height) {
        super(Sprite.item_star, x, y);
        setXSpeed(7);
        setYSpeed(10);
        setWidth(width);
        setHeight(height);
    }

    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, width, height);
    }
}
