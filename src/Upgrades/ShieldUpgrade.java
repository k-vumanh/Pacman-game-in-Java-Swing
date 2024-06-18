package Upgrades;

import main.GamePanel;

import javax.swing.*;


public class ShieldUpgrade extends Upgrade{
    public ShieldUpgrade(GamePanel gp, int col, int row){
        super(gp,col,row);
        upgradeLabel.setIcon(new ImageIcon(getClass().getResource("/upgrades/shield.png")));
    }

    @Override
    public void applyEffect() {
        if (gp.player.maxLife < 4){
            gp.player.maxLife++;

        }

    }
}
