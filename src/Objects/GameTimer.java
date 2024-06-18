package Objects;

import main.GamePanel;

import javax.swing.*;
import java.awt.Color;


public class GameTimer extends Thread {

    GamePanel gp;
    public JLabel timerLabel;
    int timeInSec;
    boolean running;

    public GameTimer(GamePanel gp) {
        this.gp = gp;
        timeInSec = 0;
        running = true;
        timerLabel = new JLabel("Time: 0");
        timerLabel.setBounds(200, 890, 100, 30);
        timerLabel.setForeground(Color.white);
        gp.add(timerLabel);
    }

    @Override
    public void run(){

        while (running == true){
            try {
                Thread.sleep(1000);
                incrementTime();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void incrementTime(){
        timeInSec++;
        draw();
    }

    public void draw(){
        timerLabel.setText("Time:" + timeInSec);
    }
}
