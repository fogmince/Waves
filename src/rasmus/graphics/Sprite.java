package rasmus.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    private static final String itemPath = "/textures/items/";
    private static final String uiPath = "/textures/ui/";
    private static final String entityPath = "/textures/entity/";
    private static final String particlePath = "/textures/entity/particle/";

    //UI
    public static final Sprite buttonPlay = new Sprite(uiPath + "button_Play.png");
    public static final Sprite buttonQuit = new Sprite(uiPath + "button_Quit.png");
    public static final Sprite buttonMenu = new Sprite(uiPath + "button_Menu.png");

    //Entity
    public static final Sprite player = new Sprite(entityPath + "player.png");

    //Particle
    public static final Sprite test_particle = new Sprite(particlePath + "star.png");

    //Items
    public static final Sprite item_heart = new Sprite(itemPath + "heart.png");

    private String path;
    private int width, height;
    private int[] pixels;

    private BufferedImage image;

    public Sprite(String path) {
        this.path = path;
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
