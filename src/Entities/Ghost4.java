package Entities;

import main.GamePanel;

import javax.swing.*;
import java.util.Random;

public class Ghost4 extends Entity {
    public int maxLife = 1000000;

    public Ghost4(GamePanel gp) {
        super(gp);
        setDefaultVal();
        entityLabel.setBounds(x, y, gp.tileSize, gp.tileSize);

        getGhostImage();
    }

    public void setDefaultVal() {
        x = gp.tileSize * 6 - gp.tileSize * 2;
        y = gp.tileSize * 7;
        speed = 3;
        defaultSpeed = speed;
        dir = "down";
        life = maxLife;
        isFrozen = false;
    }

    public void getGhostImage() {
        try {
            up1 = new ImageIcon(getClass().getResource("/ghost/green_ghost_up.png"));
            down1 = new ImageIcon(getClass().getResource("/ghost/green_ghost_down.png"));
            left1 = new ImageIcon(getClass().getResource("/ghost/green_ghost_left.png"));
            right1 = new ImageIcon(getClass().getResource("/ghost/green_ghost_right.png"));
            frozen = new ImageIcon(getClass().getResource("/ghost/ghost_frozen.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAction() {

        actionCounter++;

        if (actionCounter == 10) {
            Random rand = new Random();
            int i = rand.nextInt(100) + 1;

            if (i <= 25 && collisionOn == true)
                dir = "up";
            if (i > 25 && i <= 50 && collisionOn == true)
                dir = "down";
            if (i > 50 && i <= 75 && collisionOn == true)
                dir = "left";
            if (i > 75 && i <= 100 && collisionOn == true)
                dir = "right";
            actionCounter = 0;
        }
    }

    public void update() {

        setAction();

        collisionOn = false;
        gp.cHandler.checkTile(this);

        if (collisionOn == false) {
            switch (dir) {
                case "up":
                    y = y - speed;
                    break;
                case "down":
                    y = y + speed;
                    break;
                case "left":
                    x = x - speed;
                    break;
                case "right":
                    x = x + speed;
                    break;
            }
        }


        entityLabel.setBounds(x, y, gp.tileSize, gp.tileSize);


    }

    public void draw() {
        ImageIcon image = null;

        switch (dir) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }

        if (isFrozen) {
            image = frozen;
        }
        entityLabel.setIcon(image);

    }

}
