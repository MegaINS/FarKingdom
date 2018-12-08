package ru.megains.farlandsOld.inventory;


import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnWear extends MyButton implements InventoryWindowClickListener {
    private InventoryWindow inventoryWindow;

    public BtnWear(InventoryWindow inventoryWindow) {
        super(UserInfoAtlasLoader.btn_wear, UserInfoAtlasLoader.sel_wear, UserInfoAtlasLoader.over_wear, UserInfoAtlasLoader.dis_wear);
        this.inventoryWindow = inventoryWindow;
        inventoryWindow.addListener(this);
    }

    protected void clickAction() {
        long selected = this.inventoryWindow.getInfinityInventoryActor().getselectedId();
        if (selected >= 0L) {
            SendPasket.equipItem(selected);
        }

    }

    public void hasChange() {
        if (this.inventoryWindow.getInfinityInventoryActor().getSelectedItem() != null) {
            String itemTag = this.inventoryWindow.getInfinityInventoryActor().getSelectedItem().getItemTag();
            if (!itemTag.equals("minetool") && !itemTag.equals("crafttool") && !itemTag.equals("minearmor") && !itemTag.equals("weapon") && !itemTag.equals("armor") && !itemTag.equals("bots") && !itemTag.equals("bracers") && !itemTag.equals("earring") && !itemTag.equals("head") && !itemTag.equals("necklace") && !itemTag.equals("ring") && !itemTag.equals("sheild")) {
                this.setActive(false);
            } else {
                this.setActive(true);
            }
        } else {
            this.setActive(false);
        }

    }
}

