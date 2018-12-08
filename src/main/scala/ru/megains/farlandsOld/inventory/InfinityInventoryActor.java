package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.SkillsAtlasLoader;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class InfinityInventoryActor extends ScrollPane implements InventoryListener {
    private Table table;
    private PlayerInventory inventory;
    private int w;
    private long slotSelected = -1L;
    private LinkedList<InfinityInventorySlot> slots;

    public InfinityInventoryActor(int w, int h, PlayerInventory inventory, Table table) {
        super(table);
        this.table = table;
        this.inventory = inventory;
        this.w = w;
        this.slots = new LinkedList();
        table.setBackground(new SpriteDrawable(SkillsAtlasLoader.bg));
        this.setBounds(0.0F, 0.0F, (float)w, (float)h);
        this.setFadeScrollBars(false);
        this.setFlickScroll(true);
        this.setOverscroll(false, false);
        inventory.addListener(this);
        this.rePaint();
    }

    public void rePaint() {
        this.table.clear();

        for(int i = 0; i < this.slots.size(); ++i) {
            ((InfinityInventorySlot)this.slots.get(i)).remove();
        }

        this.slots.clear();
        Iterator var4 = this.inventory.getItemsList().entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<Long, Item> items = (Map.Entry)var4.next();
            InfinityInventorySlot slot = new InfinityInventorySlot((Item)items.getValue(), this, this.w);
            this.table.add(slot);
            this.slots.add(slot);
            this.table.row();
        }

    }

    public void selectSlot(long sloiId) {
        this.slotSelected = sloiId;

        for(int i = 0; i < this.slots.size(); ++i) {
            ((InfinityInventorySlot)this.slots.get(i)).click(sloiId);
        }

    }

    public long getselectedId() {
        return this.slotSelected;
    }

    public Item getItem(long itemMid) {
        return (Item)this.inventory.getItemsList().get(itemMid);
    }

    public PlayerInventory getInventory() {
        return this.inventory;
    }

    public Item getSelectedItem() {
        return this.slotSelected != -1L ? (Item)this.inventory.getItemsList().get(this.slotSelected) : null;
    }

    public void hasChanged() {
        long next = this.getNextSelected();
        this.rePaint();
        if (this.slotSelected != -1L && this.checkSelected(this.slotSelected)) {
            next = this.slotSelected;
        }

        this.selectSlot(next);
    }

    private long getNextSelected() {
        if (this.slotSelected == -1L) {
            return -1L;
        } else if (this.slots.size() == 1) {
            return this.slotSelected;
        } else {
            for(int i = 0; i < this.slots.size(); ++i) {
                if (((InfinityInventorySlot)this.slots.get(i)).getId() == this.slotSelected) {
                    if (i != this.slots.size() - 1) {
                        return ((InfinityInventorySlot)this.slots.get(i + 1)).getId();
                    }

                    if (i != 0) {
                        return ((InfinityInventorySlot)this.slots.get(i - 1)).getId();
                    }
                }
            }

            return -1L;
        }
    }

    private boolean checkSelected(long checkedIndex) {
        for(int i = 0; i < this.slots.size(); ++i) {
            if (((InfinityInventorySlot)this.slots.get(i)).getId() == checkedIndex) {
                return true;
            }
        }

        return false;
    }
}

