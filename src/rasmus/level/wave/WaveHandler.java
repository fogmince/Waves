package rasmus.level.wave;

import rasmus.*;
import rasmus.entity.*;
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

        wave = 1;
        waveTime = 10;
        timeScienceLastWave = 0;
    }

    public void update() {
        timeScienceLastWave += 0.0166666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666;

        if(timeScienceLastWave >= waveTime) nextWave();


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
        }
    }

    public int getWave() {
        return wave;
    }

}
