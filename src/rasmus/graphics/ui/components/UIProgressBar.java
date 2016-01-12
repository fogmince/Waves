package rasmus.graphics.ui.components;

import org.w3c.dom.ranges.*;
import rasmus.util.*;

import java.awt.*;

public class UIProgressBar extends UIComponent {
    private Vector2i size;
    private Color foreground;

    private double progress; //0.0 - 1.0

    public UIProgressBar(Vector2i position, Vector2i size) {
        super(position);
        this.size = size;
        color = Color.GRAY;
        foreground = Color.RED;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x, position.y, size.x, size.y);

        g.setColor(foreground);
        g.fillRect(position.x, position.y, (int) (progress * size.x), size.y);
    }

    public void setProgress(double progress) {
        if(progress < 0.0 || progress > 1.0) {
            throw new RangeException(RangeException.BAD_BOUNDARYPOINTS_ERR, "Progress must be between 0.0 and 1.0");
        }

        this.progress = progress;
    }
}
