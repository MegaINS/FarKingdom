package ru.megains.farlandsOld.battle;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.loaders.BattleAtlasLoader;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.tooltip.SimpleTooltip;

public class BattleWindow extends Group {
    private Group bg;
    private Gui gui;
    private BattleWindowInsiders battle;
    private Group attackButtonsGroup;
    private int battleId;
    public static final int SHOT_ATTACK = 1;
    public static final int CHOP_ATTACK = 2;
    public static final int ANTI_SHOT_ATTACK = 3;
    public static final int ANTI_CHOP_ATTACK = 4;
    public static final int BLOCK = 5;
    public static final int DODGE = 6;
    public static final int REST = 7;

    public BattleWindow(Gui gui, int battleId, int round, JSONObject enemyParameters, JSONObject enemyEquiped, String enemyName) throws ParseException {
        this.gui = gui;
        this.battleId = battleId;
        this.setBounds();
        this.bg = new Group();
        this.addActor(this.bg);
        this.battle = new BattleWindowInsiders(gui, battleId, round, enemyParameters, enemyEquiped, enemyName);
        this.battle.setPosition(0.0F, 0.0F);
        this.addActor(this.battle);
        this.attackButtonsGroup = new Group();
        this.setButtons();
        this.addActor(this.attackButtonsGroup);
        this.attackButtonsGroup.setPosition(300.0F, 10.0F);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    private void setBg(int w, int h) {
        this.bg.clear();
        this.bg.setBounds(0.0F, 0.0F, (float)w, (float)h);

        for(int i = 0; (float)i < this.bg.getWidth() / 160.0F; ++i) {
            for(int j = 0; (float)j < this.bg.getWidth() / 200.0F; ++j) {
                MyActor bgActor = new MyActor(UserInfoAtlasLoader.bg);
                bgActor.setPosition((float)(i * 168), (float)(j * 200));
                this.bg.addActor(bgActor);
            }
        }

        this.bg.setPosition(0.0F, 0.0F);
    }

    private void setBounds() {
        this.setWidth((float) Gdx.graphics.getWidth());
        this.setHeight((float)(Gdx.graphics.getHeight() - 25 - 37 - 5) - this.gui.getSplitPane().getHeight());
        this.setPosition(0.0F, this.gui.getSplitPane().getHeight() + 37.0F + 5.0F);
    }

    public void resize(int w, int h, int splitH) {
        this.setBg(w, h);
        this.battle.setPosition(10.0F, (float)(splitH - 530));
        this.battle.resize();
    }

    public void finishRound(int round, String playerStr, String enemyStr, JSONObject enemyParameters, JSONObject enemyEquiped) throws ParseException {
        this.battle.drawRound(round, playerStr, enemyStr, enemyParameters, enemyEquiped);
    }

    private void setButtons() {
        AttackButton btnShot = new AttackButton(BattleAtlasLoader.btn_hit, BattleAtlasLoader.sel_hit, BattleAtlasLoader.over_hit, BattleAtlasLoader.btn_hit, 1, this.battleId);
        btnShot.setActive(true);
        new SimpleTooltip("Колющий удар: Энергия -30, Баланс -15", Styles.tooltipLabel, btnShot);
        AttackButton btnChop = new AttackButton(BattleAtlasLoader.btn_hit2, BattleAtlasLoader.sel_hit2, BattleAtlasLoader.over_hit2, BattleAtlasLoader.btn_hit2, 2, this.battleId);
        btnChop.setActive(true);
        new SimpleTooltip("Рубящий удар: Энергия -15, Баланс -30", Styles.tooltipLabel, btnChop);
        AttackButton antiShot = new AttackButton(BattleAtlasLoader.btn_hit, BattleAtlasLoader.sel_hit, BattleAtlasLoader.over_hit, BattleAtlasLoader.btn_hit, 3, this.battleId);
        antiShot.setActive(true);
        new SimpleTooltip("Контрудар: Энергия -15, Баланс +5", Styles.tooltipLabel, antiShot);
        AttackButton antiChop = new AttackButton(BattleAtlasLoader.btn_hit2, BattleAtlasLoader.sel_hit2, BattleAtlasLoader.over_hit2, BattleAtlasLoader.btn_hit2, 4, this.battleId);
        antiChop.setActive(true);
        new SimpleTooltip("Сильный контрудар: Энергия +5, Баланс -15", Styles.tooltipLabel, antiChop);
        AttackButton btnBlock = new AttackButton(BattleAtlasLoader.btn_block, BattleAtlasLoader.sel_block, BattleAtlasLoader.over_block, BattleAtlasLoader.btn_block, 5, this.battleId);
        btnBlock.setActive(true);
        new SimpleTooltip("Блок: Энергия +15, Баланс +15", Styles.tooltipLabel, btnBlock);
        AttackButton btnDodge = new AttackButton(BattleAtlasLoader.btn_dodge, BattleAtlasLoader.sel_dodge, BattleAtlasLoader.over_dodge, BattleAtlasLoader.btn_dodge, 6, this.battleId);
        btnDodge.setActive(true);
        new SimpleTooltip("Уворот: Энергия -10, Баланс -10", Styles.tooltipLabel, btnDodge);
        AttackButton btnRest = new AttackButton(BattleAtlasLoader.btn_dodge, BattleAtlasLoader.sel_dodge, BattleAtlasLoader.over_dodge, BattleAtlasLoader.btn_dodge, 7, this.battleId);
        btnRest.setActive(true);
        new SimpleTooltip("Отдых: Энергия -40, Баланс -40", Styles.tooltipLabel, btnRest);
        this.attackButtonsGroup.addActor(btnShot);
        this.attackButtonsGroup.addActor(btnChop);
        this.attackButtonsGroup.addActor(antiShot);
        this.attackButtonsGroup.addActor(antiChop);
        this.attackButtonsGroup.addActor(btnBlock);
        this.attackButtonsGroup.addActor(btnDodge);
        this.attackButtonsGroup.addActor(btnRest);
        btnShot.setPosition(0.0F, 0.0F);
        btnChop.setPosition(40.0F, 0.0F);
        antiShot.setPosition(90.0F, 0.0F);
        antiChop.setPosition(130.0F, 0.0F);
        btnBlock.setPosition(180.0F, 0.0F);
        btnDodge.setPosition(220.0F, 0.0F);
        btnRest.setPosition(260.0F, 0.0F);
    }

    public void close() {
        this.remove();
    }
}

