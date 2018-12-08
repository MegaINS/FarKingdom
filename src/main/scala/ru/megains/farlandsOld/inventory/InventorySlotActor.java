package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.ItemLayersAtlasLoader;
import ru.megains.farlandsOld.loaders.ItemsAtlasLoader;
import ru.megains.farlandsOld.tooltip.ItemTooltip;

public class InventorySlotActor extends WidgetGroup {
    private MyActor bg;
    private MyActor itemImage;
    private MyActor itemBg;
    private ItemHealth itemBar;

    public InventorySlotActor(Item item) {
        this.bg = new MyActor(ItemLayersAtlasLoader.getItemLayer(item.getItemClass(), false));
        this.bg.setY(-19.0F);
        this.addActor(this.bg);
        this.itemImage = new MyActor(ItemsAtlasLoader.getItem(item.getImageId()));
        this.itemImage.setY(-18.0F);
        this.addActor(this.itemImage);
        this.itemBg = new MyActor(ItemLayersAtlasLoader.item_bg);
        this.itemBg.setY(-28.0F);
        this.addActor(this.itemBg);
        this.itemBar = new ItemHealth(ItemLayersAtlasLoader.item_bar, item);
        this.itemBar.setY(-28.0F);
        this.addActor(this.itemBar);
        new ItemTooltip(this, item);
    }

    public class ItemHealth extends Group {
        private float wearMax;
        private float wearCurent;
        private float basePercent = 0.49F;
        private float wearPercent;
        private MyActor line;
        private Item item;

        public ItemHealth(Sprite point, Item item) {
            this.item = item;
            this.line = new MyActor(point);
            this.wearMax = item.getMaxLife();
            this.wearCurent = item.getLife();
            this.wearPercent = 100.0F * this.wearCurent / this.wearMax;
            this.addActor(this.line);
            this.line.setPosition(38.0F, 11.0F);
            this.line.setWidth(this.wearPercent * this.basePercent);
        }

        public void act(float delta) {
            super.act(delta);
            if (this.item.getLife() >= 0.0F) {
                this.wearPercent = 100.0F * this.item.getLife() / this.wearMax;
                this.line.setWidth(this.wearPercent * this.basePercent);
            }

        }

        public void setWearCurent(float wear) {
            this.wearCurent = wear;
        }
    }
}
