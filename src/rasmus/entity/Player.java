package rasmus.entity;

import rasmus.*;
import rasmus.graphics.Sprite;
import rasmus.graphics.ui.*;
import rasmus.input.*;
import rasmus.level.wave.*;

import java.awt.*;

public class Player extends Entity {

    private PlayerUI ui;

    private double health;
    private double score;
    private double scoreMultiplier;
    private int wave;

    public Player(Sprite sprite, int x, int y) {
        super(sprite, x, y);

        ui = new PlayerUI(this);

        setSpeed(7);
        health = 100;
        score = 0;
        //SCORE PER UPDATE 18 per sec
        scoreMultiplier = 0.3;
    }

    public void update() {
        super.update();

        score += scoreMultiplier;

        if(Keyboard.up) ya = -1;
        if(Keyboard.down) ya = 1;
        if(Keyboard.left) xa = -1;
        if(Keyboard.right) xa = 1;

        move();

        if(level.getNearestEntity(this, 10000) != null && level.entityCollision(level.getNearestEntity(this, 10000), this)) {
            //DMG DEALT PER UPDATE 30 PER SEC
            dealDmg(0.5);
        }

        if(level.getNearestProjectile(this, 10000) != null && level.entityCollision(level.getNearestProjectile(this, 10000), this)) {
            dealDmg(level.getNearestProjectile(this, 1000).getDamage());
        }

        xa = 0;
        ya = 0;

        //System.out.println("X: " + x + ", Y: " + y);

        ui.update();


        if(Keyboard.esc) health = 0;
        if(health <= 0) {
            level.clearEntities();
            remove();
        }
    }

   protected void move() {
        if(collision(xa, 0)) xa = 0;
        if(collision(0, ya)) ya = 0;

        if (xa < 0) dir = 0;
        if (xa > 0) dir = 2;
        if (ya < 0) dir = 1;
        if (ya > 0) dir = 3;

        x += xa * xSpeed;
        y += ya * ySpeed;
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
