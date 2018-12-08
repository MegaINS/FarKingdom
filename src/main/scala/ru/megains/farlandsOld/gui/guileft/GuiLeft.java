package ru.megains.farlandsOld.gui.guileft;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.player.PlayerMoney;
import ru.megains.farlandsOld.gameobjects.player.PlayerParameters;
import ru.megains.farlandsOld.inventory.BgAttrs;
import ru.megains.farlandsOld.inventory.BgStats;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class GuiLeft extends Group implements ParametersListener {
    private BgAttrs bgAttrs;
    private BgStats bgStats;
    private BgStatsUp bgStatsUp;
    private PlayerParameters parameters;
    private PlayerMoney money;
    private FreeStats freeStats = new FreeStats(this);
    private boolean isInventory;

    public GuiLeft(boolean isInventory, PlayerParameters parameters, PlayerMoney money) {
        this.parameters = parameters;
        this.money = money;
        parameters.addListener(this);
        this.isInventory = isInventory;
        this.drawSimple();
        this.hasChanged();
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    public void drawSimple() {
        if (this.bgStatsUp != null) {
            this.bgStatsUp.setVisible(false);
        }

        if (!this.isInventory) {
            if (this.bgAttrs == null) {
                this.bgAttrs = new BgAttrs(GuiAtlasLoader.bgAttrs, 0, 0);
                this.addActor(this.bgAttrs);
            }

            if (this.bgStats == null) {
                this.bgStats = new BgStats(GuiAtlasLoader.bgStats, 0);
                this.addActor(this.bgStats);
            }
        } else {
            if (this.bgAttrs == null) {
                this.bgAttrs = new BgAttrs(UserInfoAtlasLoader.bg_attrs, 3, 1);
                this.addActor(this.bgAttrs);
            }

            if (this.bgStats == null) {
                this.bgStats = new BgStats(UserInfoAtlasLoader.bg_stats, 2);
                this.addActor(this.bgStats);
            }
        }

        this.bgAttrs.setPosition(0.0F, 32.0F);
        this.bgStats.setPosition(0.0F, 0.0F);
    }

    public void drawStatsUp() {
        if (!this.isInventory) {
            if (this.bgStatsUp == null) {
                this.bgStatsUp = new BgStatsUp(this.freeStats);
                this.addActor(this.bgStatsUp);
            }

            if (this.bgAttrs == null) {
                this.bgAttrs = new BgAttrs(GuiAtlasLoader.bgAttrs, 0, 0);
                this.addActor(this.bgAttrs);
            }

            if (this.bgStats == null) {
                this.bgStats = new BgStats(GuiAtlasLoader.bgStats, 0);
                this.addActor(this.bgStats);
            }

            if (this.bgStatsUp != null) {
                this.bgStatsUp.setVisible(true);
            }

            this.bgAttrs.setPosition(0.0F, 110.0F);
            this.bgStats.setPosition(0.0F, 54.0F);
            this.bgStatsUp.setZIndex(1);
            this.bgStats.setZIndex(2);
        } else {
            this.drawSimple();
        }

    }

    public void hasChanged() {


        if (this.parameters.getFreeStats() > 0) {
            if (this.parameters.getFreeStats() != this.freeStats.getTotal()) {
                this.freeStats.reset(this.parameters.getFreeStats());
            }

            this.drawStatsUp();
            this.bgStats.update(this.parameters.getStamina() + this.freeStats.getStamina(), this.parameters.getConc() + this.freeStats.getConc(), this.parameters.getIntellect() + this.freeStats.getIntellect(), this.parameters.getStrenght() + this.freeStats.getStrenght());
        } else {
            this.drawSimple();
            this.bgStats.update(this.parameters.getStamina(), this.parameters.getConc(), this.parameters.getIntellect(), this.parameters.getStrenght());
            this.freeStats.reset(0);
        }

        this.bgAttrs.update(this.parameters.getLevel(), this.parameters.getExp(), this.parameters.getNextExp(), this.money.getZet(), this.money.getEzet(), this.parameters.getHpMax(), this.parameters.getHpCurent(), this.parameters.getEnergyMax(), this.parameters.getEnergyCurrent(), this.parameters.getCarryingMax(), this.parameters.getCarryingCurent());
        if (this.bgStatsUp != null) {
            if (this.freeStats.getFreeStats() > 0) {
                this.bgStatsUp.setActiveUpButtons(true);
            } else {
                this.bgStatsUp.setActiveUpButtons(false);
            }

            this.bgStatsUp.setActiveDownButtons();
        }
        freeStats.addFreeStats(100);
        parameters.setFreeStats(100);
        this.bgAttrs.setName(Const.game.getGame().getPlayer().getName());
    }
}
