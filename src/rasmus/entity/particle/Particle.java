package rasmus.entity.particle;

import rasmus.entity.*;
import rasmus.graphics.*;

import java.awt.*;

public class Particle extends Entity {

    protected int life;

    private int time;

    public Particle(Sprite sprite, double x, double y, int life) {
        super(sprite, x, y);
        this.life = life;
    }

    public Particle(Sprite sprite, double x, double y, int life, int xa, int ya) {
        super(sprite, x, y);
        this.life = life;
        this.xa = xa;
        this.ya = ya;
        xSpeed = random.nextDouble() + random.nextInt(2);
        ySpeed = random.nextDouble() + random.nextInt(2);
    }

    public void update() {
        time++;
        if(time >= 7400) time = 0;
        if(time > life) remove();

        if(time % (2 + random.nextInt(6)) == 0) {
            //xa += random.nextInt(3) - 1;
            //ya += random.nextInt(3) - 1;
            xSpeed = random.nextDouble() + random.nextInt(2);
            ySpeed = random.nextDouble() + random.nextInt(2);
        }

        move();
    }

    public void render(Graphics g) {
        g.drawImage(sprite.getSprite(), (int) x, (int) y, null);
    }
}
