package ru.megains.farlandsOld.gui.guileft;

import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class BtnCenter extends MyButton {
    public BtnCenter() {
        super(GuiAtlasLoader.btn_center, GuiAtlasLoader.btn_center, GuiAtlasLoader.over_center, GuiAtlasLoader.dis_center);
    }

    protected void clickAction() {
        Const.game.getGame().centerCam();
    }
}
