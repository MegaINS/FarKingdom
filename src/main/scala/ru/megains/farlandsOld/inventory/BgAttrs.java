package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.ExpTable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.guileft.WeightBar;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.tooltip.SimpleTooltip;

public class BgAttrs extends Group {
    private MyActor bg;
    private MyActor hp;
    private MyActor energy;
    private MyActor expBar;
    private MyActor expEmpty;
    private MyActor weightEmpty;
    private MyActor bgZet;
    private MyActor bgEzet;
    private Label level;
    private Label zet;
    private Label ezet;
    private Label hpLabel;
    private Label energyLabel;
    private Label labelName;
    private SimpleTooltip hpTooltip;
    private SimpleTooltip expTooltip;
    private SimpleTooltip weightEmptyTooltip;
    private SimpleTooltip zetTooltip;
    private SimpleTooltip eZetTooltip;
    private WeightBar weightBar;

    public BgAttrs(Sprite sprite, int alignerX, int alignerY) {
        this.bg = new MyActor(sprite);
        this.addActor(this.bg);
        this.labelName = new Label("-", Styles.labelYellow);
        this.labelName.setPosition((float)(9 - alignerX), (float)(127 + alignerY));
        this.labelName.setWidth(160.0F);
        this.labelName.setAlignment(1);
        this.addActor(this.labelName);
        this.level = new Label("0", Styles.labelGreen);
        this.level.setPosition((float)(135 - alignerX), (float)(95 + alignerY));
        this.addActor(this.level);
        this.expEmpty = new MyActor(UserInfoAtlasLoader.bar_exp_empty);
        this.expEmpty.setPosition((float)(8 - alignerX), (float)(124 + alignerY));
        this.addActor(this.expEmpty);
        this.expBar = new MyActor(GuiAtlasLoader.bar_exp);
        this.expBar.setPosition((float)(8 - alignerX), (float)(124 + alignerY));
        this.expBar.setWidth(0.0F);
        this.addActor(this.expBar);
        this.expTooltip = new SimpleTooltip("", Styles.tooltipLabel, this.expBar, this.expEmpty);
        this.bgZet = new MyActor(UserInfoAtlasLoader.bg_zet);
        this.bgZet.setPosition((float)(105 - alignerX), (float)(54 + alignerY));
        this.addActor(this.bgZet);
        this.zet = new Label("0", Styles.labelYellow);
        this.zet.setPosition((float)(125 - alignerX), (float)(53 + alignerY));
        this.addActor(this.zet);
        this.zetTooltip = new SimpleTooltip("", Styles.tooltipLabel, this.zet, this.bgZet);
        this.bgEzet = new MyActor(UserInfoAtlasLoader.bg_ezet);
        this.bgEzet.setPosition((float)(106 - alignerX), (float)(71 + alignerY));
        this.addActor(this.bgEzet);
        this.ezet = new Label("0", Styles.labelYellow);
        this.ezet.setPosition((float)(125 - alignerX), (float)(71 + alignerY));
        this.addActor(this.ezet);
        this.eZetTooltip = new SimpleTooltip("", Styles.tooltipLabel, this.ezet, this.bgEzet);
        this.hp = new MyActor(GuiAtlasLoader.bar_life);
        this.hp.setPosition((float)(36 - alignerX), (float)(29 + alignerY));
        this.addActor(this.hp);
        this.hpTooltip = new SimpleTooltip("Здоровье", Styles.tooltipLabel, this.hp);
        this.energy = new MyActor(GuiAtlasLoader.bar_stamina);
        this.energy.setPosition((float)(36 - alignerX), (float)(9 + alignerY));
        this.addActor(this.energy);
        this.hpLabel = new Label("0", Styles.labelYellow);
        this.hpLabel.setPosition((float)(40 - alignerX), (float)(28 + alignerY));
        this.addActor(this.hpLabel);
        this.energyLabel = new Label("0", Styles.labelYellow);
        this.energyLabel.setPosition((float)(40 - alignerX), (float)(8 + alignerY));
        this.addActor(this.energyLabel);
        this.weightEmpty = new MyActor(UserInfoAtlasLoader.bar_weight_empty);
        this.weightEmpty.setPosition((float)(139 - alignerX), (float)(7 + alignerY));
        this.addActor(this.weightEmpty);
        this.weightEmptyTooltip = new SimpleTooltip("", Styles.tooltipLabel, this.weightEmpty);
        this.weightBar = new WeightBar();
        this.weightBar.setPosition((float)(140 - alignerX), (float)(9 + alignerY));
        this.addActor(this.weightBar);
    }

