package ru.megains.farlandsOld.gui.guileft;


import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class BtnAcceptStats extends MyButton {
    private FreeStats freeStats;

    public BtnAcceptStats(FreeStats freeStats) {
        super(GuiAtlasLoader.btn_apply, GuiAtlasLoader.sel_apply, GuiAtlasLoader.over_apply, GuiAtlasLoader.dis_apply);
        this.freeStats = freeStats;
    }

    protected void clickAction() {
        this.freeStats.apply();
    }
}

