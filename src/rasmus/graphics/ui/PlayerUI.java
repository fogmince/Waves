package rasmus.graphics.ui;


import rasmus.*;
import rasmus.entity.*;
import rasmus.entity.blubs.*;
import rasmus.graphics.*;
import rasmus.level.wave.*;
import rasmus.util.*;

import java.awt.*;
import java.util.*;
import java.util.List;

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

        score = new UILabel(new Vector2i(25, 90), "Score: " + String.valueOf(player.getScore())).setColor(new Color(0x08343A)).setFont(new Font("Helvetica", Font.PLAIN, 18));
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

        for(int i = 0; i < handler.getAmountOfComponents(); i++) {
            if(handler.getComponent(i).isRemoved()) handler.removeComponent(i);
        }
    }

    public void addPickUpText(String text, double time, double x, double y, Color color) {
        handler.addComponent(new UIPickupText(new Vector2i((int) x, (int) y), text, time, color));
    }

    public void render(Graphics g) {
        handler.render(g);
    }

}
