package rasmus.graphics.background;


import rasmus.*;

import java.awt.*;
import java.util.*;

public class Background {

    private final Random random = new Random();

    private Color color1, color2;
    //COLOR CORDS
    private double startX, startY, endX, endY;
    //NEW COLOR CORDS
    private double startXIn, startYIn, endXIn, endYIn;

    private boolean start = true;

    //COLORS
    private double red1, green1, blue1;
    private double red2, green2, blue2;

    //NEW COLOR
    private double red1In, green1In, blue1In;
    private double red2In, green2In, blue2In;

    private boolean changingColor = false;
    private boolean changingColorCords = false;

    public Background() {
        color1 = new Color(0x297791);
        color2 = new Color(0x6FC2DE);
        startX = 0;
        startY = 0;
        endX = Game.WIDTH;
        endY = Game.HEIGHT;

        red1 = color1.getRed();
        green1 = color1.getGreen();
        blue1 = color1.getBlue();

        red2 = color2.getRed();
        green2 = color2.getGreen();
        blue2 = color2.getBlue();
    }

    public void update() {
        //STARTING ANIMATION
        if(start) {
            startX += 2;
            endX -= 2;
            startY += 2;
            endY -= 2;

            if (startX >= Game.WIDTH) startX = Game.WIDTH;
            if (endX <= 0) {
                endX = 0;
                start = false;
            }

            if(startY >= Game.HEIGHT) startY = Game.HEIGHT;
            if(endY <= 0) endY = 0;
        }

        //RANDOM CHANGING BACKGROUND
        if(!start) {
            if(random.nextInt(500) == 0 && !changingColor) {
                red1In = random.nextDouble() + random.nextInt(2) - 1;
                green1In = random.nextDouble() + random.nextInt(2) - 1;
                blue1In = random.nextDouble() + random.nextInt(2) - 1;

                red2In = random.nextDouble() + random.nextInt(2) - 1;
                green2In = random.nextDouble() + random.nextInt(2) - 1;
                blue2In = random.nextDouble() + random.nextInt(2) - 1;

                changingColor = true;
            }

            if(random.nextInt(120) == 0 && !changingColorCords) {
                changingColorCords = true;

                startXIn = random.nextDouble() + random.nextInt(5) - 2.5;
                startYIn = random.nextDouble() + random.nextInt(5) - 2.5;
                endXIn = random.nextDouble() + random.nextInt(5) - 2.5;
                endYIn = random.nextDouble() + random.nextInt(5) - 2.5;;
            }

            if(changingColor) changeColor();
            if(changingColorCords) changeColorCords();

            checkBounds();

            color1 = new Color((int) red1, (int) green1, (int) blue1);
            color2 = new Color((int) red2, (int) green2, (int) blue2);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint((int) startX, (int) startY, color1, (int) endX, (int) endY, color2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
    }

    private void changeColorCords() {
        startY += startXIn;
        startY += startYIn;
        endX += endXIn;
        endY += endYIn;

        if(random.nextInt(300) == 0) changingColorCords = false;
    }

    private void changeColor() {
        red1 += red1In;
        green1 += green1In;
        blue1 += blue1In;

        red2 += red2In;
        green2 += green2In;
        blue2 += blue2In;

        if(random.nextInt(120) == 0) changingColor = false;
    }

    private void checkBounds() {
        //COLOR BOUNDS
        if(red1 >= 255) red1 = 255;
        if(green1 >= 255) green1 = 255;
        if(blue1 >= 255) blue1 = 255;

        if(red1 <= 0) red1 = 0;
        if(green1 <= 0) green1 = 0;
        if(blue1 <= 0) blue1 = 0;

        if(red2 >= 255) red2 = 255;
        if(green2 >= 255) green2 = 255;
        if(blue2 >= 255) blue2 = 255;

        if(red2 <= 0) red2 = 0;
        if(green2 <= 0) green2 = 0;
        if(blue2 <= 0) blue2 = 0;

        //COLOR COORDINATES BOUNDS
        if (startX >= Game.WIDTH) startX = Game.WIDTH;
        if (endX <= 0) endX = 0;

        if(startY >= Game.HEIGHT) startY = Game.HEIGHT;
        if(endY <= 0) endY = 0;
    }
}
