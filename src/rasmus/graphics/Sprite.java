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
    public static final Sprite item_star = new Sprite(itemPath + "star.png");

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

    public static Sprite rotate(Sprite sprite, double angle) {
        return new Sprite(rotate(sprite.pixels, sprite.width, sprite.height, Math.toRadians(angle)), sprite.width, sprite.height);
    }

    private static int[] rotate(int[] pixels, int width, int height, double angle) {
        int[] result = new int[width * height];

        double nx_x = rot_x(-angle, 1.0, 0.0);
        double nx_y = rot_y(-angle, 1.0, 0.0);
        double ny_x = rot_x(-angle, 0.0, 1.0);
        double ny_y = rot_y(-angle, 0.0, 1.0);

        double x0 = rot_x(-angle, -width / 2.0, -height / 2.0) + width / 2.0;
        double y0 = rot_y(-angle, -width / 2.0, -height / 2.0) + height / 2.0;

        for(int y = 0; y < height; y++) {
            double x1 = x0;
            double y1 = y0;
            for(int x = 0; x < width; x++) {
                int xx = (int) x1;
                int yy = (int) y1;
                int col = 0;
                if(xx < 0 || xx >= width || yy < 0 || yy >= height) col = 0xFFFF00FF;
                else col = pixels[xx + yy * width];
                result[x + y * width] = col;
                x1 += nx_x;
                y1 += nx_y;
            }
            x0 += ny_x;
            y0 += ny_y;
        }

        return result;
    }

    private static double rot_x(double angle, double x, double y) {
        double cos = Math.cos(angle - Math.PI / 2);
        double sin = Math.sin(angle - Math.PI / 2);

        return x * cos + y * -sin;
    }

    private static double rot_y(double angle, double x, double y) {
        double cos = Math.cos(angle - Math.PI / 2);
        double sin = Math.sin(angle - Math.PI / 2);

        return x * sin + y * -cos;
    }

    public BufferedImage getSprite() {
        return image;
    }
}
