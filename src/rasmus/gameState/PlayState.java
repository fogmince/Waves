package rasmus.gameState;

import rasmus.entity.*;
import rasmus.entity.doodler.*;
import rasmus.entity.item.*;
import rasmus.graphics.*;
import rasmus.graphics.ui.*;
import rasmus.level.*;
import rasmus.level.wave.*;
import rasmus.util.*;

import java.awt.*;

public class PlayState extends GameState {

    private Player player;
    private Level level;
    private WaveHandler wave;

    private UIButton menu;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        menu = new UIButton(Sprite.buttonMenu, new Vector2i(15, 560));


        player = new Player(Sprite.player, 600, 30);
        level = new Level();
        wave  = new WaveHandler(level);

        level.add(player);

        ///// TEST

        level.add(new ItemHeart(Sprite.item_heart, 345, 345));
        level.add(new ItemStar(Sprite.item_star, 600, 400));
    }

    public void update() {
        level.update();
        menu.update();
        wave.update();

        if(menu.isClicked()) gsm.setState(GameStateManager.MENU_STATE);
    }

    public void render(Graphics g) {
        level.render(g);
        menu.render(g);
        wave.render(g);
    }
}
