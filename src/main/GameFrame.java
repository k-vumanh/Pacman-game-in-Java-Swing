package main;


import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(int mapSize) {
        setTitle("MacPan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel gamePanel = new GamePanel(mapSize);

        switch (mapSize) {
            case 12:
                gamePanel.screenWidth = 12 * gamePanel.tileSize;
                break;
            case 16:
                gamePanel.screenWidth = 16 * gamePanel.tileSize;
                break;
            case 20:
                gamePanel.screenWidth = 20 * gamePanel.tileSize;
                break;
            case 24:
                gamePanel.screenWidth = 24 * gamePanel.tileSize;
                break;
            case 40:
                gamePanel.screenWidth = 40 * gamePanel.tileSize;
                break;
        }
        int height = gamePanel.screenHeight;
        int width = gamePanel.screenWidth;

        setSize(width, height);
        add(gamePanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
