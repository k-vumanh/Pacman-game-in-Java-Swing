package Upgrades;

import Entities.Entity;
import main.GamePanel;

import javax.swing.*;

public class FreezeUpgrade extends Upgrade {
    public FreezeUpgrade(GamePanel gp, int col, int row) {
        super(gp, col, row);
        upgradeLabel.setIcon(new ImageIcon(getClass().getResource("/upgrades/freeze.png")));
    }

    @Override
    public void applyEffect() {

        new Thread(() -> {
            synchronized (gp) {
                for (Entity ghost : gp.ghosts) {
                    if (ghost != null){
                        ghost.speed = 0;
                        ghost.isFrozen = true;
                    }
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (gp) {
                for (Entity ghost : gp.ghosts) {
                    if (ghost != null){
                        ghost.speed = ghost.defaultSpeed;
                        ghost.isFrozen = false;
                    }
                }
            }
        }).start();


    }
}
