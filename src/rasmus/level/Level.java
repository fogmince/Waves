package rasmus.level;

import rasmus.entity.*;
import rasmus.entity.item.*;
import rasmus.entity.particle.*;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Level {

    private List<Entity> entities = new ArrayList<>();
    private List<Particle> particles = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public Level() {

    }

    public void update() {
        remove();

        for(int i = 0; i < particles.size(); i++) {
            particles.get(i).update();
        }

        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }

        for(int i = 0; i < items.size(); i++) {
            items.get(i).update();
        }
    }

    private void remove() {
        for(int i = 0; i < entities.size(); i++) {
            if(entities.get(i).isRemoved()) entities.remove(i);
        }

        for(int i = 0; i < particles.size(); i++) {
            if(particles.get(i).isRemoved()) particles.remove(i);
        }

        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).isRemoved()) items.remove(i);
        }

    }

    public void render(Graphics g) {
        for(int i = 0; i < particles.size(); i++) {
            particles.get(i).render(g);
        }

        for(int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g);
        }

        for(int i = 0; i < items.size(); i++) {
            items.get(i).render(g);
        }
    }

    public void add(Entity e) {
        if(e instanceof Particle) {
            particles.add((Particle) e);
        } else if(e instanceof Item) {
            items.add((Item) e);
        } else {
            entities.add(e);
        }

        e.setLevel(this);
    }

    public Entity getNearestEntity(Entity e, double range) {
        Entity nearest = null;
        double lastDistance = 10000;

        double x = e.getX();
        double y = e.getY();

        for(int i = 0; i < entities.size(); i++) {
            if(entities.get(i) instanceof Player) continue;
            Entity entity = entities.get(i);

            double ex = entity.getX();
            double ey = entity.getY();

            double dx = Math.abs(x - ex);
            double dy = Math.abs(y - ey);

            double distance = Math.sqrt((dx * dx + (dy * dy)));

            if(distance < lastDistance && distance <= range) {
                lastDistance = distance;
                nearest = entities.get(i);
            }
        }

        return nearest;
    }

    public boolean entityCollision(Entity e1, Entity e2) {

        double e1X = e1.getX();
        double e1Y = e1.getY();
        double e2X = e2.getX();
        double e2Y = e2.getY();

        double e1W = e1.getWidth();
        double e1H = e1.getHeight();
        double e2W = e2.getWidth();
        double e2H = e2.getHeight();

        if(e2X + e2W >= e1X && e2Y + e2H >= e1Y && e2X <= e1X + e1W && e2Y <= e1Y + e1H) {
            return true;
        }

        return false;
    }

    public Player getPlayer() {
        return (Player) entities.get(0);
    }

}
