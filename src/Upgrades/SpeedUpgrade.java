package Upgrades;

import main.GamePanel;

import javax.swing.*;

public class SpeedUpgrade extends Upgrade {

    public SpeedUpgrade(GamePanel gp, int col, int row) {
        super(gp, col, row);
        upgradeLabel.setIcon(new ImageIcon(getClass().getResource("/upgrades/speedboost.png")));
    }

    @Override
    public void applyEffect() {
        new Thread(() -> {
            synchronized (gp) {
                gp.player.speed *= 1.5;
            }
            try{
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (gp){
                gp.player.speed = gp.player.defaultSpeed;
            }

        }).start();
    }
}
