package Objects;

import main.GamePanel;

import javax.swing.*;

public abstract class GameObject {
    GamePanel gp;
    public ImageIcon image1, image2, image3 , image4;
    public int x, y;
    public JLabel objLabel;

    public GameObject(GamePanel gp){
        this.gp = gp;
        objLabel = new JLabel();
        gp.add(objLabel);
    }

    public abstract void draw();



}
