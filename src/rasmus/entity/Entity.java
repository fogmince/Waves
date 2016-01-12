package rasmus.entity;

import rasmus.*;
import rasmus.entity.projectile.*;
import rasmus.graphics.*;
import rasmus.level.*;

import java.awt.*;
import java.util.*;

public class Entity {

    protected Sprite sprite;
    protected double x, y;
    protected int width, height;

    protected double xSpeed, ySpeed;
    protected int dir;

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

        while (xa == 0) xa = random.nextInt(3) - 1;
        while (ya == 0) ya = random.nextInt(3) - 1;
    }

    public void update() {
        move();
    }

    protected void move() {
        if(collision(xa, 0)) xa *= -1;
        if(collision(0, ya)) ya *= -1;

        if (xa < 0) dir = 0;
        if (xa > 0) dir = 2;
        if (ya < 0) dir = 1;
        if (ya > 0) dir = 3;

        x += xa * xSpeed;
        y += ya * ySpeed;
    }

    protected boolean collision(double xa, double ya) {
        boolean collision = false;

        if(xa < 0 && x + xa <= 0) collision = true;
        if(xa > 0 && x + width + xa >= Game.WIDTH - 5) collision = true;

        if(ya < 0 && y + ya <= 0) collision = true;
        if(ya > 0 && y + height + ya > Game.HEIGHT - 30) collision = true;

        return collision;
    }

    public void fireProjectilesRand(int chance, Sprite sprite) {
        if(random.nextInt(chance) == 0) {
            level.add(new Projectile(sprite, x + width / 2 - 1, y + width / 2 - 1, dir));
        }
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

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected void setSqaure(int size) {
        width = height = size;
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
