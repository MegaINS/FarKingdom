package ru.megains.farlandsOld.gui.guitop;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class GuiTop extends Group {
    private Group back = new Group();
    private Group title;
    private MyActor titleLeft;
    private MyActor titleRight;
    private MyActor titleCenter;
    private Label label;
    private ButtonProfile btnProfile;
    private ButtonInventory btnInventory;
    private ButtonLog btnLog;
    private ButtonInfo btnInfo;

    public GuiTop(Gui gui) {
        this.addActor(this.back);
        this.title = new Group();
        this.titleLeft = new MyActor(GuiAtlasLoader.bg_title1);
        this.titleCenter = new MyActor(GuiAtlasLoader.bg_title2);
        this.titleRight = new MyActor(GuiAtlasLoader.bg_title3);
        this.title.addActor(this.titleLeft);
        this.title.addActor(this.titleCenter);
        this.titleCenter.setPosition(26.0F, 0.0F);
        this.titleCenter.setWidth(200.0F);
        this.title.addActor(this.titleRight);
        this.titleRight.setPosition(26.0F + this.titleCenter.getWidth(), 0.0F);
        this.label = new Label("", Styles.labelYellow);
        this.title.addActor(this.label);
        this.label.setWidth(this.titleCenter.getWidth() + 52.0F);
        this.label.setPosition(0.0F, 13.0F);
        this.label.setAlignment(1);
        this.btnProfile = new ButtonProfile();
        this.btnInventory = new ButtonInventory();
        this.btnLog = new ButtonLog();
        this.btnInfo = new ButtonInfo();
        this.addActor(this.title);
        this.addActor(this.btnProfile);
        this.addActor(this.btnInventory);
        this.addActor(this.btnLog);
        this.addActor(this.btnInfo);
    }

    public void resize(int w, int h) {
        if (this.back.getChildren().size <= w / 168) {
            MyActor bg = new MyActor(GuiAtlasLoader.bg);
            this.back.addActor(bg);
            bg.setZIndex(1);
            this.resize(w, h);
        } else {
            this.drawBg(w);
        }
    }

    private void drawBg(int w) {
        for(int i = 0; i < this.back.getChildren().size; ++i) {
            ((Actor)this.back.getChildren().get(i)).setPosition((float)(i * 168), 0.0F);
        }

        this.title.setPosition((float)(w / 2) - (26.0F + this.titleCenter.getWidth() / 2.0F), 0.0F);
        this.title.setZIndex(10);
        this.btnProfile.setPosition(10.0F, 3.0F);
        this.btnProfile.setZIndex(14);
        this.btnInventory.setPosition(100.0F, 3.0F);
        this.btnInventory.setZIndex(14);
        this.btnLog.setPosition(165.0F, 3.0F);
        this.btnLog.setZIndex(14);
        this.btnInfo.setPosition(245.0F, 3.0F);
        this.btnInfo.setZIndex(14);
    }

    public void setTitle(String newTitle) {
        this.label.setText(newTitle);
    }
}

