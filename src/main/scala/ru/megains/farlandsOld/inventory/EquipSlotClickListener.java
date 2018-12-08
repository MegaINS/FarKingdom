package ru.megains.farlandsOld.inventory;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class EquipSlotClickListener extends InputListener {
    private EquipedInventorySlot slot;
    private EquipInventoryActor inventory;

    public EquipSlotClickListener(EquipedInventorySlot slot, EquipInventoryActor inventory) {
        this.slot = slot;
        this.inventory = inventory;
    }

    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        this.inventory.selectSlot(this.slot);
        return true;
    }
}