package rasmus.entity;

import rasmus.graphics.Sprite;
import rasmus.graphics.ui.*;
import rasmus.input.*;

import java.awt.*;

public class Player extends Entity {

    private PlayerUI ui;
    private double health;

    public Player(Sprite sprite, int x, int y) {
        super(sprite, x, y);

        ui = new PlayerUI(this);

        setSpeed(6);
        health = 100;
    }

    public void update() {
        super.update();
        ui.update();

        if(Keyboard.up) ya = -1;
        if(Keyboard.down) ya = 1;
        if(Keyboard.left) xa = -1;
        if(Keyboard.right) xa = 1;

        move();

        if(level.getNearestEntity(this, 10000) != null && level.entityCollision(level.getNearestEntity(this, 10000), this)) {
            dealDmg(0.5);
        }

        xa = 0;
        ya = 0;
    }

    protected void move() {
        if(collision(xa, 0)) xa = 0;
        if(collision(0, ya)) ya = 0;

        if (xa > 0) x += xa * xSpeed;
        if (xa < 0) x += xa * xSpeed;

        if (ya < 0) y += ya * ySpeed;
        if (ya > 0) y += ya * ySpeed;
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), (int) x, (int) y, width, height, null);
        ui.render(g);
    }

    public int getHealth() {
        return (int) health;
    }

    public void dealDmg(double dmg) {
        health -= dmg;
        if(health - dmg < 0) health = 0;
    }

    public void addHealth(int health) {
        this.health += health;
        if(this.health > 100) this.health = 100;
    }
}
