package ru.megains.farlandsOld.battle;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.BattleAtlasLoader;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

import java.util.Timer;
import java.util.TimerTask;

public class BarContainer extends Group {
    private MyActor balans;
    private MyActor life;
    private MyActor energy;
    private MyActor enemyBalans;
    private MyActor enemyLife;
    private MyActor enemyEnergy;
    private Label balansLabel;
    private Label lifeLabel;
    private Label energyLabel;
    private Label enemyBalansLabel;
    private Label enemyLifeLabel;
    private Label enemyEnergyLabel;
    private Label roundLabel;
    private Label timerLabel;
    private int roundTime = 15;
    private Timer timer;

    public BarContainer() {
        TimerTask tt = new TimerTask() {
            public void run() {
                if (BarContainer.this.roundTime > 0) {
                    BarContainer.this.roundTime--;
                }

                if (BarContainer.this.roundTime < 10) {
                    BarContainer.this.timerLabel.setText("00:0" + BarContainer.this.roundTime);
                } else {
                    BarContainer.this.timerLabel.setText("00:" + BarContainer.this.roundTime);
                }

            }
        };
        MyActor bg = new MyActor(BattleAtlasLoader.bar_container);
        this.addActor(bg);
        this.life = new MyActor(GuiAtlasLoader.battle_life);
        this.life.setPosition(1.0F, 58.0F);
        this.addActor(this.life);
        this.lifeLabel = new Label("0", Styles.labelYellow);
        this.lifeLabel.setPosition(20.0F, 58.0F);
        this.addActor(this.lifeLabel);
        this.energy = new MyActor(GuiAtlasLoader.battle_stamina);
        this.energy.setPosition(1.0F, 29.0F);
        this.addActor(this.energy);
        this.energyLabel = new Label("0", Styles.labelYellow);
        this.energyLabel.setPosition(20.0F, 29.0F);
        this.addActor(this.energyLabel);
        this.balans = new MyActor(GuiAtlasLoader.battle_balans);
        this.balans.setPosition(1.0F, 1.0F);
        this.addActor(this.balans);
        this.balansLabel = new Label("0", Styles.labelYellow);
        this.balansLabel.setPosition(20.0F, 0.0F);
        this.addActor(this.balansLabel);
        this.enemyLife = new MyActor(GuiAtlasLoader.battle_life);
        this.enemyLife.setPosition(239.0F, 58.0F);
        this.addActor(this.enemyLife);
        this.enemyLifeLabel = new Label("0", Styles.labelYellow);
        this.enemyLifeLabel.setPosition(330.0F, 58.0F);
        this.addActor(this.enemyLifeLabel);
        this.enemyEnergy = new MyActor(GuiAtlasLoader.battle_stamina);
        this.enemyEnergy.setPosition(239.0F, 29.0F);
        this.addActor(this.enemyEnergy);
        this.enemyEnergyLabel = new Label("0", Styles.labelYellow);
        this.enemyEnergyLabel.setPosition(330.0F, 29.0F);
        this.addActor(this.enemyEnergyLabel);
        this.enemyBalans = new MyActor(GuiAtlasLoader.battle_balans);
        this.enemyBalans.setPosition(239.0F, 1.0F);
        this.addActor(this.enemyBalans);
        this.enemyBalansLabel = new Label("0", Styles.labelYellow);
        this.enemyBalansLabel.setPosition(330.0F, 1.0F);
        this.addActor(this.enemyBalansLabel);
        this.roundLabel = new Label("01", Styles.labelRound);
        this.roundLabel.setPosition(184.0F, 23.0F);
        this.addActor(this.roundLabel);
        this.timerLabel = new Label("00:15", Styles.labelTimer);
        this.timerLabel.setPosition(183.0F, 3.0F);
        this.addActor(this.timerLabel);
        this.timer = new Timer();
        this.timer.schedule(tt, 1000L, 1000L);
    }

