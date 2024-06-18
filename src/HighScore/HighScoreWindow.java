package HighScore;

import javax.swing.*;
import java.util.Arrays;

public class HighScoreWindow extends JFrame {
    private JList<String> scoreList;
    private DefaultListModel<String> listModel;
    private JScrollPane scrollPane;

    public HighScoreWindow() {
        this.setTitle("HIGH SCORES");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        listModel = new DefaultListModel<>();
        scoreList = new JList<>(listModel);
        scrollPane = new JScrollPane(scoreList);

        loadHighScores();

        add(scrollPane);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void loadHighScores() {
        HighScoreHandler.ScoreEntry[] highscores = HighScoreHandler.getHighScores();

        Arrays.stream(highscores)
                .filter(entry -> entry != null)
                .forEach(entry -> listModel.addElement(entry.toString()));
    }
}
