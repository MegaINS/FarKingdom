package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.ShopAtlasLoader;

import java.util.ArrayList;

public class ClassButtonGroup extends ButtonsParentGroup {
    private Label allLabel;
    private MyActor txtClass;
    private MyActor bg_group1;
    private MyActor bg_group2;
    private int classSelected = -1;
    private ArrayList<MyClassButton> buttons = new ArrayList();
    private ShopButtonsGroup shop;

    public ClassButtonGroup(ShopButtonsGroup shop) {
        this.shop = shop;
        this.setActors();
    }

    private void setActors() {
        this.allLabel = new Label("ВСЕ ТОВАРЫ", Styles.labelBlack);
        this.txtClass = new MyActor(ShopAtlasLoader.txt_class);
        MyClassButton classAllBtn = new MyClassButton(ShopAtlasLoader.btn_class_all, ShopAtlasLoader.over_class_all, ShopAtlasLoader.sel_class_all, 0, this);
        MyClassButton class1Btn = new MyClassButton(ShopAtlasLoader.btn_class1, ShopAtlasLoader.over_class1, ShopAtlasLoader.sel_class1, 1, this);
        MyClassButton class2Btn = new MyClassButton(ShopAtlasLoader.btn_class2, ShopAtlasLoader.over_class2, ShopAtlasLoader.sel_class2, 2, this);
        MyClassButton class3Btn = new MyClassButton(ShopAtlasLoader.btn_class3, ShopAtlasLoader.over_class3, ShopAtlasLoader.sel_class3, 3, this);
        MyClassButton class4Btn = new MyClassButton(ShopAtlasLoader.btn_class4, ShopAtlasLoader.over_class4, ShopAtlasLoader.sel_class4, 4, this);
        MyClassButton class5Btn = new MyClassButton(ShopAtlasLoader.btn_class5, ShopAtlasLoader.over_class5, ShopAtlasLoader.sel_class5, 5, this);
        MyClassButton class6Btn = new MyClassButton(ShopAtlasLoader.btn_class6, ShopAtlasLoader.over_class6, ShopAtlasLoader.sel_class6, 6, this);
        MyClassButton class7Btn = new MyClassButton(ShopAtlasLoader.btn_class7, ShopAtlasLoader.over_class7, ShopAtlasLoader.sel_class7, 7, this);
        this.bg_group1 = new MyActor(ShopAtlasLoader.bg_group1);
        this.bg_group2 = new MyActor(ShopAtlasLoader.bg_group2);
        classAllBtn.setPosition(this.bg_group1.getWidth(), 0.0F);
        this.addActor(classAllBtn);
        class1Btn.setPosition(this.bg_group1.getWidth() + classAllBtn.getWidth(), 0.0F);
        this.addActor(class1Btn);
        class2Btn.setPosition(this.bg_group1.getWidth() + classAllBtn.getWidth() + class1Btn.getWidth(), 0.0F);
        this.addActor(class2Btn);
        class3Btn.setPosition(this.bg_group1.getWidth() + classAllBtn.getWidth() + class1Btn.getWidth() + class2Btn.getWidth(), 0.0F);
        this.addActor(class3Btn);
        class4Btn.setPosition(this.bg_group1.getWidth() + classAllBtn.getWidth() + class1Btn.getWidth() + class2Btn.getWidth() + class3Btn.getWidth(), 0.0F);
        this.addActor(class4Btn);
        class5Btn.setPosition(this.bg_group1.getWidth() + classAllBtn.getWidth() + class1Btn.getWidth() + class2Btn.getWidth() + class3Btn.getWidth() + class4Btn.getWidth(), 0.0F);
        this.addActor(class5Btn);
        class6Btn.setPosition(this.bg_group1.getWidth() + classAllBtn.getWidth() + class1Btn.getWidth() + class2Btn.getWidth() + class3Btn.getWidth() + class4Btn.getWidth() + class6Btn.getWidth(), 0.0F);
        this.addActor(class6Btn);
        class7Btn.setPosition(this.bg_group1.getWidth() + classAllBtn.getWidth() + class1Btn.getWidth() + class2Btn.getWidth() + class3Btn.getWidth() + class4Btn.getWidth() + class6Btn.getWidth() + class6Btn.getWidth(), 0.0F);
        this.addActor(class7Btn);
        this.buttons.add(classAllBtn);
        this.buttons.add(class1Btn);
        this.buttons.add(class2Btn);
        this.buttons.add(class3Btn);
        this.buttons.add(class4Btn);
        this.buttons.add(class5Btn);
        this.buttons.add(class6Btn);
        this.buttons.add(class7Btn);
        this.txtClass.setPosition(55.0F, 34.0F);
        this.addActor(this.txtClass);
        this.allLabel.setPosition(75.0F, 49.0F);
        this.addActor(this.allLabel);
        this.click(0);
    }

    public void click(int buttonId) {
        this.classSelected = buttonId;

        for(int i = 0; i < this.buttons.size(); ++i) {
            ((MyClassButton)this.buttons.get(i)).click(buttonId);
        }

        this.shop.selectClass();
    }

    public int getNameGroupSelected() {
        return 0;
    }

    public int getSelectedClass() {
        return this.classSelected;
    }
}

