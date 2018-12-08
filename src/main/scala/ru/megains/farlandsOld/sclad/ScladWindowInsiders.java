package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.gui.guileft.GuiLeft;
import ru.megains.farlandsOld.inventory.EquipInventoryActor;
import ru.megains.farlandsOld.inventory.InfinityInventoryActor;
import ru.megains.farlandsOld.inventory.PlayerInventory;
import ru.megains.farlandsOld.loaders.StoreAtlasLoader;

import java.util.ArrayList;

public class ScladWindowInsiders extends Group {
    private EquipInventoryActor equipInventory;
    private GuiLeft guiLeft;
    private Group leftGroup;
    private PlayerInventory cellInventory = null;
    private InfinityInventoryActor inventory = null;
    private SkladCellActor scladCellActor = null;
    private CellList cellList = null;
    private SkladServicesGroup skladServicesGroup;
    private BtnAdd btnAdd;
    private BtnTake btnTake;
    private Label curentLabel;
    private Label totalLabel;
    private CountWindow countWindow;
    private int skladId;
    private Gui gui;
    private SkladWindow skladWindow;

    public ScladWindowInsiders(Gui gui, int skladId, SkladWindow skladWindow) throws ParseException {
        this.skladWindow = skladWindow;
        this.equipInventory = new EquipInventoryActor(Const.game.getGame().getPlayer().getEquipped());
        this.guiLeft = new GuiLeft(true, Const.game.getGame().getPlayer().getParameters(), Const.game.getGame().getPlayer().getMoney());
        this.leftGroup = new Group();
        this.leftGroup.addActor(this.guiLeft);
        this.leftGroup.addActor(this.equipInventory);
        this.equipInventory.setPosition(0.0F, 0.0F);
        this.guiLeft.setPosition(0.0F, 335.0F);
        this.addActor(this.leftGroup);
        this.gui = gui;
        this.skladId = skladId;
        this.addCellList();
        this.addButtons();
        this.setEquiped();
    }

    public void loadCellList(JSONObject list) throws ParseException {
        if (this.cellList == null) {
            this.addCellList();
        }

        JSONArray cells = (JSONArray)list.get("cells");
        ArrayList<SkladCellRow> cellList = new ArrayList();

        for(int i = 0; i < cells.size(); ++i) {
            JSONArray tempCells = (JSONArray)cells.get(i);
            cellList.add(new SkladCellRow((Long)tempCells.get(0), (String)tempCells.get(1), ((Double)tempCells.get(2)).floatValue(), ((Long)tempCells.get(3)).intValue(), this.cellList));
        }

        this.cellList.load(cellList);
    }

    public void setEquiped() {
        this.leftGroup.setPosition(5.0F, 30.0F);
    }

    private void addCellList() {
        if (this.cellList != null) {
            this.removeActor(this.cellList);
            this.cellList = null;
        }

        this.cellList = new CellList();
        this.cellList.setPosition(195.0F, 10.0F);
        this.addActor(this.cellList);
        if (this.skladServicesGroup != null) {
            this.removeActor(this.skladServicesGroup);
            this.skladServicesGroup = null;
        }

        this.skladServicesGroup = new SkladServicesGroup(this.skladWindow, this.skladId);
        this.skladServicesGroup.setPosition(615.0F, 290.0F);
        this.addActor(this.skladServicesGroup);
    }

    private void removeCellList() {
        if (this.cellList != null) {
            this.removeActor(this.cellList);
            this.cellList = null;
        }

        if (this.skladServicesGroup != null) {
            this.removeActor(this.skladServicesGroup);
            this.skladServicesGroup = null;
        }

    }

    private void addButtons() {
        BtnOpen btnOpen = new BtnOpen(this.skladWindow);
        btnOpen.setPosition(this.skladServicesGroup.getX() + 20.0F, this.skladServicesGroup.getY() - 20.0F);
        this.addActor(btnOpen);
    }

