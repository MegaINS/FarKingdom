package ru.megains.farlandsOld.gui.guileft;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.BtnRest;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class GuiLeftDown extends Group {
    private MyActor bgItems;
    private MyActor bgItems2;
    private MyActor bgStatsButtons;
    private MyActor overEnter;
    private MyActor disEnter;
    private BtnCenter btnCenter;
    private BtnRest btnRest;
    private int width = 104;
    private BtnEnter btnEnter;

    public GuiLeftDown() {
        this.bgItems2 = new MyActor(GuiAtlasLoader.bgItems2);
        this.bgItems2.setPosition(0.0F, 0.0F);
        this.btnCenter = new BtnCenter();
        this.btnCenter.setActive(true);
        this.btnCenter.setPosition(70.0F, 22.0F);
        this.disEnter = new MyActor(GuiAtlasLoader.disEnter);
        this.disEnter.setPosition(8.0F, 14.0F);
        this.btnRest = new BtnRest(GuiAtlasLoader.btn_rest, GuiAtlasLoader.sel_rest, GuiAtlasLoader.over_rest, GuiAtlasLoader.dis_rest);
        this.btnRest.setPosition(120.0F, 14.0F);
        this.btnRest.setActive(true);
        this.btnEnter = new BtnEnter(new SpriteDrawable(GuiAtlasLoader.btnEnter), new SpriteDrawable(GuiAtlasLoader.overEnter));
        this.btnEnter.setPosition(8.0F, 14.0F);
        this.addActor(this.bgItems2);
        this.addActor(this.btnCenter);
        this.addActor(this.disEnter);
        this.addActor(this.btnRest);
        this.addActor(this.btnEnter);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    public int getWidthManual() {
        return this.width;
    }

    public BtnEnter getBtnEnter() {
        return this.btnEnter;
    }

    public BtnRest getBtnRest() {
        return this.btnRest;
    }
}

