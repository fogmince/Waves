package rasmus.level.wave;

import rasmus.*;
import rasmus.entity.*;
import rasmus.graphics.*;
import rasmus.level.*;

import java.awt.*;

public class WaveHandler {

    private Level level;

    private int wave;
    private double waveTime;
    private double timeScienceLastWave;

    public WaveHandler(Level level) {
        this.level = level;

        wave = 1;
        waveTime = 2;
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
        System.out.println(wave);

        switch (wave) {
            case 4 :
                level.add(new Test(Sprite.player, 404, 404));
        }
    }

    public int getWave() {
        return wave;
    }

}
