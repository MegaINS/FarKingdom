package ru.megains.farlandsOld.battle.arena;

import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.BattleAtlasLoader;

public class BtnInBattle extends MyButton {
    private ArenaWindowInsiders arena;

    public BtnInBattle(ArenaWindowInsiders arena) {
        super(BattleAtlasLoader.btn_fight, BattleAtlasLoader.sel_fight, BattleAtlasLoader.over_fight, BattleAtlasLoader.dis_fight);
        this.arena = arena;
    }

    protected void clickAction() {
        this.arena.startBattle();
    }
}
