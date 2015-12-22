package rasmus.level.wave;

import rasmus.*;
import rasmus.entity.doodler.*;
import rasmus.entity.item.*;
import rasmus.graphics.*;
import rasmus.level.*;

import java.awt.*;
import java.util.*;

public class WaveHandler {

    private Level level;

    private int wave;
    private double waveTime;
    private double timeScienceLastWave;

    private final Random random = new Random();

    public WaveHandler(Level level) {
        this.level = level;

        wave = 0;
        waveTime = 10;
        timeScienceLastWave = 0;
    }

    public void update() {
        if(wave == 0) {
            nextWave();
        }

        timeScienceLastWave += 0.0166666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666;

        if(timeScienceLastWave >= waveTime) nextWave();


        spawnItems();
    }

    public void render(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Helvetica", Font.PLAIN, 24));
        g.drawString("Wave: " + Integer.toString(wave), Game.WIDTH - 120, 40);
    }

    private void nextWave() {
        wave++;
        timeScienceLastWave = 0;

        switch (wave) {
            case 1 :
                level.add(new EntityBasicRed(random.nextInt(960), random.nextInt(640), 32, 32));
                break;
            case 2 :
                level.add(new EntityBasicRed(random.nextInt(960), random.nextInt(640), 32, 32));
                break;
            case 3 :
                level.add(new EntityBasicYellow(random.nextInt(960), random.nextInt(640), 32, 32));
        }
    }

    private void spawnItems() {
        if(wave >= 1 && random.nextInt(500) == 0) {
            if(random.nextBoolean()) {
                level.add(new ItemStar(Sprite.item_star, random.nextInt(Game.WIDTH - 40), random.nextInt((Game.HEIGHT - 64))));
            } else {
                level.add(new ItemHeart(Sprite.item_heart, random.nextInt(Game.WIDTH - 40), random.nextInt(Game.HEIGHT - 64)));
            }
        }
    }

    public int getWave() {
        return wave;
    }

}
