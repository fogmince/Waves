package rasmus.graphics.ui;

import java.awt.*;
import java.util.*;
import java.util.List;

public class UIHandler {

    private List<UIComponent> components = new ArrayList<>();

    public UIHandler() {

    }

    public void update() {
        for(UIComponent component : components) {
            component.update();
        }
    }

    public void render(Graphics g) {
        for(UIComponent component : components) {
            component.render(g);
        }
    }

    public void addComponent(UIComponent component) {
        components.add(component);
    }

    public UIComponent getComponent(int i) {
        return components.get(i);
    }

    public int getAmountOfComponents() {
        return components.size();
    }

    public void removeComponent(int i) {
        components.remove(i);
    }
}
