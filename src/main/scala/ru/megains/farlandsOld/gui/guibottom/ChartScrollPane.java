package ru.megains.farlandsOld.gui.guibottom;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ChartScrollPane extends ScrollPane {
    public ChartScrollPane(Table table, Skin skin) {
        super(table, skin);
    }

    public void update() {
        this.scrollY(this.getMaxY() + 20.0F);
    }
}
