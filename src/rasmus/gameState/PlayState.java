package rasmus.gameState;

import rasmus.entity.*;
import rasmus.graphics.*;
import rasmus.graphics.background.*;
import rasmus.graphics.ui.*;
import rasmus.graphics.ui.components.*;
import rasmus.level.*;
import rasmus.level.wave.*;
import rasmus.util.*;

import java.awt.*;

public class PlayState extends GameState {

    private Player player;
    private Level level;
    private Background background;
    private WaveHandler wave;

    private ScoreUI scoreUI;

    private UIButton menuButton_game;

    private UIButton restartButton;
    private UIButton menuButton;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(Sprite.player, 600, 30);
        level = new Level();
        level.add(player);
        wave  = new WaveHandler(level);
        background = new Background();

        //Menu Button
        menuButton_game = new UIButton(Sprite.buttonMenu, new Vector2i(15, 560));
        player.getUI().addButton(menuButton_game);

        //Score screen Buttons
        scoreUI = new ScoreUI(wave, player);

        restartButton = new UIButton(Sprite.buttonRestart, new Vector2i(80, 480));
        scoreUI.addButton(restartButton);

        menuButton = new UIButton(Sprite.buttonMenuBig, new Vector2i(600, 480));
        scoreUI.addButton(menuButton);
    }

    public void update() {
        background.update();
        level.update();

        if(!player.isDead()){
            wave.update();
            player.setWave(wave.getWave());

            if(menuButton_game.isClicked()) gsm.setState(GameStateManager.MENU_STATE);
        } else {
            scoreUI.update();

            if(restartButton.isClicked()) init();
            if(menuButton.isClicked()) gsm.setState(GameStateManager.MENU_STATE);
        }

    }

    public void render(Graphics g) {
        background.render(g);
        level.render(g);

        if(player.isDead()) scoreUI.render(g);
    }
}
