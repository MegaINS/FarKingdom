package ru.megains.farlandsOld.gui.guileft;


import com.badlogic.gdx.scenes.scene2d.Group;
import ru.megains.farlandsOld.inventory.BgAttrs;
import ru.megains.farlandsOld.inventory.BgStats;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class EnemyGuiLeft extends Group {
    private BgAttrs bgAttrs;
    private BgStats bgStats;
    private boolean isInventory;
    private String enemyName;

    public EnemyGuiLeft(boolean isInventory, int level, int hpMax, int hpCurent, int energyMax, int EnergyCurent, float carringMax, float carringCurent, int strenght, int conc, int stamina, int intellect, String enemyName) {
        this.isInventory = isInventory;
        this.enemyName = enemyName;
        this.drawSimple();
        this.update(level, hpMax, hpCurent, energyMax, EnergyCurent, carringMax, carringCurent, strenght, conc, stamina, intellect);
    }

    public void update(int level, int hpMax, int hpCurent, int energyMax, int EnergyCurent, float carringMax, float carringCurent, int strenght, int conc, int stamina, int intellect) {
        this.bgAttrs.update(level, 0.0F, 0.0F, 0.0F, 0.0F, hpMax, hpCurent, energyMax, EnergyCurent, carringMax, carringCurent);
        this.bgStats.update(stamina, conc, intellect, strenght);
    }

    public void drawSimple() {
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
        this.bgAttrs.setName(this.enemyName);
    }
}