    public void update(int round, int hpMax, int hpCurrent, int energyMax, int energyCurrent, int balansMax, int balansCurrent, int enemyHpMax, int enemyHpCurrent, int enemyEnergyMax, int enemyEnergyCurrent, int enemyBalansMax, int enemyBalansCurrent) {
        float enemyBalansPercent;
        if ((float)hpMax != 0.0F) {
            enemyBalansPercent = (float)(100 * hpCurrent / hpMax);
            this.life.setWidth(enemyBalansPercent * 1.6F);
            if (this.life.getWidth() < 0.0F) {
                this.life.setWidth(0.0F);
            }

            if (this.life.getWidth() > 160.0F) {
                this.life.setWidth(160.0F);
            }

            this.lifeLabel.setText("" + hpCurrent + " / " + hpMax);
        }

        if ((float)energyMax != 0.0F) {
            enemyBalansPercent = (float)(100 * energyCurrent / energyMax);
            this.energy.setWidth(enemyBalansPercent * 1.6F);
            if (this.energy.getWidth() < 0.0F) {
                this.energy.setWidth(0.0F);
            }

            if (this.energy.getWidth() > 160.0F) {
                this.energy.setWidth(160.0F);
            }

            this.energyLabel.setText("" + energyCurrent + " / " + energyMax);
        }

        if ((float)balansMax != 0.0F) {
            enemyBalansPercent = (float)(100 * balansCurrent / balansMax);
            this.balans.setWidth(enemyBalansPercent * 1.6F);
            if (this.balans.getWidth() < 0.0F) {
                this.balans.setWidth(0.0F);
            }

            if (this.balans.getWidth() > 160.0F) {
                this.balans.setWidth(160.0F);
            }

            this.balansLabel.setText("" + balansCurrent + " / " + balansMax);
        }

        if ((float)enemyHpMax != 0.0F) {
            enemyBalansPercent = (float)(100 * enemyHpCurrent / enemyHpMax);
            this.enemyLife.setWidth(enemyBalansPercent * 1.6F);
            if (this.enemyLife.getWidth() < 0.0F) {
                this.enemyLife.setWidth(0.0F);
            }

            if (this.enemyLife.getWidth() > 160.0F) {
                this.enemyLife.setWidth(160.0F);
            }

            this.enemyLifeLabel.setText("" + enemyHpCurrent + " / " + enemyHpMax);
        }

        if ((float)enemyEnergyMax != 0.0F) {
            enemyBalansPercent = (float)(100 * enemyEnergyCurrent / enemyEnergyMax);
            this.enemyEnergy.setWidth(enemyBalansPercent * 1.6F);
            if (this.enemyEnergy.getWidth() < 0.0F) {
                this.enemyEnergy.setWidth(0.0F);
            }

            if (this.enemyEnergy.getWidth() > 160.0F) {
                this.enemyEnergy.setWidth(160.0F);
            }

            this.enemyEnergy.setX(239.0F + (160.0F - this.enemyEnergy.getWidth()));
            this.enemyEnergyLabel.setText("" + enemyEnergyCurrent + " / " + enemyEnergyMax);
        }

        if ((float)enemyBalansMax != 0.0F) {
            enemyBalansPercent = (float)(100 * enemyBalansCurrent / enemyBalansMax);
            this.enemyBalans.setWidth(enemyBalansPercent * 1.6F);
            if (this.enemyBalans.getWidth() < 0.0F) {
                this.enemyBalans.setWidth(0.0F);
            }

            if (this.enemyBalans.getWidth() > 160.0F) {
                this.enemyBalans.setWidth(160.0F);
            }

            this.enemyBalansLabel.setText("" + enemyBalansCurrent + " / " + enemyBalansMax);
            this.enemyBalans.setX(239.0F + (160.0F - this.enemyBalans.getWidth()));
        }

        if (round < 10) {
            this.roundLabel.setText("0" + round);
        } else {
            this.roundLabel.setText("" + round);
        }

        this.roundTime = 15;
        this.timerLabel.setText("00:" + this.roundTime);
    }
}

