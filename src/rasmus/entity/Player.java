package rasmus.entity;

import rasmus.graphics.Sprite;
import rasmus.graphics.ui.*;
import rasmus.input.*;
import rasmus.level.wave.*;

import java.awt.*;

public class Player extends Entity {

    private PlayerUI ui;

    private double health;
    private double score;
    private int wave;

    public Player(Sprite sprite, int x, int y) {
        super(sprite, x, y);

        ui = new PlayerUI(this);

        setSpeed(7);
        health = 100;
        score = 0;
    }

    public void update() {
        super.update();

        //SCORE PER UPDATE 18 per sec
        score += 0.3;

        if(Keyboard.up) ya = -1;
        if(Keyboard.down) ya = 1;
        if(Keyboard.left) xa = -1;
        if(Keyboard.right) xa = 1;

        move();

        if(level.getNearestEntity(this, 10000) != null && level.entityCollision(level.getNearestEntity(this, 10000), this)) {
            //DMG DEALT PER UPDATE 30 PER SEC
            dealDmg(0.5);
        }

        xa = 0;
        ya = 0;

        //System.out.println("X: " + x + ", Y: " + y);

        ui.update();

        if(health <= 0) {
            level.clearEntities();
            remove();
        }
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

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return (int) score;
    }

    public PlayerUI getUI() {
        return ui;
    }

    public boolean isDead() {
        return isRemoved();
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
}
