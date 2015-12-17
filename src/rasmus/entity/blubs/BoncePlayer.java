package rasmus.entity.blubs;

import rasmus.*;
import rasmus.entity.*;
import rasmus.graphics.Sprite;
import rasmus.graphics.ui.*;
import rasmus.input.*;

import java.awt.*;

public class BoncePlayer extends Entity {

    private PlayerUI ui;
    private int health;

    public BoncePlayer(Sprite sprite, int x, int y) {
        super(sprite, x, y);

        //ui = new PlayerUI(this);

        setSpeed(6);
        health = 100;
    }

    public void update() {
        super.update();
        //ui.update();

        if(Keyboard.up) ya = -1;
        if(Keyboard.down) ya = 1;
        if(Keyboard.left) xa = -1;
        if(Keyboard.right) xa = 1;

        move();

        health--;
        if(health <= 0) health = 100;
    }

    /*protected void move() {
        if(collision(xa, 0)) this.xa = 0;
        if(collision(0, ya)) this.ya = 0;

        //System.out.println(xa);

        if (xa > 0) x += this.xa * xSpeed;
        if (xa < 0) x += this.xa * xSpeed;

        if (ya < 0) y += this.ya * ySpeed;
        if (ya > 0) y += this.ya * ySpeed;
    }*/

    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), (int) x, (int) y, width, height, null);
        //ui.render(g);
    }

    public int getHealth() {
        return health;
    }
}
