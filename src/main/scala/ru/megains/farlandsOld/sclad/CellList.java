package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

import java.util.ArrayList;

public class CellList extends Group {
    private ArrayList<SkladCellRow> cellList;
    private ScrollPane pane;
    private Table cellsTable = (new Table()).left().top();
    private long cellSelected = -1L;

    public CellList() {
        this.pane = new ScrollPane(this.cellsTable, Styles.guiSkin);
        this.pane.setWidth(400.0F);
        this.pane.setHeight(450.0F);
        this.pane.setFadeScrollBars(false);
        this.pane.setFlickScroll(true);
        this.pane.setOverscroll(false, false);
        this.cellsTable.setBackground(new SpriteDrawable(UserInfoAtlasLoader.bgsimple));
        this.cellList = new ArrayList();
        this.addActor(this.pane);
        Label titleLabel = new Label("ЯЧЕЙКИ ИГРОКА", Styles.labelBlack);
        this.addActor(titleLabel);
        titleLabel.setPosition(100.0F, this.pane.getHeight() + 10.0F);
    }

    public void load(ArrayList<SkladCellRow> cellList) {
        this.clear();
        this.cellList = cellList;

        for(int i = 0; i < cellList.size(); ++i) {
            this.cellsTable.add((Actor)cellList.get(i));
            this.cellsTable.row();
        }

    }

    public void clear() {
        this.cellsTable.clear();
        this.cellList = null;
    }

    public void selectCell(long cellId) {
        this.cellSelected = cellId;

        for(int i = 0; i < this.cellList.size(); ++i) {
            ((SkladCellRow)this.cellList.get(i)).click(cellId);
        }

    }

    public long getSelected() {
        return this.cellSelected;
    }
}

