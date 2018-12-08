package ru.megains.farlands.old;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GameCell extends Actor {
    private Sprite sprite;
    public Boolean isEmpty;
    private int cellX;
    private int cellY;
   // private int damage;
    private int count;
  //  private int type;

    public GameCell(int cellX, int cellY,/* int cellType, */int count,/* int damage,*/ int mask) {
      //  this.type = cellType;
       // this.count = count;
        if (count > 0) {
            this.isEmpty = false;
        } else {
            this.isEmpty = true;
        }


      //  this.damage = damage;
        if (!this.isEmpty) {
            switch(mask) {
                case 0:
                    this.sprite = DangeAtlasLoader.bush;
                    break;
                case 1:
                    this.sprite = DangeAtlasLoader.bush1;
                    break;
                case 2:
                    this.sprite = DangeAtlasLoader.bush2;
                    break;
                case 3:
                    this.sprite = DangeAtlasLoader.bush3;
                    break;
                case 4:
                    this.sprite = DangeAtlasLoader.bush4;
                    break;
                case 5:
                    this.sprite = DangeAtlasLoader.bush5;
                    break;
                case 6:
                    this.sprite = DangeAtlasLoader.bush6;
            }
        }

        this.setSize(100.0F, 100.0F);
        this.setBounds(0.0F, 0.0F, 100.0F, 100.0F);
        setPosition(cellX*100,cellY*100);
        this.cellX = cellX;
        this.cellY = cellY;
    }

//    public void hitAction() {
//        if (!this.isEmpty) {
//            Player player = Const.game.getGame().getPlayer();
//            int playerX = player.getPlayerX();
//            int playerY = player.getPlayerY();
//            if (player.isBlocked()) {
//                return;
//            }
//
//            if (this.cellX == playerX && (-this.cellY == playerY - 1 || -this.cellY == playerY + 1) || -this.cellY == playerY && (this.cellX == playerX - 1 || this.cellX == playerX + 1)) {
//                SendPasket.extractGameCell(this.cellX, this.cellY);
//                player.setBlocked(true);
//                if (player.getPlayerX() > this.cellX) {
//                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_LEFT);
//                } else if (player.getPlayerX() < this.cellX) {
//                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_RIGHT);
//                } else if (player.getPlayerY() < -this.cellY) {
//                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_TOP);
//                } else if (player.getPlayerY() > -this.cellY) {
//                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_DOWN);
//                }
//            }
//        }
//
//    }

    public void draw(Batch batch, float parentAlpha) {
        if (this.sprite != null) {
            batch.draw(this.sprite, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(), this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
        }

    }



    public int getCellX() {
        return this.cellX;
    }

    public int getCellY() {
        return this.cellY;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}

