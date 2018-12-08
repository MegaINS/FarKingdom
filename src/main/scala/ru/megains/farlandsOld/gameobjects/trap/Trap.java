package ru.megains.farlandsOld.gameobjects.trap;


import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gameobjects.player.Player;
import ru.megains.farlandsOld.gameobjects.player.PlayerAction;
import ru.megains.farlandsOld.loaders.TrapsAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;
import ru.megains.farlandsOld.tooltip.TrapTooltip;

public class Trap extends MyActor {
    private int id;
    private int trapX;
    private int trapY;
    private String name;
    private int damage;
    private int damageRange;

    public Trap(int id, int trapX, int trapY, String name, int damage, int damageRange) {
        this.id = id;
        this.trapX = trapX;
        this.trapY = trapY;
        this.name = name;
        this.damage = damage;
        this.damageRange = damageRange;
        this.setSprite(TrapsAtlasLoader.getSpriteById(id));
        new TrapTooltip(this);
    }

    public void hitAction() {
        System.out.println("trap hit");
        Player player = Const.game.getGame().getPlayer();
        int playerX = player.getPlayerX();
        int playerY = player.getPlayerY();
        if (!player.isBlocked()) {
            if (this.trapX == playerX && (-this.trapY == playerY - 1 || -this.trapY == playerY + 1) || -this.trapY == playerY && (this.trapX == playerX - 1 || this.trapX == playerX + 1)) {
                System.out.println("trap klac");
                player.setBlocked(true);
                SendPasket.extractGameCell(this.trapX, this.trapY);
                if (player.getPlayerX() > this.trapX) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_LEFT);
                } else if (player.getPlayerX() < this.trapX) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_RIGHT);
                } else if (player.getPlayerY() < -this.trapY) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_TOP);
                } else if (player.getPlayerY() > -this.trapY) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_DOWN);
                }
            }

        }
    }

    public int getId() {
        return this.id;
    }

    public int getTrapX() {
        return this.trapX;
    }

    public int getTrapY() {
        return this.trapY;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDamageRange() {
        return this.damageRange;
    }
}

