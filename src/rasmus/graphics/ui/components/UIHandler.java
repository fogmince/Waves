package rasmus.graphics.ui.components;

import java.awt.*;
import java.util.*;
import java.util.List;

public class UIHandler {

    private List<UIComponent> components = new ArrayList<UIComponent>();

    public UIHandler() {

    }

    public void update() {
        for(int i = 0; i < components.size(); i++) {
            components.get(i).update();
            if(components.get(i).isRemoved()) components.remove(i);
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