    public void update(int level, float exp, float nextExp, float zet, float ezet, int hpMax, int hpCurent, int energyMax, int energyCurrent, float carryingMax, float currentCarryng) {
        this.level.setText("" + level);
        String stringZet = "0";
        float weightPercent;
        if (zet < 1000.0F) {
            stringZet = "" + zet;
        } else {
            int temp;
            if (zet >= 1000.0F && zet < 1000000.0F) {
                temp = (int)zet;
                weightPercent = (float)temp / 1000.0F;
                weightPercent = (float)Math.round(weightPercent * 10.0F) / 10.0F;
                stringZet = "" + weightPercent + "K";
            } else if (zet >= 1000000.0F && zet < 1.0E9F) {
                temp = (int)zet;
                weightPercent = (float)temp / 1000000.0F;
                weightPercent = (float)Math.round(weightPercent * 10.0F) / 10.0F;
                stringZet = "" + weightPercent + "KK";
            }
        }

        this.zet.setText(stringZet);
        this.zetTooltip.update(" " + zet);
        String stringEZet = "0";
        float height;
        if (ezet < 1000.0F) {
            stringEZet = "" + ezet;
        } else {
            int temp;
            if (ezet >= 1000.0F && ezet < 1000000.0F) {
                temp = (int)ezet;
                height = (float)temp / 1000.0F;
                height = (float)Math.round(height * 10.0F) / 10.0F;
                stringEZet = "" + height + "K";
            } else if (ezet >= 1000000.0F && ezet < 1.0E9F) {
                temp = (int)ezet;
                height = (float)temp / 1000000.0F;
                height = (float)Math.round(height * 10.0F) / 10.0F;
                stringEZet = "" + height + "KK";
            }
        }

        this.ezet.setText(stringEZet);
        this.eZetTooltip.update(" " + ezet);
        if ((float)hpMax != 0.0F) {
            weightPercent = (float)(100 * hpCurent / hpMax);
            this.hp.setWidth(weightPercent * 0.89F);
            if (this.hp.getWidth() < 0.0F) {
                this.hp.setWidth(0.0F);
            }

            if (this.hp.getWidth() > 89.0F) {
                this.hp.setWidth(89.0F);
            }

            this.hpLabel.setText("" + hpCurent + " / " + hpMax);
            this.hpTooltip.update(" " + hpCurent + " / " + hpMax);
        }

        if ((float)energyMax != 0.0F) {
            weightPercent = (float)(100 * energyCurrent / energyMax);
            this.energy.setWidth(weightPercent * 0.89F);
            if (this.energy.getWidth() < 0.0F) {
                this.energy.setWidth(0.0F);
            }

            if (this.energy.getWidth() > 89.0F) {
                this.energy.setWidth(89.0F);
            }

            this.energyLabel.setText("" + energyCurrent + " / " + energyMax);
        }

        if (exp != 0.0F) {
            weightPercent = ExpTable.getLevelExp(level);
            height = 100.0F * (exp - weightPercent) / (ExpTable.getLevelExp(level + 1) - weightPercent);
            this.expBar.setWidth(height * 1.56F);
            if (this.expBar.getWidth() < 0.0F) {
                this.expBar.setWidth(0.0F);
            }

            if (this.expBar.getWidth() > 156.0F) {
                this.expBar.setWidth(156.0F);
            }

            this.expTooltip.update(" " + exp + " / " + nextExp);
        }

        if (carryingMax != 0.0F) {
            weightPercent = 100.0F * currentCarryng / carryingMax;
            height = weightPercent * 0.32F;
            if (height >= 32.0F) {
                this.weightBar.setHeight(32.0F);
                this.weightBar.start();
            } else {
                this.weightBar.stop();
                this.weightBar.setHeight(height);
            }

            this.weightBar.update(currentCarryng, carryingMax);
            this.weightEmptyTooltip.update(" " + currentCarryng + "/" + carryingMax);
        }

    }

    public void setName(String name) {
        this.labelName.setText(name);
    }
}

