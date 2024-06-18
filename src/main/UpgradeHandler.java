package main;

import Upgrades.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpgradeHandler extends Thread {

    GamePanel gp;
    List<Upgrade> upgrades;

    public UpgradeHandler(GamePanel gp) {
        this.gp = gp;
        upgrades = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spawnUpgrades();
            checkUpgrades();
        }
    }

    public void spawnUpgrades() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 25) {
            int ghostIndex = rand.nextInt(gp.ghosts.length);
            if (gp.ghosts[ghostIndex] != null) {
                int col = gp.ghosts[ghostIndex].x / gp.tileSize;
                int row = gp.ghosts[ghostIndex].y / gp.tileSize;
                Upgrade upgrade = null;
                int upgradeType = rand.nextInt(5);
                switch (upgradeType) {
                    case 0:
                        upgrade = new SpeedUpgrade(gp, col, row);
                        break;
                    case 1:
                        upgrade = new ShieldUpgrade(gp, col, row);
                        break;
                    case 2:
                        upgrade = new MultiplierUpgrade(gp, col, row);
                        break;
                    case 3:
                        upgrade = new BonusPointsUpgrade(gp, col, row);
                        break;
                    case 4:
                        upgrade = new FreezeUpgrade(gp, col, row);
                        break;
                }
                if (upgrade != null) {
                    upgrades.add(upgrade);
                    gp.add(upgrade.upgradeLabel);
                    upgrade.start();
                }
            }
        }
    }


    public void checkUpgrades() {
        List<Upgrade> upgradesToRemove = new ArrayList<>();

        for (Upgrade upgrade : upgrades) {
            if (hitboxWithUpgrade(upgrade.hitbox)) {
                upgradesToRemove.add(upgrade);
                upgrade.applyEffect();
                upgrade.deactivate();
            }
        }
        upgrades.removeAll(upgradesToRemove);
    }

    public void draw() {
        for (Upgrade upgrade : upgrades) {
            if (upgrade != null) {
                upgrade.draw();
            }
        }
    }

    public boolean hitboxWithUpgrade(Hitbox upgradeHitbox) {
        boolean hit = false;

        Hitbox playerHitbox = new Hitbox(
                gp.player.x + gp.player.solidArea.x,
                gp.player.y + gp.player.solidArea.y,
                gp.player.solidArea.width,
                gp.player.solidArea.height
        );

        if (playerHitbox.intersects(upgradeHitbox)) {
            hit = true;
        }

        return hit;
    }
}
