package rasmus.entity;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;

public class EntitySquare extends Entity {

    public EntitySquare(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        setSpeed(6);
    }
}
