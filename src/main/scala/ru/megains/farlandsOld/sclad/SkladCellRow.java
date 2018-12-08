package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.StoreAtlasLoader;

public class SkladCellRow extends Group {
    private long id;
    private String name;
    private float weigh;
    private int maxWeight;
    private CellList cellList;
    private MyActor leftBg;
    private MyActor middleBg;
    private MyActor rightBg;
    private boolean selected = false;

    public SkladCellRow(long id, String name, float weight, int maxWeight, CellList cellList) {
        this.id = id;
        this.name = name;
        this.weigh = weight;
        this.maxWeight = maxWeight;
        this.cellList = cellList;
        Label cellName = new Label(name, Styles.labelWhite11);
        cellName.setPosition(10.0F, 5.0F);
        Label cellWeight = new Label("" + weight + " / " + maxWeight, Styles.labelWhite11);
        cellWeight.setPosition(312.0F, 5.0F);
        this.leftBg = new MyActor(StoreAtlasLoader.cell_bg1);
        this.addActor(this.leftBg);
        this.middleBg = new MyActor(StoreAtlasLoader.cell_bg2);
        this.middleBg.setPosition(29.0F, 0.0F);
        this.middleBg.setWidth(196.0F);
        this.addActor(this.middleBg);
        this.rightBg = new MyActor(StoreAtlasLoader.cell_bg3);
        this.rightBg.setPosition(225.0F, 0.0F);
        this.addActor(this.rightBg);
        this.addActor(cellName);
        this.addActor(cellWeight);
        this.setHeight(this.middleBg.getHeight());
        this.setListener();
    }

    public void click(long id) {
        if (id == this.id && !this.selected) {
            this.selected = true;
            this.leftBg.setSprite(StoreAtlasLoader.cell_sel_bg1);
            this.middleBg.setSprite(StoreAtlasLoader.cell_sel_bg2);
            this.rightBg.setSprite(StoreAtlasLoader.cell_sel_bg3);
        } else if (id != this.id && this.selected) {
            this.selected = false;
            this.leftBg.setSprite(StoreAtlasLoader.cell_bg1);
            this.middleBg.setSprite(StoreAtlasLoader.cell_bg2);
            this.rightBg.setSprite(StoreAtlasLoader.cell_bg3);
        }
    }

    private void setListener() {
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                SkladCellRow.this.cellList.selectCell(SkladCellRow.this.id);
                return true;
            }
        });
    }
}
