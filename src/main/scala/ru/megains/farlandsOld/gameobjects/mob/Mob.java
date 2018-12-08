package ru.megains.farlandsOld.gameobjects.mob;


import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gameobjects.player.Player;
import ru.megains.farlandsOld.gameobjects.player.PlayerAction;
import ru.megains.farlandsOld.loaders.MobAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;
import ru.megains.farlandsOld.tooltip.MobTooltip;

public class Mob extends MyActor {
    private int mobX;
    private int mobY;
    private String name;
    private int level;
    private int conc;
    private int hpMax;
    private int hpCurent;
    private int damage;
    private int damageRange;
    private int crit;
    private int defence;
    private int antiCrit;

    public Mob(int mobX, int mobY, int id, String name, int level, int conc, int hpMax, int hpCurent, int damage, int damageRange, int crit, int defence, int antiCrit) {
        this.mobX = mobX;
        this.mobY = mobY;
        this.name = name;
        this.level = level;
        this.conc = conc;
        this.hpMax = hpMax;
        this.hpCurent = hpCurent;
        this.damage = damage;
        this.damageRange = damageRange;
        this.crit = crit;
        this.defence = defence;
        this.antiCrit = antiCrit;
        this.setSprite(MobAtlasLoader.getSpriteById(id));
        new MobTooltip(this);
    }

    public void hitAction() {
        Player player = Const.game.getGame().getPlayer();
        int playerX = player.getPlayerX();
        int playerY = player.getPlayerY();
        if (!player.isBlocked()) {
            if (this.mobX == playerX && (-this.mobY == playerY - 1 || -this.mobY == playerY + 1) || -this.mobY == playerY && (this.mobX == playerX - 1 || this.mobX == playerX + 1)) {
                player.setBlocked(true);
                SendPasket.extractGameCell(this.mobX, this.mobY);
                if (player.getPlayerX() > this.mobX) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_LEFT);
                } else if (player.getPlayerX() < this.mobX) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_RIGHT);
                } else if (player.getPlayerY() < -this.mobY) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_TOP);
                } else if (player.getPlayerY() > -this.mobY) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_DOWN);
                }
            }

        }
    }

    public String getName() {
        return this.name;
    }

    public int getMobX() {
        return this.mobX;
    }

    public int getMobY() {
        return this.mobY;
    }

    public int getLevel() {
        return this.level;
    }

    public int getConc() {
        return this.conc;
    }

    public int getHpMax() {
        return this.hpMax;
    }

    public int getHpCurent() {
        return this.hpCurent;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDamageRange() {
        return this.damageRange;
    }

    public int getCrit() {
        return this.crit;
    }

    public int getDefence() {
        return this.defence;
    }

    public int getAntiCrit() {
        return this.antiCrit;
    }
}
