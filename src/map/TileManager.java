package map;

import main.GamePanel;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public JLabel[][] tileLabels;
    int mapSize;

    public TileManager(GamePanel gp, int mapSize) {
        this.gp = gp;
        this.mapSize = mapSize;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        tileLabels = new JLabel[gp.maxScreenCol][gp.maxScreenRow];

        getMapTiles();
        loadMap();
        initTileLabels();
        draw();
    }

    public void getMapTiles() {
        try {
            tile[0] = new Tile();
            tile[0].image = new ImageIcon(getClass().getResource("/tiles/block.png"));
            tile[0].collision = true;

            tile[1] = new Tile();

            tile[2] = new Tile();
            tile[2].image = new ImageIcon(getClass().getResource("/tiles/barrier.png"));
            tile[2].collision = true;
            tile[2].topCollisionOnly = true;

            tile[3] = new Tile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {

        switch (mapSize) {
            case 12:
                try {
                    InputStream is = getClass().getResourceAsStream("/maps/map12.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    int col = 0;
                    int row = 0;

                    while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                        String line = br.readLine();

                        while (col < gp.maxScreenCol) {
                            String[] numbers = line.split(" ");

                            int num = Integer.parseInt(numbers[col]);

                            mapTileNum[col][row] = num;
                            col++;
                        }
                        if (col == gp.maxScreenCol) {
                            col = 0;
                            row++;
                        }
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 16:
                try {
                    InputStream is = getClass().getResourceAsStream("/maps/map16.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    int col = 0;
                    int row = 0;

                    while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                        String line = br.readLine();

                        while (col < gp.maxScreenCol) {
                            String[] numbers = line.split(" ");

                            int num = Integer.parseInt(numbers[col]);

                            mapTileNum[col][row] = num;
                            col++;
                        }
                        if (col == gp.maxScreenCol) {
                            col = 0;
                            row++;
                        }
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 20:
                try {
                    InputStream is = getClass().getResourceAsStream("/maps/map20.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    int col = 0;
                    int row = 0;

                    while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                        String line = br.readLine();

                        while (col < gp.maxScreenCol) {
                            String[] numbers = line.split(" ");

                            int num = Integer.parseInt(numbers[col]);

                            mapTileNum[col][row] = num;
                            col++;
                        }
                        if (col == gp.maxScreenCol) {
                            col = 0;
                            row++;
                        }
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 24:
                try {
                    InputStream is = getClass().getResourceAsStream("/maps/map24.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    int col = 0;
                    int row = 0;

                    while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                        String line = br.readLine();

                        while (col < gp.maxScreenCol) {
                            String[] numbers = line.split(" ");

                            int num = Integer.parseInt(numbers[col]);

                            mapTileNum[col][row] = num;
                            col++;
                        }
                        if (col == gp.maxScreenCol) {
                            col = 0;
                            row++;
                        }
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 40:
                try {
                    InputStream is = getClass().getResourceAsStream("/maps/map40.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    int col = 0;
                    int row = 0;

                    while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                        String line = br.readLine();

                        while (col < gp.maxScreenCol) {
                            String[] numbers = line.split(" ");

                            int num = Integer.parseInt(numbers[col]);

                            mapTileNum[col][row] = num;
                            col++;
                        }
                        if (col == gp.maxScreenCol) {
                            col = 0;
                            row++;
                        }
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    public boolean isWall(int col, int row) {
        return mapTileNum[col][row] == 0 || mapTileNum[col][row] == 3 || mapTileNum[col][row] == 2;
    }

    public void initTileLabels() {
        for (int col = 0; col < gp.maxScreenCol; col++) {
            for (int row = 0; row < gp.maxScreenRow; row++) {
                tileLabels[col][row] = new JLabel();
                tileLabels[col][row].setSize(gp.tileSize, gp.tileSize);
                tileLabels[col][row].setLocation(col * gp.tileSize, row * gp.tileSize);
                gp.add(tileLabels[col][row]);
            }
        }
    }

    public void draw() {

        for (int row = 0; row < gp.maxScreenRow; row++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {
                int tileNum = mapTileNum[col][row];
                if (tileNum < tile.length && tile[tileNum] != null) {
                    ImageIcon img = tile[tileNum].image;
                    tileLabels[col][row].setIcon(img);
                }
            }
        }

    }


}
