package rasmus.entity.item;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;


public class Item extends Entity {

    private String text;
    private double textX, textY;
    private double textTime;
    private Color textColor;

    private double deSpawnTime = 10;
    private int time;

    private boolean blink = false;
    private int renderTime = 0;

    public Item(Sprite sprite, double x, double y) {
        super(sprite, x, y);
        textX = x;
        textY = y;
    }

    public void update() {
        time++;

        if(time >= (getDeSpawnTime() - 3) * 60) {
            blink = true;
            renderTime++;

            if(renderTime >= 30) renderTime = 0;
        }

        if(time >= getDeSpawnTime() * 60) onDeSpawn();
    }

    public void render(Graphics g) {
        if(!blink) super.render(g);
        else {
            if(renderTime > 20) {
                super.render(g);
            }
        }
    }

    public void onDeSpawn() {
        remove();
        spawnParticles();
    }

    public void spawnParticles() {
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

    public void setDeSpawnTime(int time) {
        deSpawnTime = time;
    }

    public double getDeSpawnTime() {
        return deSpawnTime;
    }
}
