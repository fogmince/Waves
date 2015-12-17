package rasmus.graphics.ui;


import rasmus.*;
import rasmus.entity.*;
import rasmus.entity.blubs.*;
import rasmus.graphics.*;
import rasmus.level.wave.*;
import rasmus.util.*;

import java.awt.*;

public class PlayerUI {

    private Player player;
    private UIHandler handler;

    private UIProgressBar healthBar;
    private UILabel healthAmount;
    private UILabel score;

    public PlayerUI(Player player) {
        this.player = player;
        handler = new UIHandler();

        healthBar = new UIProgressBar(new Vector2i(20, 30), new Vector2i(200, 35));
        handler.addComponent(healthBar);

        healthAmount = new UILabel(new Vector2i(100, 58), String.valueOf(player.getHealth())).setColor(new Color(0xF4F5FF)).setFont(new Font("Arial", Font.ITALIC, 30));
        handler.addComponent(healthAmount);

        score = new UILabel(new Vector2i(25, 90), "Score: " + String.valueOf(player.getScore())).setColor(Color.LIGHT_GRAY).setFont(new Font("Helvetica", Font.PLAIN, 18));
        handler.addComponent(score);
    }


    public void update() {
        handler.update();

        healthBar.setProgress(player.getHealth() / 100.0);
        healthAmount.setText(String.valueOf(player.getHealth()));
        score.setText("Score: " + String.valueOf(player.getScore()));

        if(player.getHealth() < 10) {
            healthAmount.setPosition(110, 58);
        } else {
            healthAmount.setPosition(100, 58);
        }
    }

    public void render(Graphics g) {
        handler.render(g);
    }

}
