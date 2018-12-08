package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.ItemLayersAtlasLoader;

public class InventorySlotActorInfo extends Table {
    private SpriteDrawable back;
    private SpriteDrawable selectedBack;

    public InventorySlotActorInfo(Item item) {
        this.setTouchable(Touchable.enabled);
        this.left();
        this.defaults().padLeft(10.0F).top();
        this.align(10);
        this.back = new SpriteDrawable(ItemLayersAtlasLoader.getInfoLayer(item.getItemClass(), false));
        this.selectedBack = new SpriteDrawable(ItemLayersAtlasLoader.getInfoLayer(item.getItemClass(), true));
        this.setBackground(this.back);
        this.add(new InfoItemClass(item)).left().top().padLeft(3.0F).padTop(2.0F);
        this.setWidth(58.0F);
    }

    public void select(boolean sel) {
        if (sel) {
            this.setBackground(this.selectedBack);
        } else {
            this.setBackground(this.back);
        }

    }

    public class InfoItemClass extends Group {
        public InfoItemClass(Item item) {
            Label classNum = new Label("Класс " + item.getItemClass(), Styles.labelGreen);
            Label price = new Label("" + item.getPrice(), Styles.labelYellow);
            Label itemName = new Label(item.getName(), Styles.labelYellow);
            MyActor coin = new MyActor(ItemLayersAtlasLoader.coin);
            MyActor weightActor;
            if (item.getItemTag().equals("weapon")) {
                weightActor = new MyActor(ItemLayersAtlasLoader.att_damage);
                weightActor.setPosition(150.0F, -44.0F);
                this.addActor(weightActor);
            }

            if (item.getItemTag().equals("armor")) {
                weightActor = new MyActor(ItemLayersAtlasLoader.att_defence);
                weightActor.setPosition(150.0F, -44.0F);
                this.addActor(weightActor);
            }

            weightActor = new MyActor(ItemLayersAtlasLoader.bg_item_weight);
            Label weightLabel = new Label("" + item.getWeight(), Styles.guiSkin);
            weightActor.setPosition(230.0F, -44.0F);
            weightLabel.setPosition(243.0F, -44.0F);
            this.addActor(weightActor);
            this.addActor(weightLabel);
            Label countLabel = new Label(item.getCount() + "шт", Styles.labelYellow);
            countLabel.setPosition(243.0F, -14.0F);
            this.addActor(countLabel);
            classNum.setPosition(0.0F, -29.0F);
            price.setPosition(20.0F, -44.0F);
            coin.setPosition(0.0F, -44.0F);
            itemName.setPosition(0.0F, -14.0F);
            this.addActor(classNum);
            this.addActor(coin);
            this.addActor(price);
            this.addActor(itemName);
        }
    }
}

