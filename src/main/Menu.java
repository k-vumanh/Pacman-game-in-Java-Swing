package main;

import HighScore.HighScoreWindow;

import javax.swing.*;
import java.awt.Color;

public class Menu extends JFrame {

    public Menu() {
        this.setTitle("MAIN MENU");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.blue.darker().darker().darker().darker());


        JButton newGameB = new JButton();
        newGameB.setBounds(150, 50, 100, 50);
        newGameB.setIcon(new ImageIcon(getClass().getResource("/buttons/newgame.png")));
        newGameB.setBorderPainted(false);
        newGameB.setContentAreaFilled(false);
        newGameB.addActionListener(e -> {
            dispose();
            new MapSelect();
        });

        JButton highScoreB = new JButton();
        highScoreB.setBounds(150, 150, 100, 50);
        highScoreB.setIcon(new ImageIcon(getClass().getResource("/buttons/highscore.png")));
        highScoreB.setBorderPainted(false);
        highScoreB.setContentAreaFilled(false);
        highScoreB.addActionListener(e -> new HighScoreWindow());

        JButton exitB = new JButton();
        exitB.setBounds(150, 250, 100, 50);
        exitB.setIcon(new ImageIcon(getClass().getResource("/buttons/exit.png")));
        exitB.setBorderPainted(false);
        exitB.setContentAreaFilled(false);
        exitB.addActionListener(e -> System.exit(0));

        panel.add(newGameB);
        panel.add(highScoreB);
        panel.add(exitB);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
