package ru.megains.farlandsOld.gameobjects.res;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.player.Player;
import ru.megains.farlandsOld.gameobjects.player.PlayerAction;
import ru.megains.farlandsOld.loaders.ResAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class ResCell extends Actor {
    private Sprite sprite;
    private int cellX;
    private int cellY;
    private int damage;
    private int count;
    private int type;
    private String name;

    public ResCell(int cellX, int cellY, int res, int count, String name, int damage) {
        this.setSprite(res, count);
        this.count = count;
        this.damage = damage;
        this.name = name;
        this.setSize(100.0F, 100.0F);
        this.setBounds(0.0F, 0.0F, 100.0F, 100.0F);
        this.cellX = cellX;
        this.cellY = cellY;
        new ResTooltip(this);
    }

    public void draw(Batch batch, float parentAlpha) {
        if (this.count > 0) {
            batch.draw(this.sprite, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(), this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
        }

    }

    public void hitAction() {
        Player player = Const.game.getGame().getPlayer();
        int playerX = player.getPlayerX();
        int playerY = player.getPlayerY();
        if (!player.isBlocked()) {
            if (this.cellX == playerX && (-this.cellY == playerY - 1 || -this.cellY == playerY + 1) || -this.cellY == playerY && (this.cellX == playerX - 1 || this.cellX == playerX + 1)) {
                player.setBlocked(true);
                SendPasket.extractGameCell(this.cellX, this.cellY);
                if (player.getPlayerX() > this.cellX) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_LEFT);
                } else if (player.getPlayerX() < this.cellX) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_RIGHT);
                } else if (player.getPlayerY() < -this.cellY) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_TOP);
                } else if (player.getPlayerY() > -this.cellY) {
                    Const.game.getGame().getPlayer().startMove(PlayerAction.EXTRACT_RES_DOWN);
                }
            }

        }
    }

    private void setSprite(int res, int count) {
        switch(res) {
            case 1:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.rusty_iron1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.rusty_iron2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.rusty_iron3;
                }
                break;
            case 2:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.bad_topol1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.bad_topol2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.bad_topol3;
                }
                break;
            case 3:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.rabbit1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.rabbit2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.rabbit3;
                }
                break;
            case 4:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.cast_iron1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.cast_iron2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.cast_iron3;
                }
                break;
            case 5:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.copper1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.copper2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.copper3;
                }
                break;
            case 6:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.iron1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.iron2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.iron3;
                }
                break;
            case 7:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.osina1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.osina2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.osina3;
                }
                break;
            case 8:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.yasen1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.yasen2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.yasen3;
                }
                break;
            case 9:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.dub1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.dub2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.dub3;
                }
                break;
            case 10:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.deep1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.deep2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.deep3;
                }
                break;
            case 11:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.boar1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.boar2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.boar3;
                }
                break;
            case 12:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.wolf1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.wolf2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.wolf3;
                }
                break;
            case 13:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.met_gold1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.met_gold1;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.met_gold1;
                }
                break;
            case 14:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.skin_varask1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.skin_varask2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.skin_varask3;
                }
                break;
            case 15:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.met_cagalyte1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.met_cagalyte2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.met_cagalyte3;
                }
                break;
            case 16:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.skin_kilot1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.skin_kilot2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.skin_kilot3;
                }
                break;
            case 17:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.wood_bluetis1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.wood_bluetis1;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.wood_bluetis1;
                }
                break;
            case 18:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_amethyst1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_amethyst2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_amethyst3;
                }
                break;
            case 19:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_amethyst1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_amethyst2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_amethyst3;
                }
                break;
            case 20:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_diamond1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_diamond2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_diamond3;
                }
                break;
            case 21:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_diamond1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_diamond2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_diamond3;
                }
                break;
            case 22:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_emerald1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_emerald2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_emerald3;
                }
                break;
            case 23:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_emerald1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_emerald2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_emerald3;
                }
                break;
            case 24:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_feerit1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_feerit2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_feerit3;
                }
                break;
            case 25:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_feerit1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_feerit2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_feerit3;
                }
                break;
            case 26:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_onyx1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_onyx2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_onyx3;
                }
                break;
            case 27:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_onyx1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_onyx2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_onyx3;
                }
                break;
            case 28:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_ruby1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_ruby2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_ruby3;
                }
                break;
            case 29:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_ruby1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_ruby2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_ruby3;
                }
                break;
            case 30:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_topaz1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_topaz2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_topaz3;
                }
                break;
            case 31:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.gem_topaz1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.gem_topaz2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.gem_topaz3;
                }
                break;
            case 32:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.wood_zlatolist1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.wood_zlatolist2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.wood_zlatolist3;
                }
                break;
            case 33:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_zholud1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_zholud2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_zholud3;
                }
                break;
            case 34:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_shishka_zlatolist1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_shishka_zlatolist2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_shishka_zlatolist3;
                }
                break;
            case 35:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_talisman1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_talisman2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_talisman3;
                }
                break;
            case 36:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_cherep_krolika1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_cherep_krolika2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_cherep_krolika3;
                }
                break;
            case 37:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_yagoda_blue1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_yagoda_blue2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_yagoda_blue3;
                }
                break;
            case 38:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_rog_kilota1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_rog_kilota2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_rog_kilota3;
                }
                break;
            case 39:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_grib_sin1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_grib_sin2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_grib_sin3;
                }
                break;
            case 40:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_grib_solnech1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_grib_solnech2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_grib_solnech3;
                }
                break;
            case 41:
                if (count == 1) {
                    this.sprite = ResAtlasLoader.alc_snakeskin1;
                }

                if (count == 2) {
                    this.sprite = ResAtlasLoader.alc_snakeskin2;
                }

                if (count >= 3) {
                    this.sprite = ResAtlasLoader.alc_snakeskin3;
                }
        }

    }

    public int getCellX() {
        return this.cellX;
    }

    public int getCellY() {
        return this.cellY;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getCount() {
        return this.count;
    }

    public String getName() {
        return this.name;
    }
}
