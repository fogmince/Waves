package rasmus.entity.item;

import rasmus.*;
import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;


public class Item extends Entity {

    private String text;
    private double textX, textY;
    private double textTime;
    private Color textColor;

    public Item(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        textX = x;
        textY = y;
    }

    public void update() {

    }

    public void render(Graphics g) {
        super.render(g);
    }

    protected boolean pickedUp() {
        if(level.entityCollision(level.getPlayer(), this)) return true;

        return false;
    }

    public void remove() {
        super.remove();

    }

    public void setTextPos(double x, double y) {
        textX = x;
        textY = y;
    }

    public void setTextTime(int time) {
        textTime = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setTextColor(Color color) {
        textColor = color;
    }

    public double getTextTime() {
        return textTime;
    }

    public double getTextX() {
        return textX;
    }

    public double getTextY() {
        return textY;
    }

    public Color getTextColor() {
        return textColor;
    }
}
