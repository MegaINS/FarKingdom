package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.guileft.GuiLeft;
import ru.megains.farlandsOld.inventory.profile.ProfileTab;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

import java.util.LinkedList;

public class InventoryWindow extends Window {
    private EquipInventoryActor equipInventory;
    private InfinityInventoryActor inventoryActor;
    private PlayerInventory inventory;
    private GuiLeft guiLeft;
    private LinkedList<InventoryWindowClickListener> listeners = new LinkedList();
    private DropCountWindow countWindow;
    private Group inventoryButtonsGroup;
    private ProfileTab profileTab;

    public InventoryWindow(PlayerInventory inventory, EquipedInventory equipedInventory) throws ParseException {
        super("Информация об игроке", Styles.guiSkin);
        this.setVisible(false);
        this.setPosition(400.0F, 100.0F);
        this.setSize(595.0F, 560.0F);
        MyActor bg = new MyActor(UserInfoAtlasLoader.bg);
        bg.setPosition(0.0F, 0.0F);
        bg.setWidth(595.0F);
        this.addActor(bg);
        TextButton closeButton = new TextButton("X", Styles.guiSkin);
        closeButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                InventoryWindow.this.setVisible(false);
            }
        });
        this.getTitleTable().add(closeButton).size(20.0F, 20.0F).padRight(10.0F).padTop(0.0F);
        this.setMovable(true);
        this.profileTab = new ProfileTab();
        this.profileTab.setPosition(171.0F, 10.0F);
        this.addActor(this.profileTab);
        this.inventory = inventory;
        this.equipInventory = new EquipInventoryActor(equipedInventory);
        this.equipInventory.setPosition(0.0F, 10.0F);
        this.addActor(this.equipInventory);
        this.guiLeft = new GuiLeft(true, Const.game.getGame().getPlayer().getParameters(), Const.game.getGame().getPlayer().getMoney());
        this.guiLeft.setPosition(0.0F, 345.0F);
        this.addActor(this.guiLeft);
        this.inventoryActor = new InfinityInventoryActor(400, 430, inventory, (new Table()).left().top());
        this.inventoryActor.setPosition(180.0F, 50.0F);
        this.addActor(this.inventoryActor);
        InfoButton infoButton = new InfoButton(this);
        infoButton.setPosition(482.0F, 500.0F);
        this.addActor(infoButton);
        LogButton logButton = new LogButton(this);
        logButton.setPosition(376.0F, 500.0F);
        this.addActor(logButton);
        ProfileButton profileButton = new ProfileButton(this);
        profileButton.setPosition(180.0F, 500.0F);
        this.addActor(profileButton);
        ItemButton itemButton = new ItemButton(this);
        itemButton.setPosition(300.0F, 500.0F);
        this.addActor(itemButton);
        this.inventoryButtonsGroup = new Group();
        this.inventoryButtonsGroup.setPosition(185.0F, 20.0F);
        BtnWear btnWear = new BtnWear(this);
        btnWear.setPosition(0.0F, 0.0F);
        this.inventoryButtonsGroup.addActor(btnWear);
        BtnTakeOff btnTakeOff = new BtnTakeOff(this);
        btnTakeOff.setPosition(81.0F, 0.0F);
        this.inventoryButtonsGroup.addActor(btnTakeOff);
        BtnUse btnUse = new BtnUse(this);
        btnUse.setPosition(163.0F, 0.0F);
        this.inventoryButtonsGroup.addActor(btnUse);
        BtnDrop btnDrop = new BtnDrop(this);
        btnDrop.setPosition(295.0F, 0.0F);
        this.inventoryButtonsGroup.addActor(btnDrop);
        this.addActor(this.inventoryButtonsGroup);
        this.showInventoryTab();
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                InventoryWindow.this.notifyListeners();
                return true;
            }
        });
    }

    public void openCountWindow(long itemId, int count) {
        if (this.countWindow != null) {
            this.countWindow.addAction(Actions.removeActor());
        }

        this.countWindow = new DropCountWindow(count, itemId);
        this.countWindow.setPosition(100.0F, 100.0F);
        this.addActor(this.countWindow);
    }

    public void loadProfileAndSkills(JSONObject profileJson) {
        this.profileTab.loadProfileAndSkills(profileJson);
    }

    public PlayerInventory getInventory() {
        return this.inventory;
    }

    public InfinityInventoryActor getInfinityInventoryActor() {
        return this.inventoryActor;
    }

    public EquipInventoryActor getEquipInventory() {
        return this.equipInventory;
    }

    public GuiLeft getGuiLeft() {
        return this.guiLeft;
    }

    public void notifyListeners() {
        for(int i = 0; i < this.listeners.size(); ++i) {
            ((InventoryWindowClickListener)this.listeners.get(i)).hasChange();
        }

    }

    public void addListener(InventoryWindowClickListener listener) {
        this.listeners.add(listener);
    }

    public void showProfileTab() {
        this.inventoryActor.setVisible(false);
        this.inventoryButtonsGroup.setVisible(false);
        this.profileTab.setVisible(true);
        this.profileTab.setPosition(169.0F, 10.0F);
        SendPasket.getProfile(Const.game.getGame().getPlayer().getId(), true);
    }

    public void showInventoryTab() {
        this.profileTab.setVisible(false);
        this.inventoryActor.setVisible(true);
        this.inventoryButtonsGroup.setVisible(true);
        this.inventoryActor.rePaint();
    }
}

