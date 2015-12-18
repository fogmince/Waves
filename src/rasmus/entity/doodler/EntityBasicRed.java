package rasmus.entity.doodler;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;

public class EntityBasicRed extends Entity {

    public EntityBasicRed(double x, double y, int width, int height) {
        super(Sprite.player, x, y);
        setSpeed(6);
        setWidth(width);
        setHeight(height);
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, width, height);
    }
}
