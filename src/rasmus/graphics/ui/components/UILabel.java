package rasmus.graphics.ui.components;

import rasmus.util.*;

import java.awt.*;

public class UILabel extends UIComponent {

    private String text;
    private Font font;

    public UILabel(Vector2i position, String text) {
        super(position);
        this.text = text;
        font = new Font("Helvetica", Font.PLAIN, 32);
    }

    public void render(Graphics g) {
        g.setFont(font);
        g.setColor(color);

        g.drawString(text, position.x, position.y);
    }

    public UILabel setFont(Font font) {
        this.font = font;
        return this;
    }

    public UILabel setColor(Color color) {
        this.color = color;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }
}
