package ru.megains.farlandsOld.battle.arena;

import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.BattleAtlasLoader;

public class BtnCancel extends MyButton {
    private ArenaWindowInsiders arena;

    public BtnCancel(ArenaWindowInsiders arena) {
        super(BattleAtlasLoader.btn_cancel, BattleAtlasLoader.sel_cancel, BattleAtlasLoader.over_cancel, BattleAtlasLoader.dis_cancel);
        this.arena = arena;
    }

    protected void clickAction() {
        this.arena.sendCancelbattle();
    }
}
