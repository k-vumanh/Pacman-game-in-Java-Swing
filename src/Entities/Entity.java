package Entities;

import main.GamePanel;
import main.Hitbox;
import map.SolidArea;

import javax.swing.*;


public abstract class Entity {

    GamePanel gp;
    public int x, y;
    public int speed;
    public int defaultSpeed;
    public boolean isFrozen;

    public ImageIcon up1, up2, up3, down1, down2, down3,
            left1, left2, left3, right1, right2, right3,
            frozen;

    public String dir;

    public int life;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Hitbox solidAreaHitbox;
    public SolidArea solidArea = new SolidArea(0, 0, 40, 40);
    public boolean collisionOn = false;

    public int actionCounter = 0;

    public JLabel entityLabel;

    public Entity(GamePanel gp) {
        this.gp = gp;
        entityLabel = new JLabel();
        gp.add(entityLabel);
        solidAreaHitbox = new Hitbox(0, 0, 40, 40);
    }

    public void setDefaultVal() {

    }

    public abstract void setAction();

    public void update() {
        setAction();
        collisionOn = false;
        gp.cHandler.checkTile(this);
        draw();
        updateSolidArea();
    }

    public abstract void draw();

    public void updateSolidArea() {
        solidArea.x = x;
        solidArea.y = y;
    }

}

