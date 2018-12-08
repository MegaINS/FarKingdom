package ru.megains.farlandsOld.gui.guileft;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class BgStatsUp extends Group {
    private MyActor bg;
    private MyActor bgStatsButtons;
    private BtnStatsDown stenghtDown;
    private BtnStatsDown staminaDown;
    private BtnStatsDown concDown;
    private BtnStatsDown intellectDown;
    private BtnStatsUp stenghtUp;
    private BtnStatsUp staminaUp;
    private BtnStatsUp concUp;
    private BtnStatsUp intellectUp;
    private FreeStats freeStats;
    private Label statsLabel;

    public BgStatsUp(FreeStats freeStats) {
        this.bg = new MyActor(GuiAtlasLoader.bg_bott);
        this.freeStats = freeStats;
        this.bg.setPosition(3.0F, 0.0F);
        this.bg.setHeight(110.0F);
        this.addActor(this.bg);
        this.bgStatsButtons = new MyActor(GuiAtlasLoader.bgStatsButtons);
        this.addActor(this.bgStatsButtons);
        this.stenghtDown = new BtnStatsDown(freeStats, "strenght");
        this.staminaDown = new BtnStatsDown(freeStats, "stamina");
        this.concDown = new BtnStatsDown(freeStats, "conc");
        this.intellectDown = new BtnStatsDown(freeStats, "int");
        this.stenghtDown.setPosition(7.0F, 33.0F);
        this.staminaDown.setPosition(50.0F, 33.0F);
        this.concDown.setPosition(93.0F, 33.0F);
        this.intellectDown.setPosition(136.0F, 33.0F);
        this.addActor(this.stenghtDown);
        this.addActor(this.staminaDown);
        this.addActor(this.concDown);
        this.addActor(this.intellectDown);
        this.stenghtUp = new BtnStatsUp(freeStats, "strenght");
        this.staminaUp = new BtnStatsUp(freeStats, "stamina");
        this.concUp = new BtnStatsUp(freeStats, "conc");
        this.intellectUp = new BtnStatsUp(freeStats, "int");
        this.stenghtUp.setPosition(7.0F, 85.0F);
        this.staminaUp.setPosition(50.0F, 85.0F);
        this.concUp.setPosition(93.0F, 85.0F);
        this.intellectUp.setPosition(136.0F, 85.0F);
        this.addActor(this.stenghtUp);
        this.addActor(this.staminaUp);
        this.addActor(this.concUp);
        this.addActor(this.intellectUp);
        BtnAcceptStats statsUp = new BtnAcceptStats(freeStats);
        statsUp.setPosition(78.0F, 4.0F);
        statsUp.setActive(true);
        this.addActor(statsUp);
        this.statsLabel = new Label("" + freeStats.getTotal(), Styles.labelYellow);
        this.statsLabel.setPosition(19.0F, 5.0F);
        this.statsLabel.setWidth(48.0F);
        this.statsLabel.setAlignment(1);
        this.addActor(this.statsLabel);
    }

    public void setActiveUpButtons(boolean active) {
        this.stenghtUp.setActive(active);
        this.staminaUp.setActive(active);
        this.concUp.setActive(active);
        this.intellectUp.setActive(active);
        this.statsLabel.setText("" + this.freeStats.getFreeStats());
    }

    public void setActiveDownButtons() {
        if (this.freeStats.getStrenght() > 0) {
            this.stenghtDown.setActive(true);
        } else {
            this.stenghtDown.setActive(false);
        }

        if (this.freeStats.getStamina() > 0) {
            this.staminaDown.setActive(true);
        } else {
            this.staminaDown.setActive(false);
        }

        if (this.freeStats.getConc() > 0) {
            this.concDown.setActive(true);
        } else {
            this.concDown.setActive(false);
        }

        if (this.freeStats.getIntellect() > 0) {
            this.intellectDown.setActive(true);
        } else {
            this.intellectDown.setActive(false);
        }

        this.statsLabel.setText("" + this.freeStats.getFreeStats());
    }

    public void updateFreeStatsLabel() {
    }
}

