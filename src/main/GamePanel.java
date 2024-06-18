package main;

import Entities.*;
import HighScore.HighScoreHandler;
import Objects.GameTimer;
import Objects.Heart;
import Objects.Score;
import map.*;

import javax.swing.*;
import java.awt.Color;


public class GamePanel extends JPanel {

    public final int tileSize = 48;
    public int maxScreenCol = 12;
    public final int maxScreenRow = 16;
    public int screenWidth = tileSize * maxScreenCol;
    public int screenHeight = tileSize * maxScreenRow + 200;

    TileManager tileM;
    KeyHandler keyH = new KeyHandler(this);

    public CollisionHandler cHandler = new CollisionHandler(this);
    public EventHandler eHandler = new EventHandler(this);
    public UpgradeHandler uHandler = new UpgradeHandler(this);
    public GameLoop gLoop;

    public int gameStatus;
    public final int running = 1;
    public final int pause = 2;
    public final int gameOver = 3;

    public Player player = new Player(this, keyH);
    public Entity ghosts[] = new Entity[10];

    public Heart heart = new Heart(this);
    public GameTimer gTimer;
    public Score score;


    public GamePanel(int mapSize) {

        this.setBackground(Color.black);
        this.setLayout(null);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        setTileManager(mapSize);

        addEntities();
        heart.getHeartImage();
        player.getPlayerimage();
        gameSetup();

        score = new Score(this);
        gTimer = new GameTimer(this);
        gTimer.start();

        cHandler = new CollisionHandler(this);
        eHandler = new EventHandler(this);
        uHandler = new UpgradeHandler(this);
        gLoop = new GameLoop(this);

        gLoop.start();
        eHandler.start();

        uHandler.start();

    }

    private void setTileManager(int mapSize) {
        switch (mapSize) {
            case 12:
                maxScreenCol = 12;
                break;
            case 16:
                maxScreenCol = 16;
                break;
            case 20:
                maxScreenCol = 20;
                break;
            case 24:
                maxScreenCol = 24;
                break;
            case 40:
                maxScreenCol = 40;
                break;
        }
        tileM = new TileManager(this, mapSize);
    }

    public void addEntities() {
        ghosts[0] = new Ghost1(this);
        ghosts[1] = new Ghost2(this);
        ghosts[2] = new Ghost3(this);
        ghosts[3] = new Ghost4(this);
    }

    public void gameSetup() {
        gameStatus = running;
    }


    public synchronized void update() {

        if (gameStatus == running) {
            player.update();

            for (Entity ghost : ghosts) {
                if (ghost != null) {
                    ghost.update();
                }
            }
            eHandler.checkEvent();
            uHandler.checkUpgrades();
        }

        if (gameStatus == pause) {

        }

        if (player.maxLife <= 0) {
            endGame();
        }

    }

    public void endGame() {
        gameStatus = gameOver;
        String playerName = JOptionPane.showInputDialog(this, "GAME OVER! \n ENTER YOUR NAME:");

        if (playerName != null && !playerName.isEmpty()) {
            HighScoreHandler.addScore(playerName, score.getScore());
            System.exit(0);
        }

        new Menu();
    }

    public synchronized void draw() {
        tileM.draw();
        player.draw();

        for (Entity ghost : ghosts) {
            if (ghost != null) {
                ghost.draw();
            }
        }

        heart.draw();
        eHandler.draw();
        uHandler.draw();
        score.draw();
        gTimer.draw();
    }
}
