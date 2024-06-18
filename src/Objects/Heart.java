package Objects;

import main.GamePanel;

import javax.swing.*;


public class Heart extends GameObject {

    final int lifeBarPosY = 890;
    final int lifebarPosX = 5;

    public Heart(GamePanel gp) {
        super(gp);

        objLabel.setBounds(lifebarPosX, lifeBarPosY, 36, 36);
        gp.add(objLabel);
        getHeartImage();

    }

    public void getHeartImage() {
        try {
            image1 = new ImageIcon(getClass().getResource("/HUD/1Heart.png"));
            image2 = new ImageIcon(getClass().getResource("/HUD/2Heart.png"));
            image3 = new ImageIcon(getClass().getResource("/HUD/3Heart.png"));
            image4 = new ImageIcon(getClass().getResource("/HUD/4Heart.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void draw() {
        ImageIcon image = null;
        switch (gp.player.maxLife) {
            case 4:
                image = image4;
                objLabel.setSize(144, 36);
                break;
            case 3:
                image = image3;
                objLabel.setSize(108, 36);
                break;
            case 2:
                image = image2;
                objLabel.setSize(72, 36);
                break;
            case 1:
                image = image1;
                objLabel.setSize(36, 36);
                break;

        }
        objLabel.setIcon(image);
    }

}
