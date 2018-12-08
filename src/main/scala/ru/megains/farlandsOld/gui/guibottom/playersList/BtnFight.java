package ru.megains.farlandsOld.gui.guibottom.playersList;

import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnFight extends MyButton {
    private long enemyId;

    public BtnFight(long enemyId) {
        super(GuiAtlasLoader.fight, GuiAtlasLoader.fight, GuiAtlasLoader.fight, GuiAtlasLoader.dis_fight);
        this.enemyId = enemyId;
    }

    protected void clickAction() {
        SendPasket.attackEnemy(this.enemyId);
    }
}