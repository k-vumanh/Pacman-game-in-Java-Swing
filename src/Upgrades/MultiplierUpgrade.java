package Upgrades;

import main.GamePanel;

import javax.swing.*;

public class MultiplierUpgrade extends Upgrade {

    public MultiplierUpgrade(GamePanel gp, int col, int row) {
        super(gp, col, row);
        upgradeLabel.setIcon(new ImageIcon(getClass().getResource("/upgrades/multiplier.png")));
    }

    @Override
    public void applyEffect() {
        new Thread(() -> {
            synchronized (gp) {
                gp.player.scoreMultiplier = 2;
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (gp) {
                gp.player.scoreMultiplier = 1;
            }
        }).start();
    }
}
