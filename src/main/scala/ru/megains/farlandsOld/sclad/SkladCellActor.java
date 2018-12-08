package ru.megains.farlandsOld.sclad;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import ru.megains.farlandsOld.inventory.InfinityInventoryActor;
import ru.megains.farlandsOld.inventory.PlayerInventory;

public class SkladCellActor extends InfinityInventoryActor {
    private long cellId;
    private BtnBack btnBack;

    public SkladCellActor(int w, int h, long cellId, PlayerInventory inventory, Table table) {
        super(w, h, inventory, table);
        this.cellId = cellId;
    }

    public long getCellId() {
        return this.cellId;
    }
}
