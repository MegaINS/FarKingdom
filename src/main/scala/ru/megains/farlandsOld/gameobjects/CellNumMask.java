package ru.megains.farlandsOld.gameobjects;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.loaders.DangeAtlasLoader;

public class CellNumMask extends Group {
    private MyActor mask;
    private Label num;

    public CellNumMask(int num) {
        this.mask = new MyActor(DangeAtlasLoader.mask5);
        this.num = new Label("" + num, Styles.labelYellow);
        this.addActor(this.mask);
        this.num.setPosition(45.0F, 20.0F);
        this.addActor(this.num);
    }
}