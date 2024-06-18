package main;



import javax.swing.*;
import java.awt.Color;


public class MapSelect extends JFrame {

    public MapSelect() {

        this.setTitle("SELECT MAP SIZE");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.blue.darker().darker().darker().darker());


        JButton smallB = new JButton();
        smallB.setBounds(150, 50, 100, 50);
        smallB.setIcon(new ImageIcon(getClass().getResource("/buttons/small.png")));
        smallB.setBorderPainted(false);
        smallB.setContentAreaFilled(false);
        smallB.addActionListener(e -> {
            dispose();
            new GameFrame(12);
        });

        JButton mediumB = new JButton();
        mediumB.setBounds(150, 100, 100, 50);
        mediumB.setIcon(new ImageIcon(getClass().getResource("/buttons/medium.png")));
        mediumB.setBorderPainted(false);
        mediumB.setContentAreaFilled(false);
        mediumB.addActionListener(e -> {
            dispose();
            new GameFrame(16);
        });

        JButton largeB = new JButton();
        largeB.setBounds(150, 150, 100, 50);
        largeB.setIcon(new ImageIcon(getClass().getResource("/buttons/large.png")));
        largeB.setBorderPainted(false);
        largeB.setContentAreaFilled(false);
        largeB.addActionListener(e -> {
            dispose();
            new GameFrame(20);
        });

        JButton largerB = new JButton();
        largerB.setBounds(150, 200, 100, 50);
        largerB.setIcon(new ImageIcon(getClass().getResource("/buttons/larger.png")));
        largerB.setBorderPainted(false);
        largerB.setContentAreaFilled(false);
        largerB.addActionListener(e -> {
            dispose();
            new GameFrame(24);
        });

        JButton wideB = new JButton();
        wideB.setBounds(150, 250, 100, 50);
        wideB.setIcon(new ImageIcon(getClass().getResource("/buttons/wide.png")));
        wideB.setBorderPainted(false);
        wideB.setContentAreaFilled(false);
        wideB.addActionListener(e -> {
            dispose();
            new GameFrame(40);
        });

        panel.add(smallB);
        panel.add(mediumB);
        panel.add(largeB);
        panel.add(largerB);
        panel.add(wideB);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
