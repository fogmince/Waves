package rasmus.graphics.ui.components;

import rasmus.util.*;

import java.awt.*;

public class UIPickupText extends UIComponent {

    private String text;
    private double displayTime;
    private int time;

    private Font font;

    public UIPickupText(Vector2i position, String text, double time, Color color) {
        super(position);
        this.text = text;
        displayTime = time;
        this.time = 0;
        font = new Font("Helvetica", Font.PLAIN, 32);
        setColor(color);

        //Trys to make sure text doesn't get off the screen.
        if(position.x > 750) position.x -= 0.2 * position.x;
        if(position.y < 80) position.y += 100;
    }

    public void update() {
        time++;
        if(time >= displayTime * 60) remove();

        position.x += 1;
        position.y -= 1;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.setFont(font);

        g.drawString(text, position.x, position.y);
    }
}
