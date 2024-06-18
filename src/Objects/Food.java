package Objects;

import main.GamePanel;
import main.Hitbox;

import javax.swing.*;

public class Food extends Thread {
    GamePanel gp;
    public int x, y;
    public JLabel foodLabel;
    public Hitbox hitbox;
    public int foodSize = 6;
    private boolean active;

    public Food(GamePanel gp, int col, int row) {
        this.gp = gp;

        int offsetX = (gp.tileSize - foodSize) / 2;
        int offsetY = (gp.tileSize - foodSize) / 2;

        this.x = col * gp.tileSize + offsetX;
        this.y = row * gp.tileSize + offsetY;

        foodLabel = new JLabel();
        foodLabel.setBounds(this.x, this.y, foodSize, foodSize);
        foodLabel.setIcon(new ImageIcon(getClass().getResource("/food/food.png")));


        gp.add(foodLabel);

        hitbox = new Hitbox(this.x, this.y, foodSize, foodSize);
        active = true;
    }

    @Override
    public void run() {
        while (active) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void draw() {
        int offsetX = (gp.tileSize - foodSize) / 2;
        int offsetY = (gp.tileSize - foodSize) / 2;

        foodLabel.setBounds(x - offsetX, y - offsetY, gp.tileSize, gp.tileSize);
    }

    public void deactivate() {
        active = false;
        gp.remove(foodLabel);
        gp.revalidate();
        gp.repaint();
    }
}
