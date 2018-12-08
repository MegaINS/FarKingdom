package ru.megains.farlandsOld.inventory;


import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnUse extends MyButton implements InventoryWindowClickListener {
    private InventoryWindow inventoryWindow;

    public BtnUse(InventoryWindow inventoryWindow) {
        super(UserInfoAtlasLoader.btn_use, UserInfoAtlasLoader.sel_use, UserInfoAtlasLoader.over_use, UserInfoAtlasLoader.dis_use);
        this.inventoryWindow = inventoryWindow;
        inventoryWindow.addListener(this);
    }

    protected void clickAction() {
        long id = this.inventoryWindow.getInfinityInventoryActor().getSelectedItem().getId();
        if (id != 0L) {
            SendPasket.useItem(id);
        }

    }

    public void hasChange() {
        if (this.inventoryWindow.getInfinityInventoryActor().getSelectedItem() != null && this.inventoryWindow.getInfinityInventoryActor().getSelectedItem().isUsable()) {
            this.setActive(true);
        } else {
            this.setActive(false);
        }

    }
}

