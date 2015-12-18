package rasmus.gameState;

import rasmus.Game;
import rasmus.entity.doodler.*;
import rasmus.graphics.Sprite;
import rasmus.graphics.ui.*;
import rasmus.level.*;
import rasmus.util.*;

import java.awt.*;
import java.util.*;

public class MenuState extends GameState {

    private MenuUI ui;
    private Level level;

    private UIButton play;
    private UIButton quit;

    private final Random random = new Random();

    public MenuState(GameStateManager gsm) {
        super(gsm);
        level = new Level();

        level.add(new EntityBasicRed(random.nextInt(960), random.nextInt(940), 32, 32));
    }

    public void init() {
        ui = new MenuUI();

        play = new UIButton(Sprite.buttonPlay, new Vector2i(Game.WIDTH / 2 - 100, 130));
        ui.addButton(play);

        quit = new UIButton(Sprite.buttonQuit, new Vector2i(Game.WIDTH / 2 - 103, 400));
        ui.addButton(quit);
    }

    public void update() {
        level.update();
        ui.update();

        if(play.isClicked()) gsm.setState(GameStateManager.PLAY_STATE);
        if(quit.isClicked()) System.exit(0);
    }

    public void render(Graphics g) {
        level.render(g);
        ui.render(g);
    }
}
