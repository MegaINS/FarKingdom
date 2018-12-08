package ru.megains.farlandsOld.gui.guibottom;

import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnPlayerInfo extends MyButton {
    private long playerId;

    public BtnPlayerInfo(long playerId) {
        super(GuiAtlasLoader.info, GuiAtlasLoader.info, GuiAtlasLoader.info, GuiAtlasLoader.info);
        this.setActive(true);
        this.playerId = playerId;
    }

    protected void clickAction() {
        boolean isMy = Const.game.getGame().getPlayer().getId() == this.playerId;
        SendPasket.getProfile(this.playerId, isMy);
    }
}