    public void openScladCell(JSONObject jsonData) throws ParseException {
        this.removeCellList();
        if (this.cellInventory == null) {
            this.cellInventory = new PlayerInventory();
        }

        this.cellInventory.clearInventory();
        if (this.inventory == null) {
            this.inventory = new InfinityInventoryActor(400, 450, Const.game.getGame().getPlayer().getInventory(), (new Table()).left().top());
            this.inventory.setPosition(195.0F, 30.0F);
        }

        long cellId = (Long)jsonData.get("cellid");
        this.cellInventory.load((JSONArray)jsonData.get("items"));
        this.scladCellActor = new SkladCellActor(400, 450, cellId, this.cellInventory, (new Table()).left().top());
        this.scladCellActor.setPosition(600.0F, 30.0F);
        this.addActor(this.scladCellActor);
        this.addActor(this.inventory);
        this.btnAdd = new BtnAdd(this.skladWindow);
        this.btnTake = new BtnTake(this.skladWindow);
        this.btnAdd.setPosition(500.0F, 0.0F);
        this.btnTake.setPosition(620.0F, 0.0F);
        this.addActor(this.btnAdd);
        this.addActor(this.btnTake);
        Group weightGroup = new Group();
        Label freeLabel = new Label("Занято (кг)", Styles.labelYellow);
        weightGroup.addActor(freeLabel);
        freeLabel.setPosition(0.0F, 0.0F);
        Label izLabel = new Label("из", Styles.labelYellow);
        weightGroup.addActor(izLabel);
        izLabel.setPosition(130.0F, 0.0F);
        MyActor bgCurentActor = new MyActor(StoreAtlasLoader.bg_type_count);
        weightGroup.addActor(bgCurentActor);
        bgCurentActor.setPosition(85.0F, 0.0F);
        bgCurentActor.setWidth(40.0F);
        MyActor bgTotalActor = new MyActor(StoreAtlasLoader.bg_type_count);
        weightGroup.addActor(bgTotalActor);
        bgTotalActor.setPosition(149.0F, 0.0F);
        bgTotalActor.setWidth(40.0F);
        this.curentLabel = new Label("" + ((Double)jsonData.get("curentweight")).floatValue(), Styles.labelYellow);
        weightGroup.addActor(this.curentLabel);
        this.curentLabel.setPosition(105.0F - this.curentLabel.getWidth() / 2.0F, 0.0F);
        this.totalLabel = new Label("" + ((Long)jsonData.get("maxweight")).intValue(), Styles.labelYellow);
        weightGroup.addActor(this.totalLabel);
        this.totalLabel.setPosition(169.0F - this.totalLabel.getWidth() / 2.0F, 0.0F);
        weightGroup.setPosition(750.0F, 0.0F);
        this.addActor(weightGroup);
        BtnBack btnBack = new BtnBack(this.skladWindow, this.skladId);
        btnBack.setPosition(910.0F, 490.0F);
        this.addActor(btnBack);
    }

    private void closeSkladCell() {
        if (this.scladCellActor != null) {
            this.removeActor(this.scladCellActor);
            this.cellInventory = null;
            this.scladCellActor = null;
        }

        if (this.inventory != null) {
            this.removeActor(this.inventory);
            this.inventory = null;
        }

        if (this.btnTake != null) {
            this.removeActor(this.btnTake);
            this.btnTake = null;
        }

        if (this.btnAdd != null) {
            this.removeActor(this.btnAdd);
            this.btnAdd = null;
        }

    }

    public void openCountWindow(long itemMid, boolean put) {
        if (this.countWindow != null) {
            this.countWindow.addAction(Actions.removeActor());
        }

        this.countWindow = new CountWindow(this.skladWindow, itemMid, put);
        this.countWindow.setPosition(400.0F, 240.0F);
        this.addActor(this.countWindow);
    }

    public void closeCountWindow() {
        if (this.countWindow != null) {
            this.countWindow.addAction(Actions.removeActor());
        }

    }

    public SkladCellActor getScladCellActor() {
        return this.scladCellActor;
    }

    public CellList getCellList() {
        return this.cellList;
    }

    public InfinityInventoryActor getInventory() {
        return this.inventory;
    }
}
