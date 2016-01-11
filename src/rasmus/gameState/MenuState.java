package rasmus.gameState;

import rasmus.Game;
import rasmus.entity.*;
import rasmus.graphics.Sprite;
import rasmus.graphics.background.*;
import rasmus.graphics.ui.*;
import rasmus.level.*;
import rasmus.util.*;

import java.awt.*;
import java.util.*;

public class MenuState extends GameState {

    private MenuUI ui;
    private Level level;

    private UIButton play;
    private UIButton help;
    private UIButton quit;

    private MenuBackground bg;

    private final Random random = new Random();

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        bg = new MenuBackground();
        level = new Level();
        level.add(new EntitySquare(new Sprite(0xFF0000, 32, 32), random.nextInt(960), random.nextInt(640)));


        ui = new MenuUI();

        play = new UIButton(Sprite.buttonPlay, new Vector2i(Game.WIDTH / 2 - 100, 190));
        ui.addButton(play);

        help = new UIButton(Sprite.buttonHelp, new Vector2i(Game.WIDTH / 2 - 100, 335));
        ui.addButton(help);

        quit = new UIButton(Sprite.buttonQuit, new Vector2i(Game.WIDTH / 2 - 100, 480));
        ui.addButton(quit);

    }

    public void update() {
        bg.update();
        level.update();
        ui.update();

        if(play.isClicked()) gsm.setState(GameStateManager.PLAY_STATE);
        if(quit.isClicked()) System.exit(0);
    }

    public void render(Graphics g) {
        bg.render(g);
        level.render(g);
        ui.render(g);
    }
}
