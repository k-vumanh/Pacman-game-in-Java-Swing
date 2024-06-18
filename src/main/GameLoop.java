package main;

public class GameLoop extends Thread {
    GamePanel gp;
    int FPS = 60;
    public boolean running;

    public GameLoop(GamePanel gp) {
        this.gp = gp;
        this.running = true;
    }

    @Override
    public void run() {
        long drawInterval = 1000000000 / FPS;
        long nextDrawTime = System.nanoTime() + drawInterval;

        while (true) {
            synchronized (gp) {
                gp.update();
                gp.draw();

            }
            try {
                long remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep(remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
