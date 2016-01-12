package rasmus.level.wave;

import rasmus.*;
import rasmus.entity.*;
import rasmus.entity.item.*;
import rasmus.graphics.*;
import rasmus.level.*;

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

    private void nextWave() {
        wave++;
        timeScienceLastWave = 0;
        waveTime += 0.5;

        switch (wave) {
            case 1 :
                level.add(new EntitySquare(new Sprite(0xFF0000, 32, 32), random.nextInt(960), random.nextInt(640)));
                break;
            case 2 :
                level.add(new EntitySquare(new Sprite(0xFF0000, 32, 32), random.nextInt(960), random.nextInt(640)));
                break;
            case 3 :
                level.add(new EntityCircle(new Sprite(0xFFFF00, 32, 32), random.nextInt(960), random.nextInt(640)));
                break;
            case 4 :
                level.add(new EntitySquare(new Sprite(0xFF0000, 32, 32), random.nextInt(960), random.nextInt(640)));
                break;
            case 5 :
                level.add(new EntityChaser(new Sprite(0xFF00, 16, 16), random.nextInt(960), random.nextInt(640)));
                break;
            case 6 :
                level.add(new EntityCircle(new Sprite(0xFF0000, 48, 48), random.nextInt(960), random.nextInt(640)));
                break;
            case 7 :
                level.add(new EntityNoclip(new Sprite(0xAA00FF, 32, 32), random.nextInt(960), random.nextInt(640)));
                break;
            case 8 :
                level.add(new EntityFireer(new Sprite(0xFFA228, 64, 64), Game.WIDTH - 70, Game.HEIGHT / 2));
                break;
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
