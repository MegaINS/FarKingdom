package ru.megains.farlandsOld.gui;


import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.MyButton;

public class BtnRest extends MyButton {
    public BtnRest(Sprite imageUp, Sprite imageDown, Sprite imageOver, Sprite disActiv) {
        super(imageUp, imageDown, imageOver, disActiv);
    }

    protected void clickAction() {
        if (!Const.game.getGame().getPlayer().isBlocked()) {
            Const.game.getGame().getPlayer().startRest();
            this.setActive(false);
        }
    }
}
