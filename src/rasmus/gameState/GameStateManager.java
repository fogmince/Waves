package rasmus.gameState;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {

    private List<GameState> gameStates = new ArrayList<>();

    private int currentState;

    public static final int MENU_STATE = 0;
    public static final int PLAY_STATE = 1;

    public GameStateManager() {
        gameStates.add(new MenuState(this));
        gameStates.add(new PlayState(this));

        currentState = MENU_STATE;
        gameStates.get(currentState).init();
    }

    public void update() {
        gameStates.get(currentState).update();
    }

    public void render(Graphics g) {
        gameStates.get(currentState).render(g);
    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(state).init();
    }
}
