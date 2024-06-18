package Upgrades;

import main.GamePanel;
import main.Hitbox;

import javax.swing.*;

public abstract class Upgrade extends Thread {
    GamePanel gp;
    public int x, y;
    public JLabel upgradeLabel;
    public Hitbox hitbox;
    int upgradeSize = 16;
    public boolean active;

    public Upgrade(GamePanel gp, int col, int row) {
        this.gp = gp;

        int offsetX = (gp.tileSize - upgradeSize) / 2;
        int offsetY = (gp.tileSize - upgradeSize) / 2;

        this.x = col * gp.tileSize + offsetX;
        this.y = row * gp.tileSize + offsetY;

        upgradeLabel = new JLabel();
        upgradeLabel.setBounds(this.x, this.y, upgradeSize, upgradeSize);

        gp.add(upgradeLabel);

        hitbox = new Hitbox(this.x, this.y, upgradeSize, upgradeSize);
        active = true;
    }

    @Override
    public void run(){
        while (active){
            try {
                Thread.sleep(50);
            }catch (InterruptedException e ){
                e.printStackTrace();
            }
        }
    }

    public abstract void applyEffect();

    public void draw() {
        int offsetX = (gp.tileSize - upgradeSize) /2;
        int offsetY = (gp.tileSize - upgradeSize) /2;
        upgradeLabel.setBounds(x - offsetX, y - offsetY, gp.tileSize, gp.tileSize);
    }

    public void deactivate() {
        active = false;
        gp.remove(upgradeLabel);
        gp.revalidate();
        gp.repaint();

    }

}
