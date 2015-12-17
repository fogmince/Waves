package rasmus.gameState;

import rasmus.Game;
import rasmus.graphics.Sprite;
import rasmus.graphics.ui.*;
import rasmus.util.*;

import java.awt.*;

public class MenuState extends GameState {

    private MenuUI ui;

    private UIButton play;
    private UIButton quit;

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        ui = new MenuUI();

        play = new UIButton(Sprite.buttonPlay, new Vector2i(Game.WIDTH / 2 - 100, 150));
        ui.addButton(play);

        quit = new UIButton(Sprite.buttonQuit, new Vector2i(Game.WIDTH / 2 - 103, 400));
        ui.addButton(quit);
    }

    public void update() {
        ui.update();

        if(play.isClicked()) gsm.setState(GameStateManager.PLAY_STATE);
        if(quit.isClicked()) System.exit(0);
    }

    public void render(Graphics g) {
        ui.render(g);
    }
}
