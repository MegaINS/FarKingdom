package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import ru.megains.farlandsOld.inventory.item.Item;

public class InfinityInventorySlot extends Table {
    private InventorySlotActor slotActor;
    private InventorySlotActorInfo slotActorInfo;
    private InfinityInventoryActor inventoryActor;
    private int w;
    private long id;

    public InfinityInventorySlot(Item item, InfinityInventoryActor inventoryActor, int w) {
        this.setTouchable(Touchable.enabled);
        this.id = item.getId();
        this.w = w;
        this.inventoryActor = inventoryActor;
        this.slotActor = new InventorySlotActor(item);
        this.slotActorInfo = new InventorySlotActorInfo(item);
        this.add(this.slotActor).padLeft(2.0F).padTop(1.0F).left().width(88.0F);
        this.add(this.slotActorInfo).left().width((float)(w - 88 - 15));
        this.setListener();
    }

    private void setListener() {
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                InfinityInventorySlot.this.inventoryActor.selectSlot(InfinityInventorySlot.this.id);
                return true;
            }
        });
    }

    public void click(Long slotId) {
        if (this.id == slotId) {
            this.slotActorInfo.select(true);
        } else {
            this.slotActorInfo.select(false);
        }

    }

    public long getId() {
        return this.id;
    }
}

