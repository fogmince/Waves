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

    private int timeSinceItem;
    private int itemTime;
    private boolean canSpawnItem;

    private final Random random = new Random();

    public WaveHandler(Level level) {
        this.level = level;

        wave = 0;
        waveTime = 10;
        timeScienceLastWave = 0;
        timeSinceItem = 0;
        itemTime = 5 + random.nextInt(15) * 60;
        canSpawnItem = false;
    }

    public void update() {
        if(wave == 0) {
            nextWave();
        }

        timeScienceLastWave += 0.0166666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666;

        if(timeScienceLastWave >= waveTime) nextWave();


        if(!canSpawnItem) {
            timeSinceItem++;
            if(timeSinceItem % itemTime == 0) {
                canSpawnItem();
                timeSinceItem = 0;
            }
        } else {
            itemTime = random.nextInt((15) + 5) * 60;
        }

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
               spawnFireer(new Sprite(0xFFAB2D, 64, 64));
                break;
            case 9 :
                level.add(new EntityNoclip(new Sprite(0xAA00FF, 32, 32), random.nextInt(960), random.nextInt(640)));
                break;
            case 10 :
                spawnFireer(new Sprite(0xFFAB2D, 64, 64));
        }
    }

    private void spawnItems() {
        if(wave >= 1 && canSpawnItem) {
            int rand = random.nextInt(8);

            switch (rand) {
                case 0 :
                    level.add(new ItemStar(Sprite.item_star, random.nextInt(Game.WIDTH - 40), random.nextInt((Game.HEIGHT - 64))));
                    canSpawnItem();
                    break;
                case 1 :
                    level.add(new ItemHeart(Sprite.item_heart, random.nextInt(Game.WIDTH - 40), random.nextInt((Game.HEIGHT - 64))));
                    canSpawnItem();
                    break;
                case 2 :
                    level.add(new ItemMultiplier(Sprite.item_scoreMultiplier, random.nextInt(Game.WIDTH - 40), random.nextInt((Game.HEIGHT - 64))));
                    canSpawnItem();
                    break;
            }
        }
    }

    public int getWave() {
        return wave;
    }

    public void canSpawnItem() {
        if(canSpawnItem) canSpawnItem = false;
        else canSpawnItem = true;
    }

    private void spawnFireer(Sprite sprite) {
        int pos = random.nextInt(4);

        if(pos == 0) {
            level.add(new EntityFireer(sprite, Game.WIDTH - 70, Game.HEIGHT / 2, pos));
        } else if(pos == 1) {
            level.add(new EntityFireer(sprite, Game.WIDTH / 2, Game.HEIGHT - 92, pos));
        } else if(pos == 2) {
            level.add(new EntityFireer(sprite, 2, Game.HEIGHT / 2, pos));
        } else if(pos == 3) {
            level.add(new EntityFireer(sprite, Game.WIDTH / 2, 2, pos));
        }
    }
}
