package main;

import Entities.Entity;

public class CollisionHandler {
    GamePanel gp;

    public CollisionHandler(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeft = entity.x + entity.solidArea.x;
        int entityRight = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTop = entity.y + entity.solidArea.y;
        int entityBot = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeft / gp.tileSize;
        int entityRightCol = entityRight / gp.tileSize;
        int entityTopRow = entityTop / gp.tileSize;
        int entityBotRow = entityBot / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.dir) {
            case "up":
                entityTopRow = (entityTop - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if ((gp.tileM.tile[tileNum1].collision && !gp.tileM.tile[tileNum1].topCollisionOnly) ||
                        (gp.tileM.tile[tileNum2].collision && !gp.tileM.tile[tileNum2].topCollisionOnly)) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBotRow = (entityBot + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
                if ((gp.tileM.tile[tileNum1].collision && !gp.tileM.tile[tileNum1].topCollisionOnly) ||
                        (gp.tileM.tile[tileNum2].collision && !gp.tileM.tile[tileNum2].topCollisionOnly) ||
                        (gp.tileM.tile[tileNum1].topCollisionOnly && entityBot >= entityTopRow * gp.tileSize) ||
                        (gp.tileM.tile[tileNum2].topCollisionOnly && entityBot >= entityTopRow * gp.tileSize)) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeft - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision && !gp.tileM.tile[tileNum1].topCollisionOnly ||
                        gp.tileM.tile[tileNum2].collision && !gp.tileM.tile[tileNum2].topCollisionOnly) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRight + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tileM.tile[tileNum1].collision && !gp.tileM.tile[tileNum1].topCollisionOnly ||
                        gp.tileM.tile[tileNum2].collision && !gp.tileM.tile[tileNum2].topCollisionOnly) {
                    entity.collisionOn = true;
                }
                break;
        }
    }


}
