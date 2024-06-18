package HighScore;

import java.io.*;

public class HighScoreHandler implements Serializable {
    private static final int maxScores = 50;
    private static final String highScoresFile = "highscoresfile.dat";
    private static ScoreEntry[] highScores = new ScoreEntry[maxScores];


    static {
        loadHighScores();

    }

    public static void addScore(String name, int score) {
        ScoreEntry newScore = new ScoreEntry(name, score);
        for (int i = 0; i < highScores.length; i++) {
            if (highScores[i] == null || highScores[i].getScore() < score) {
                for (int j = highScores.length - 1; j > i; j--) {
                    highScores[j] = highScores[j - 1];
                }
                highScores[i] = newScore;
                break;
            }
        }
        saveHighScores();
    }

    public static ScoreEntry[] getHighScores() {
        return highScores;
    }

    public static void saveHighScores() {
        try {
            FileOutputStream fos = new FileOutputStream(highScoresFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadHighScores() {
        try {
            FileInputStream fis = new FileInputStream(highScoresFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            highScores = (ScoreEntry[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            highScores = new ScoreEntry[maxScores];
        }
    }



    public static class ScoreEntry implements Serializable {
        private String name;
        private int score;

        public ScoreEntry(String name, int score) {
            this.name = name;
            this.score = score;
        }


        public int getScore(){
            return score;
        }

        @Override
        public String toString(){
            return name + ": " + score;
        }
    }
}


