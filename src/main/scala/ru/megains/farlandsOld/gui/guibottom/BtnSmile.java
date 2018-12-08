package ru.megains.farlandsOld.gui.guibottom;

import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class BtnSmile extends MyButton {
    private SmilesBox box;

    public BtnSmile(SmilesBox box) {
        super(GuiAtlasLoader.btnsmile, GuiAtlasLoader.selsmile, GuiAtlasLoader.oversmile, GuiAtlasLoader.dissmile);
        this.box = box;
        this.setActive(true);
    }

    protected void clickAction() {
        if (this.box.isVisible()) {
            this.box.setVisible(false);
        } else {
            this.box.setVisible(true);
        }

    }
}

