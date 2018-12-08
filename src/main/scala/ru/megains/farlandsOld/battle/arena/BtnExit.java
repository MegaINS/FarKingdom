package ru.megains.farlandsOld.battle.arena;

import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class BtnExit extends MyButton {
    private Gui gui;

    public BtnExit(Gui gui) {
        super(GuiAtlasLoader.btnEnter, GuiAtlasLoader.selEnter, GuiAtlasLoader.overEnter, GuiAtlasLoader.disEnter);
        this.gui = gui;
    }

    protected void clickAction() {
        this.gui.closeArena();
    }
}
