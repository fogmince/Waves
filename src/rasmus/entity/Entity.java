package rasmus.entity;

import rasmus.*;
import rasmus.graphics.Sprite;
import rasmus.level.*;
import rasmus.level.wave.*;

import java.awt.Graphics;
import java.util.*;

public class Entity {

    protected Sprite sprite;
    protected double x, y;
    protected int width, height;

    protected double xSpeed, ySpeed;

    protected int xa = 0, ya = 0;
    protected final Random random = new Random();

    protected Level level;

    private boolean removed;

    public Entity(Sprite sprite, double x, double y) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        width = sprite.getSprite().getWidth();
        height = sprite.getSprite().getHeight();
        xSpeed = 1;
        ySpeed = 1;
    }

    public void update() {
    }

    protected void move() {
        if(collision(xa, 0)) xa *= -1;
        if(collision(0, ya)) ya *= -1;

        if (xa > 0) x += xa * xSpeed;
        if (xa < 0) x += xa * xSpeed;

        if (ya < 0) y += ya * ySpeed;
        if (ya > 0) y += ya * ySpeed;
    }

    protected boolean collision(double xa, double ya) {
        boolean collision = false;

        if(xa == -1 && x + xa < 0) collision = true;
        if(xa == 1 && x + xa > Game.WIDTH - width * 2 + 23) collision = true;

        if(ya == -1 && y + ya < 0) collision = true;
        if(ya == 1 && y + ya > Game.HEIGHT - height * 2 + 1) collision = true;

        return collision;
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), (int) x, (int) y, null);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    protected void setSpeed(double speed) {
        xSpeed = speed;
        ySpeed = speed;
    }

    public void setXSpeed(double speed) {
        xSpeed = speed;
    }

    public void setYSpeed(double speed) {
        ySpeed = speed;
    }

    public double getSpeed() {
        if(xSpeed == ySpeed) return xSpeed;
        else return (xSpeed + ySpeed) / 2;
    }

    public void remove() {
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
