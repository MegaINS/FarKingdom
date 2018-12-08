package ru.megains.farlandsOld.gui.guibottom.playersList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import ru.megains.farlandsOld.base.Fonts;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.guibottom.BtnPlayerInfo;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class PlayerNodeTable extends Table {
    BtnFight btnFight;

    public PlayerNodeTable(long id, String name, int level, boolean isClan) {
        this.left().top();
        Label.LabelStyle style = new Label.LabelStyle();
        style.fontColor = Color.BLACK;
        style.font = Fonts.ARIAL_12_WHITE.get();
        this.add(new BtnPlayerInfo(id)).left().top();
        MyActor clan;
        if (isClan) {
            clan = new MyActor(GuiAtlasLoader.group);
        } else {
            clan = new MyActor(GuiAtlasLoader.dis_group);
        }

        this.add(clan).left().top();
        this.btnFight = new BtnFight(id);
        this.add(this.btnFight).left().top();
        this.add(new Label(" ", style)).left().top().left().top();
        this.add(new Label(name + " [" + level + "]", style)).left().top();
    }

    public void setNeighbor() {
        this.btnFight.setActive(true);
    }
}
