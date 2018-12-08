package ru.megains.farlandsOld.shop;

import com.badlogic.gdx.scenes.scene2d.Group;

public abstract class ButtonsParentGroup extends Group {
    public ButtonsParentGroup() {
    }

    public abstract void click(int var1);

    public abstract int getNameGroupSelected();
}

