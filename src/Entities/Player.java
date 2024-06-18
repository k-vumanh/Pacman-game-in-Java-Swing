package Entities;

import main.GamePanel;
import main.KeyHandler;

import javax.swing.*;


public class Player extends Entity {

    KeyHandler keyH;
    public int maxLife = 3;
    public int scoreMultiplier = 1;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        setDefaultVal();
        entityLabel.setBounds(x, y, gp.tileSize, gp.tileSize);
        gp.add(entityLabel);
        getPlayerimage();
    }

    public void setDefaultVal() {
        x = gp.tileSize;
        y = gp.tileSize;
        speed = 3;
        defaultSpeed = speed;
        dir = "right";
        scoreMultiplier = 1;

        life = maxLife;
    }

    public void getPlayerimage() {
        try {
            up1 = new ImageIcon(getClass().getResource("/pacman/pac_up1.png"));
            up2 = new ImageIcon(getClass().getResource("/pacman/pac_up2.png"));
            up3 = new ImageIcon(getClass().getResource("/pacman/pac_up3.png"));

            down1 = new ImageIcon(getClass().getResource("/pacman/pac_down1.png"));
            down2 = new ImageIcon(getClass().getResource("/pacman/pac_down2.png"));
            down3 = new ImageIcon(getClass().getResource("/pacman/pac_down3.png"));

            left1 = new ImageIcon(getClass().getResource("/pacman/pac_left1.png"));
            left2 = new ImageIcon(getClass().getResource("/pacman/pac_left2.png"));
            left3 = new ImageIcon(getClass().getResource("/pacman/pac_left3.png"));

            right1 = new ImageIcon(getClass().getResource("/pacman/pac_right1.png"));
            right2 = new ImageIcon(getClass().getResource("/pacman/pac_right2.png"));
            right3 = new ImageIcon(getClass().getResource("/pacman/pac_right3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAction() {
    }

    @Override
    public void update() {
        if (keyH.upPressed == true) {
            dir = "up";
        }
        if (keyH.downPressed == true) {
            dir = "down";
        }
        if (keyH.leftPressed == true) {
            dir = "left";
        }
        if (keyH.rightPressed == true) {
            dir = "right";
        }

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

        spriteCounter++;
        if (spriteCounter > 3) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else if (spriteNum == 3) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        entityLabel.setBounds(x, y, gp.tileSize, gp.tileSize);

    }

    public void draw() {
        ImageIcon image = null;

        switch (dir) {
            case "up":
                if (spriteNum == 1) image = up1;
                if (spriteNum == 2) image = up2;
                if (spriteNum == 3) image = up3;
                break;
            case "down":
                if (spriteNum == 1) image = down1;
                if (spriteNum == 2) image = down2;
                if (spriteNum == 3) image = down3;
                break;
            case "left":
                if (spriteNum == 1) image = left1;
                if (spriteNum == 2) image = left2;
                if (spriteNum == 3) image = left3;
                break;
            case "right":
                if (spriteNum == 1) image = right1;
                if (spriteNum == 2) image = right2;
                if (spriteNum == 3) image = right3;
                break;
        }

        entityLabel.setIcon(image);


    }

}
