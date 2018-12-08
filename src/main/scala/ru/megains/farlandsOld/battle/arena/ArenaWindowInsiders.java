package ru.megains.farlandsOld.battle.arena;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.gui.guileft.GuiLeft;
import ru.megains.farlandsOld.inventory.EquipInventoryActor;
import ru.megains.farlandsOld.loaders.BattleAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

import java.util.Timer;
import java.util.TimerTask;

public class ArenaWindowInsiders extends Group {
    private Gui gui;
    private int locId;
    private GuiLeft guiLeft;
    private Group leftGroup;
    private EquipInventoryActor equipInventory;
    private Group buttonsGroup;
    private Group battleInfoGroup;
    private BtnInBattle btnBattle;
    private BtnCancel btCancel;
    private BtnExit btnExit;
    private Label timerLabel;
    private int waitTime = 0;
    private Timer timer;

    public ArenaWindowInsiders(Gui gui, int locId) throws ParseException {
        this.gui = gui;
        this.locId = locId;
        this.equipInventory = new EquipInventoryActor(Const.game.getGame().getPlayer().getEquipped());
        this.guiLeft = new GuiLeft(true, Const.game.getGame().getPlayer().getParameters(), Const.game.getGame().getPlayer().getMoney());
        this.leftGroup = new Group();
        this.leftGroup.addActor(this.guiLeft);
        this.leftGroup.addActor(this.equipInventory);
        this.equipInventory.setPosition(0.0F, 0.0F);
        this.guiLeft.setPosition(0.0F, 335.0F);
        this.addActor(this.leftGroup);
        this.btnExit = new BtnExit(gui);
        this.btCancel = new BtnCancel(this);
        this.btnBattle = new BtnInBattle(this);
        this.btnBattle.setActive(true);
        this.buttonsGroup = new Group();
        this.buttonsGroup.addActor(this.btnBattle);
        this.buttonsGroup.addActor(this.btCancel);
        this.btCancel.setPosition(140.0F, 0.0F);
        this.btnExit.setPosition(340.0F, 0.0F);
        this.btnExit.setActive(true);
        this.buttonsGroup.addActor(this.btnExit);
        this.addActor(this.buttonsGroup);
        this.buttonsGroup.setPosition(200.0F, 400.0F);
        this.battleInfoGroup = new Group();
        this.battleInfoGroup.setBounds(0.0F, 0.0F, 300.0F, 150.0F);
        Label battleType = new Label("ДУЭЛЬ", Styles.labelGreen);
        this.battleInfoGroup.addActor(battleType);
        MyActor duel = new MyActor(BattleAtlasLoader.duel);
        this.battleInfoGroup.addActor(duel);
        this.timerLabel = new Label("--", Styles.labelRound);
        this.timerLabel.setPosition(310.0F, 450.0F);
        this.addActor(this.timerLabel);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    public void startTimer() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            public void run() {
                ArenaWindowInsiders.this.waitTime++;
                if (ArenaWindowInsiders.this.waitTime < 10) {
                    ArenaWindowInsiders.this.timerLabel.setText("0" + ArenaWindowInsiders.this.waitTime);
                } else {
                    ArenaWindowInsiders.this.timerLabel.setText("" + ArenaWindowInsiders.this.waitTime);
                }

            }
        }, 1000L, 1000L);
    }

    public void stopTimer() {
        this.timer.cancel();
        this.timer = null;
        this.waitTime = 0;
        this.timerLabel.setText("--");
    }

    public void startBattle() {
        SendPasket.arenaRequestBattle(this.locId);
        this.btCancel.setActive(true);
        this.btnExit.setActive(false);
        this.btnBattle.setActive(false);
    }

    public void sendCancelbattle() {
        SendPasket.arenaCancel(this.locId);
    }

    public void cancelBattle() {
        this.btnBattle.setActive(true);
        this.btnExit.setActive(true);
        this.btCancel.setActive(false);
        this.stopTimer();
    }
}

