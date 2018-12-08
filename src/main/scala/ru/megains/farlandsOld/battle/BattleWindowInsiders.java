package ru.megains.farlandsOld.battle;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.gui.guileft.EnemyGuiLeft;
import ru.megains.farlandsOld.gui.guileft.GuiLeft;
import ru.megains.farlandsOld.inventory.EquipInventoryActor;
import ru.megains.farlandsOld.inventory.EquipedInventory;

public class BattleWindowInsiders extends Group {
    private Gui gui;
    private GuiLeft guiLeft;
    private EnemyGuiLeft enemyGuiLeft;
    private Group leftGroup;
    private Group enemyLeftGroup;
    private EquipInventoryActor equipInventory;
    private EquipInventoryActor enemyEquipedInventory;
    private int battleId;
    private BattleLogTable battleTable = new BattleLogTable();
    private BarContainer barContainer = new BarContainer();
    ScrollPane pane;

    public BattleWindowInsiders(Gui gui, int battleId, int round, JSONObject enemyParameters, JSONObject enemyEquiped, String enemyName) throws ParseException {
        this.gui = gui;
        this.battleId = battleId;
        this.equipInventory = new EquipInventoryActor(Const.game.getGame().getPlayer().getEquipped());
        this.guiLeft = new GuiLeft(true, Const.game.getGame().getPlayer().getParameters(), Const.game.getGame().getPlayer().getMoney());
        this.leftGroup = new Group();
        this.leftGroup.addActor(this.guiLeft);
        this.leftGroup.addActor(this.equipInventory);
        this.equipInventory.setPosition(0.0F, 0.0F);
        this.guiLeft.setPosition(0.0F, 335.0F);
        this.addActor(this.leftGroup);
        EquipedInventory ei = new EquipedInventory();
        ei.load(enemyEquiped);
        this.enemyEquipedInventory = new EquipInventoryActor(ei);
        int level = ((Long)enemyParameters.get("level")).intValue();
        int hpMax = ((Long)enemyParameters.get("hpMax")).intValue();
        int hpCurent = ((Long)enemyParameters.get("hpCurent")).intValue();
        int energyMax = ((Long)enemyParameters.get("energyMax")).intValue();
        int energyCurrent = ((Long)enemyParameters.get("energyCurrent")).intValue();
        int balanceMax = ((Long)enemyParameters.get("balanceMax")).intValue();
        int balanceCurent = ((Long)enemyParameters.get("balanceCurent")).intValue();
        float carringMax = ((Double)enemyParameters.get("carryingMax")).floatValue();
        float carringCurent = ((Double)enemyParameters.get("carryingCurent")).floatValue();
        int strenght = ((Long)enemyParameters.get("strenght")).intValue();
        int conc = ((Long)enemyParameters.get("conc")).intValue();
        int stamina = ((Long)enemyParameters.get("stamina")).intValue();
        int intellect = ((Long)enemyParameters.get("intellect")).intValue();
        this.enemyGuiLeft = new EnemyGuiLeft(true, level, hpMax, hpCurent, energyMax, energyCurrent, carringMax, carringCurent, strenght, conc, stamina, intellect, enemyName);
        this.enemyLeftGroup = new Group();
        this.enemyLeftGroup.addActor(this.enemyGuiLeft);
        this.enemyLeftGroup.addActor(this.enemyEquipedInventory);
        this.enemyEquipedInventory.setPosition(0.0F, 0.0F);
        this.enemyGuiLeft.setPosition(0.0F, 335.0F);
        this.addActor(this.enemyLeftGroup);
        this.pane = new ScrollPane(this.battleTable.left().top(), Styles.guiSkin);
        this.pane.setFadeScrollBars(false);
        this.pane.setOverscroll(false, true);
        this.pane.setScrollingDisabled(true, false);
        this.pane.setFadeScrollBars(false);
        this.pane.setFlickScroll(true);
        this.addActor(this.pane);
        this.addActor(this.barContainer);
        this.barContainer.update(round, Const.game.getGame().getPlayer().getParameters().getHpMax(), Const.game.getGame().getPlayer().getParameters().getHpCurent(), Const.game.getGame().getPlayer().getParameters().getEnergyMax(), Const.game.getGame().getPlayer().getParameters().getEnergyCurrent(), Const.game.getGame().getPlayer().getParameters().getBalanceMax(), Const.game.getGame().getPlayer().getParameters().getBalanceCurrent(), hpMax, hpCurent, energyMax, energyCurrent, balanceMax, balanceCurent);
    }

    public void resize() {
        int w = Gdx.graphics.getWidth();
        if (w < 1074) {
            w = 1054;
        }

        if (w > 1600) {
            w = 1600;
        }

        this.enemyLeftGroup.setPosition((float)(w - 194), 0.0F);
        this.pane.setWidth((float)(w - 418));
        this.pane.setHeight(500.0F);
        this.battleTable.setWidth((float)(w - 418));
        this.pane.setPosition(194.0F, -70.0F);
        this.barContainer.setPosition((float)(w / 2 - 200), 435.0F);
    }

    public void drawRound(int round, String playerStr, String enemyStr, JSONObject enemyParameters, JSONObject enemyEquiped) throws ParseException {
        this.battleTable.finishRound(round, playerStr, enemyStr);
        this.enemyEquipedInventory.getEquipedInventory().load(enemyEquiped);
        int level = ((Long)enemyParameters.get("level")).intValue();
        int hpMax = ((Long)enemyParameters.get("hpMax")).intValue();
        int hpCurent = ((Long)enemyParameters.get("hpCurent")).intValue();
        int energyMax = ((Long)enemyParameters.get("energyMax")).intValue();
        int energyCurrent = ((Long)enemyParameters.get("energyCurrent")).intValue();
        int balanceMax = ((Long)enemyParameters.get("balanceMax")).intValue();
        int balanceCurent = ((Long)enemyParameters.get("balanceCurent")).intValue();
        float carringMax = ((Double)enemyParameters.get("carryingMax")).floatValue();
        float carringCurent = ((Double)enemyParameters.get("carryingCurent")).floatValue();
        int strenght = ((Long)enemyParameters.get("strenght")).intValue();
        int conc = ((Long)enemyParameters.get("conc")).intValue();
        int stamina = ((Long)enemyParameters.get("stamina")).intValue();
        int intellect = ((Long)enemyParameters.get("intellect")).intValue();
        this.enemyGuiLeft.update(level, hpMax, hpCurent, energyMax, energyCurrent, carringMax, carringCurent, strenght, conc, stamina, intellect);
        this.barContainer.update(round, Const.game.getGame().getPlayer().getParameters().getHpMax(), Const.game.getGame().getPlayer().getParameters().getHpCurent(), Const.game.getGame().getPlayer().getParameters().getEnergyMax(), Const.game.getGame().getPlayer().getParameters().getEnergyCurrent(), Const.game.getGame().getPlayer().getParameters().getBalanceMax(), Const.game.getGame().getPlayer().getParameters().getBalanceCurrent(), hpMax, hpCurent, energyMax, energyCurrent, balanceMax, balanceCurent);
    }
}

