package ru.megains.farlandsOld.gui.guibottom;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.megains.farlandsOld.gui.Gui;

public class BtnClear extends ImageButton {
    public BtnClear(Drawable imageUp, Drawable imageDown, final Gui gui) {
        super(imageUp, imageDown);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gui.getChartTable().clearMessages();
                return true;
            }
        });
    }
}