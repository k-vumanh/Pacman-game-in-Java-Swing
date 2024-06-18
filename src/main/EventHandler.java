package main;

import Entities.Entity;
import Objects.Food;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class EventHandler extends Thread {
    GamePanel gp;
    List<Food> foods;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        foods = new ArrayList<>();

    }

    @Override
    public void run() {
        while (true) {
            synchronized (gp) {
                checkEvent();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void initializeFoods() {
        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {
                if (!gp.tileM.isWall(col, row)) {
                    addFood(col, row);
                }
            }
        }

    }

    public void addFood(int col, int row) {
        Food food = new Food(gp, col, row);
        synchronized (foods) {
            foods.add(food);
        }
        food.start();
    }

    public void draw() {
        synchronized (foods) {
            for (Food food : foods) {
                if (food != null) {
                    food.draw();
                }
            }
        }
    }


    public void checkEvent() {
        boolean playerHitGhost = false;

        for (int i = 0; i < gp.ghosts.length; i++) {
            if (gp.ghosts[i] != null && hitboxWithGhost(gp.ghosts[i])) {
                playerHitGhost = true;
                break;
            }
        }

        if (playerHitGhost) {

            gp.player.maxLife--;
            gp.player.setDefaultVal();

            for (int i = 0; i < gp.ghosts.length; i++) {
                if (gp.ghosts[i] != null) {
                    gp.ghosts[i].setDefaultVal();
                }
            }

            gp.heart.draw();

            if (gp.player.life <= 0) {
                gp.gameStatus = gp.pause;
            }
        }

        List<Food> foodsToRemove = new ArrayList<>();
        synchronized (gp) {
            for (Food food : foods) {
                if (hitboxWithFood(food.hitbox)) {
                    foodsToRemove.add(food);
                    food.deactivate();
                    gp.score.incrementScore(10);
                }
            }
            foods.removeAll(foodsToRemove);
        }

        for (Food food : foodsToRemove) {
            food.deactivate();
        }

        if (foods.isEmpty()) {
            gameReset();
        }
    }

    public boolean hitboxWithGhost(Entity ghost) {
        boolean hit = false;

        Hitbox playerHitbox = new Hitbox(
                gp.player.x + gp.player.solidArea.x,
                gp.player.y + gp.player.solidArea.y,
                gp.player.solidArea.width,
                gp.player.solidArea.height
        );

        Hitbox ghostHitbox = new Hitbox(
                ghost.x + ghost.solidArea.x,
                ghost.y + ghost.solidArea.y,
                ghost.solidArea.width,
                ghost.solidArea.height
        );

        if (playerHitbox.intersects(ghostHitbox)) {
            hit = true;
        }
        return hit;
    }

    public boolean hitboxWithFood(Hitbox foodHitbox) {
        boolean hit = false;

        Hitbox playerHitbox = new Hitbox(
                gp.player.x + gp.player.solidArea.x,
                gp.player.y + gp.player.solidArea.y,
                gp.player.solidArea.width,
                gp.player.solidArea.height
        );

        if (playerHitbox.intersects(foodHitbox))
            hit = true;

        return hit;
    }

    public void gameReset() {
        gp.player.setDefaultVal();

        for (Entity ghost : gp.ghosts) {
            if (ghost != null) {
                ghost.setDefaultVal();
            }
        }

        initializeFoods();
    }

}

