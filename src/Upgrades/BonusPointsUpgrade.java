package Upgrades;

import main.GamePanel;

import javax.swing.*;

public class BonusPointsUpgrade extends Upgrade {
    public BonusPointsUpgrade(GamePanel gp, int col, int row) {
        super(gp, col, row);
        upgradeLabel.setIcon(new ImageIcon(getClass().getResource("/upgrades/strawberry.png")));
    }

    @Override
    public void applyEffect() {
        gp.score.incrementScore(300);
    }
}
