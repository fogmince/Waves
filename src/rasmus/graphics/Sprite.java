package rasmus.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    private static final String itemPath = "/textures/items/";
    private static final String uiPath = "/textures/ui/";
    private static final String entityPath = "/textures/entity/";
    private static final String particlePath = "/textures/entity/particle/";
    private static final String projectilePath = "/textures/entity/projectile/";

    //UI
    public static final Sprite gameTitle = new Sprite(uiPath + "game_title");
    public static final Sprite buttonPlay = new Sprite(uiPath + "button_Play");
    public static final Sprite buttonHelp = new Sprite(uiPath + "button_Help");
    public static final Sprite buttonQuit = new Sprite(uiPath + "button_Quit");

    public static final Sprite gameGameOver = new Sprite(uiPath + "game_GameOver");

    public static final Sprite buttonMenu = new Sprite(uiPath + "button_Menu");

    public static final Sprite buttonMenuBig = new Sprite(uiPath + "button_Menu_big");
    public static final Sprite buttonRestart = new Sprite(uiPath + "button_Restart");

    //Entity
    public static final Sprite player = new Sprite(entityPath + "player");

    //Particle
    public static final Sprite red_particle = new Sprite(0xFF0000, 8, 8);
    public static final Sprite yellow_particle = new Sprite(0xFFFF00, 8, 8);

    //Projectile
    public static final Sprite projectile_Red = new Sprite(projectilePath + "projectile_red");

    //Items
    public static final Sprite item_heart = new Sprite(itemPath + "heart");
    public static final Sprite item_star = new Sprite(itemPath + "star");
    public static final Sprite item_scoreMultiplier = new Sprite(itemPath + "scoreMultiplier");

    private String path;
    private int width, height;
    private int[] pixels;

    private BufferedImage image;

    public Sprite(String path) {
        this.path = path + ".png";
        loadImage();
    }

    public Sprite(int color, int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];

        for(int i = 0; i < pixels.length; i++)  {
            pixels[i] = color;
        }

        image = new BufferedImage(width, height, 1);

        image.setRGB(0, 0, width, height, pixels, 0, width);
    }

    public Sprite(int[] pixels, int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[pixels.length];

        for(int i = 0; i < pixels.length; i++) {
            this.pixels[i] = pixels[i];

            if(this.pixels[i] == 0xFFFF00FF) {
                this.pixels[i] = 0x0;
            }
        }


        image = new BufferedImage(width, height, 2);

        image.setRGB(0, 0, width, height, this.pixels, 0, width);
    }

    private void loadImage() {
        try {

            System.out.print("Loading image " + path + "...");
            image = ImageIO.read(Sprite.class.getResourceAsStream(path));
            System.out.println(" Successful");

            width = image.getWidth();
            height = image.getHeight();

            pixels = new int[width * height];

            image.getRGB(0, 0, width, height, pixels, 0, width);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(" Failed");
        }
    }

    public BufferedImage getSprite() {
        return image;
    }
}
