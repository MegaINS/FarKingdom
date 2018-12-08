package ru.megains.farlandsOld.inventory;


import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnDrop extends MyButton implements InventoryWindowClickListener {
    private InventoryWindow inventoryWindow;

    public BtnDrop(InventoryWindow inventoryWindow) {
        super(UserInfoAtlasLoader.btn_drop, UserInfoAtlasLoader.sel_drop, UserInfoAtlasLoader.over_drop, UserInfoAtlasLoader.dis_drop);
        this.inventoryWindow = inventoryWindow;
        inventoryWindow.addListener(this);
    }

    public void hasChange() {
        if (this.inventoryWindow.getInfinityInventoryActor().getSelectedItem() != null) {
            this.setActive(true);
        } else {
            this.setActive(false);
        }

    }

    protected void clickAction() {
        Item item = this.inventoryWindow.getInfinityInventoryActor().getSelectedItem();
        if (item != null) {
            long id = item.getId();
            if (id != 0L) {
                if (item.getCount() == 1) {
                    SendPasket.dropItem(id, 1);
                } else {
                    this.inventoryWindow.openCountWindow(id, item.getCount());
                }
            }

        }
    }
}
