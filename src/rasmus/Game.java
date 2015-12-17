package rasmus;

import rasmus.gameState.GameStateManager;
import rasmus.input.Keyboard;
import rasmus.input.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 960, HEIGHT = 640;
    public static final String TITLE = "Waves";

    private JFrame frame;
    private boolean running = false;
    private Thread thread;

    private GameStateManager gsm;

    public Game() {
        gsm = new GameStateManager();

        addKeyListener(new Keyboard());
        addMouseListener(new Mouse());
        addMouseMotionListener(new Mouse());
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {

        while(running) {
            long lastTime = System.nanoTime();
            long timer = System.currentTimeMillis();
            final double ns = 1000000000.0 / 60.0;
            double delta = 0;
            int frames = 0;
            int updates = 0;

            requestFocus();

            while(running) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;

                while(delta >= 1) {
                    update();
                    updates++;
                    delta--;
                }

                render();
                frames++;

                if(System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("Updates: " + updates + ", FPS: " + frames);
                    frame.setTitle(TITLE + "  |  Updates: " + updates + ", FPS:" + frames);
                    updates = 0;
                    frames = 0;
                }
            }
        }
    }

    private void update() {
        Keyboard.update();
        gsm.update();
    }

    private void render() {

        BufferStrategy bs = getBufferStrategy();

        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        clearScreen(g);

        gsm.render(g);

        g.dispose();
        bs.show();
    }

    private void clearScreen(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame = new JFrame(TITLE);
        game.frame.setResizable(false);
        game.frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        game.frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        game.frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
