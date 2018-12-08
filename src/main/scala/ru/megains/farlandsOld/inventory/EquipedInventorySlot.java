package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.ArmorEquipedAtlasLoader;
import ru.megains.farlandsOld.loaders.ItemLayersAtlasLoader;
import ru.megains.farlandsOld.loaders.ItemsAtlasLoader;
import ru.megains.farlandsOld.tooltip.ItemTooltip;

public class EquipedInventorySlot extends Stack {
    private Item item;
    private int id;
    private MyActor bg;
    private MyActor itemActor;
    private int w;
    private int h;
    private MyActor selected;

    public EquipedInventorySlot(int id, int w, int h, EquipInventoryActor inventory) {
        this.id = id;
        this.w = w;
        this.h = h;
        this.selected = new MyActor(ItemLayersAtlasLoader.selected_equip);
        this.addActor(this.selected);
        this.selected.setVisible(false);
        this.addListener(new EquipSlotClickListener(this, inventory));
        this.item = null;
    }

    public EquipedInventorySlot(int id, EquipInventoryActor inventory) {
        this.id = id;
        this.w = 88;
        this.h = 96;
        this.selected = new MyActor(ItemLayersAtlasLoader.selected_equip);
        this.addActor(this.selected);
        this.selected.setVisible(false);
        this.addListener(new EquipSlotClickListener(this, inventory));
        this.item = null;
    }

    public boolean equip(Item item) {
        this.equipItem(item);
        return true;
    }

    private void equipItem(Item item) {
        this.item = item;
        this.bg = new MyActor(ItemLayersAtlasLoader.getItemLayer(item.getItemClass(), false));
        if (!item.getItemTag().equals("armor") && !item.getItemTag().equals("minearmor")) {
            this.itemActor = new MyActor(ItemsAtlasLoader.getItem(item.getImageId()));
            this.bg.trim(this.w, this.h);
            this.itemActor.trim(this.w, this.h);
        } else {
            this.itemActor = new MyActor(ArmorEquipedAtlasLoader.getItem(item.getImageId()));
        }

        this.add(this.bg);
        this.add(this.itemActor);
        new ItemTooltip(this, item);
    }

    public void takeOff() {
        if (this.item != null) {
            this.bg.addAction(Actions.removeActor());
            this.itemActor.addAction(Actions.removeActor());
            this.item = null;
            this.selected.addAction(Actions.removeActor());
        }

    }

    public int getSlotId() {
        return this.id;
    }

    public void select() {
        this.selected.setVisible(true);
        this.selected.toFront();
    }

    public Item getItem() {
        return this.item;
    }

    public void wasClicked(int clickedSlotId) {
        if (this.id == clickedSlotId) {
            this.selected.setVisible(true);
            this.selected.toFront();
        } else {
            this.selected.setVisible(false);
        }

    }
}

