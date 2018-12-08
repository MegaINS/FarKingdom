package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnTakeOff extends ImageButton {
    EquipInventoryActor inventory;

    public BtnTakeOff(InventoryWindow inventoryWindow) {
        super(new SpriteDrawable(UserInfoAtlasLoader.btn_takeoff), new SpriteDrawable(UserInfoAtlasLoader.sel_takeoff));
        this.inventory = inventoryWindow.getEquipInventory();
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int selected = BtnTakeOff.this.inventory.getSelectedSlotId();
                if (selected > 0) {
                    SendPasket.takeOffItem(selected);
                }

                return true;
            }
        });
    }
}

