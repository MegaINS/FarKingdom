package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.battle.arena.BtnExit;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.gui.guileft.GuiLeft;
import ru.megains.farlandsOld.inventory.EquipInventoryActor;
import ru.megains.farlandsOld.inventory.InfinityInventoryActor;
import ru.megains.farlandsOld.loaders.ShopAtlasLoader;
import ru.megains.farlandsOld.sclad.CountedButton;
import ru.megains.farlandsOld.shop.countWindowGroup.CountWindow;

public class ShopWindowInsiders extends WidgetGroup {
    private Gui gui;
    private ShopButtonsGroup tbg;
    private EquipInventoryActor equipInventory;
    private GuiLeft guiLeft;
    private Group leftGroup;
    private InfinityInventoryActor inventory = null;
    private CountWindow countWindow;

    public ShopWindowInsiders(Gui gui, int locId) throws ParseException {
        this.gui = gui;
        this.setShopBounds();
        this.equipInventory = new EquipInventoryActor(Const.game.getGame().getPlayer().getEquipped());
        this.guiLeft = new GuiLeft(true, Const.game.getGame().getPlayer().getParameters(), Const.game.getGame().getPlayer().getMoney());
        this.leftGroup = new Group();
        this.leftGroup.addActor(this.guiLeft);
        this.leftGroup.addActor(this.equipInventory);
        this.equipInventory.setPosition(0.0F, 0.0F);
        this.guiLeft.setPosition(0.0F, 335.0F);
        this.addActor(this.leftGroup);
        this.tbg = new ShopButtonsGroup(locId);
        this.tbg.setPosition(615.0F, 50.0F);
        this.addActor(this.tbg);
        this.setInventory();
        BtnSell btnSell = new BtnSell(new SpriteDrawable(ShopAtlasLoader.btn_sell), new SpriteDrawable(ShopAtlasLoader.sel_sell), locId, this.inventory, this);
        BtnBuy btnBuy = new BtnBuy(new SpriteDrawable(ShopAtlasLoader.btn_buy), new SpriteDrawable(ShopAtlasLoader.sel_buy), locId, this.tbg.getShopInventoryActor(), this);
        btnSell.setPosition(420.0F, 10.0F);
        btnBuy.setPosition(640.0F, 10.0F);
        this.addActor(btnSell);
        this.addActor(btnBuy);
        BtnExit btnExit = new BtnExit(gui);
        btnExit.setPosition(955.0F, 410.0F);
        this.addActor(btnExit);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    private void setShopBounds() {
        this.setWidth((float) Gdx.graphics.getWidth());
        this.setHeight((float)(Gdx.graphics.getHeight() - 25 - 37 - 5) - this.gui.getSplitPane().getHeight());
        this.setPosition(0.0F, this.gui.getSplitPane().getHeight() + 37.0F + 5.0F);
    }

    private void setInventory() {
        if (this.inventory == null) {
            this.inventory = new InfinityInventoryActor(400, 450, Const.game.getGame().getPlayer().getInventory(), (new Table()).left().top());
            this.inventory.setPosition(195.0F, 50.0F);
            this.addActor(this.inventory);
        }

    }

    public void loadShopInventory(JSONArray items) throws ParseException {
        this.tbg.getShopInventoryActor().getInventory().load(items);
    }

    public void openCountWindow(CountedButton countedButton, long itemId) {
        if (this.countWindow != null) {
            this.countWindow.addAction(Actions.removeActor());
        }

        this.countWindow = new CountWindow(countedButton, itemId, this);
        this.addActor(this.countWindow);
    }

    public void closeCountWindow() {
        if (this.countWindow != null) {
            this.countWindow.addAction(Actions.removeActor());
        }

    }

    public ShopButtonsGroup getTbg() {
        return this.tbg;
    }
}
