package Objects;

import main.GamePanel;

import javax.swing.*;
import java.awt.Color;

public class Score {

    GamePanel gp;
    public JLabel scoreLabel;
    private int score;

    public Score(GamePanel gp) {
        this.gp = gp;
        score = 0;
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setBounds(400, 890, 100, 30);
        scoreLabel.setForeground(Color.white);
        gp.add(scoreLabel);
    }

    public void incrementScore(int amount) {
        if (gp.player.scoreMultiplier >= 2){
           amount = 20;
            score += amount;
            draw();
        }else {
            score += amount;

        }

    }

    public int getScore() {
        return score;
    }

    public void draw() {
        scoreLabel.setText("Score: " + score);
    }
}
