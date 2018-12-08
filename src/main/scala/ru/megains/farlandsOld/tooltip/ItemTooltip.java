package ru.megains.farlandsOld.tooltip;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.inventory.item.ItemAttribute;
import ru.megains.farlandsOld.loaders.ItemLayersAtlasLoader;
import ru.megains.farlandsOld.loaders.ItemsAtlasLoader;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class ItemTooltip extends Table {
    private Actor targetActor;
    private SimpleTooltipListener listener;
    private Item item;
    private Label.LabelStyle labelWhite;
    private static final int padLeft = 5;
    private static final int padRight = 5;

    public ItemTooltip(Actor targetActor, Item item) {
        this.labelWhite = Styles.labelWhite11;
        this.targetActor = targetActor;
        this.item = item;
        this.setTouchable(Touchable.disabled);
        this.setBackground(new SpriteDrawable(new Sprite(UserInfoAtlasLoader.bgtooltip)));
        this.top();
        this.listener = new SimpleTooltipListener(this, true);
        this.listener.setOffset(50.0F, -60.0F);
        this.drawTooltip();
        targetActor.addListener(this.listener);
    }

    private void drawTooltip() {
        this.clear();
        this.add(new MyActor(ItemLayersAtlasLoader.bg_1_info)).center().colspan(2);
        this.row();
        this.add(new Label(this.item.getName(), this.labelWhite)).colspan(2);
        this.row();
        this.add(new MyActor(ItemLayersAtlasLoader.line_info)).colspan(2);
        this.row();
        Stack image = new Stack();
        image.add(new MyActor(ItemLayersAtlasLoader.getItemLayer(this.item.getItemClass(), false)));
        image.add(new MyActor(ItemsAtlasLoader.getItem(this.item.getImageId())));
        this.add(image).colspan(2);
        this.row();
        this.add(new MyActor(ItemLayersAtlasLoader.line_info)).colspan(2);
        this.row();
        this.add(new Label("Класс:", this.labelWhite)).left().padLeft(5.0F);
        this.add(new Label(String.valueOf(this.item.getItemClass()), this.labelWhite)).right().padRight(5.0F);
        this.row();
        String money;
        if (this.item.iseZet()) {
            money = "eZ";
        } else {
            money = "z";
        }

        this.add(new Label("Цена (" + money + "):", this.labelWhite)).left().padLeft(5.0F);
        this.add(new Label(String.valueOf(this.item.getPrice()), this.labelWhite)).right().padRight(5.0F);
        this.row();
        this.add(new Label("Вес:", this.labelWhite)).left().padLeft(5.0F);
        this.add(new Label(String.valueOf(this.item.getWeight()), this.labelWhite)).right().padRight(5.0F);
        this.row();
        this.add(new Label("Износ:", this.labelWhite)).left().padLeft(5.0F);
        this.add(new Label(String.valueOf(this.item.getLife() + "/" + this.item.getMaxLife()), this.labelWhite)).right().padRight(5.0F);
        this.row();
        this.add(new Label("", Styles.labelBlack)).colspan(2);
        this.row();
        String dmg;
        if (this.item.attributeExist("dmg")) {
            dmg = String.valueOf(this.item.getAttributeByName("dmg").getIntegerValue());
            if (this.item.attributeExist("dmgrange")) {
                dmg = dmg + " - " + (this.item.getAttributeByName("dmg").getIntegerValue() + this.item.getAttributeByName("dmgrange").getIntegerValue());
            }

            this.add(new Label("Урон:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(dmg, this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("def")) {
            this.add(new Label("Броня:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("def").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("minedmg")) {
            dmg = String.valueOf(this.item.getAttributeByName("minedmg").getIntegerValue());
            if (this.item.attributeExist("minedmg")) {
                dmg = dmg + " - " + (this.item.getAttributeByName("minedmg").getIntegerValue() + this.item.getAttributeByName("minedmgrange").getIntegerValue());
            }

            this.add(new Label("Урон при добыче:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(dmg, this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("minedef")) {
            this.add(new Label("Броня при добыче:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("minedef").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("crit")) {
            this.add(new Label("Крит:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("crit").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("anticrit")) {
            this.add(new Label("Антикрит:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("anticrit").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("strenght")) {
            this.add(new Label("Сила:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("strenght").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("stamina")) {
            this.add(new Label("Выносливость:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("stamina").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("conc")) {
            this.add(new Label("Концентрация:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("conc").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("int")) {
            this.add(new Label("Интеллект:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("int").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("life")) {
            this.add(new Label("Жизнь:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("life").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("energy")) {
            this.add(new Label("Энергия:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("energy").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("equilibrium")) {
            this.add(new Label("Равновесие:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("equilibrium").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        if (this.item.attributeExist("carryng")) {
            this.add(new Label("Грузоподъемность:", this.labelWhite)).left().padLeft(5.0F);
            this.add(new Label(String.valueOf(this.item.getAttributeByName("carryng").getIntegerValue()), this.labelWhite)).right().padRight(5.0F);
            this.row();
        }

        this.add(new Label("", Styles.labelBlack)).colspan(2);
        this.row();
        this.add(new MyActor(ItemLayersAtlasLoader.line_info)).colspan(2);
        this.row();
        this.add(new Label("", Styles.labelBlack)).colspan(2);
        this.row();
        if (this.item.attributeExist(ItemAttribute.ATT_ONE_HEND)) {
            boolean onehead = this.item.getAttributeByName(ItemAttribute.ATT_ONE_HEND).getBooleanValue();
            if (onehead) {
                this.add(new Label("Одноручное", this.labelWhite)).left().padLeft(5.0F);
            } else {
                this.add(new Label("Двуручное", this.labelWhite)).left().padLeft(5.0F);
            }

            this.row();
        }

        this.pack();
        this.setHeight(this.getHeight() + 20.0F);
    }

    public void act(float delta) {
        super.act(delta);
        if (this.targetActor == null) {
            this.remove();
        }

        if (this.targetActor != null && this.targetActor.getStage() == null) {
            this.remove();
        }

    }
}

