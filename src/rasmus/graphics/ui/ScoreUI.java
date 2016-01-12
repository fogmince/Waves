package rasmus.graphics.ui;

import rasmus.*;
import rasmus.entity.*;
import rasmus.graphics.*;
import rasmus.graphics.ui.components.*;
import rasmus.level.wave.*;
import rasmus.util.*;

import java.awt.*;

public class ScoreUI {

    private UIHandler handler;
    private WaveHandler waveHandler;
    private Player player;

    private UISprite gameOver;

    private UILabel score;
    private UILabel wave;

    public ScoreUI(WaveHandler waveHandler, Player player) {
        this.waveHandler = waveHandler;
        this.player = player;
        handler = new UIHandler();

        gameOver = new UISprite(new Vector2i(Game.WIDTH / 2 - 273, 60), Sprite.gameGameOver);
        handler.addComponent(gameOver);

        wave = new UILabel(new Vector2i(Game.WIDTH / 2 - 150, 300), "").setColor(new Color(0xFFFFFF));
        handler.addComponent(wave);

        score = new UILabel(new Vector2i(Game.WIDTH / 2 - 150, 350), "").setColor(new Color(0xFFFFFF));
        handler.addComponent(score);
    }

    public void update() {
        handler.update();

        wave.setText(String.valueOf("You make it to Wave: " + waveHandler.getWave()));
        score.setText(String.valueOf("With a Score of: " + player.getScore()));
    }

    public void render(Graphics g) {
        handler.render(g);
    }

    public void addButton(UIButton b) {
        handler.addComponent(b);
    }
}
