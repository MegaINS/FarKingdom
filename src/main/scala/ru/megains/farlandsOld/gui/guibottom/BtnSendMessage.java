package ru.megains.farlandsOld.gui.guibottom;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.megains.farlandsOld.base.Const;

public class BtnSendMessage extends ImageButton {
    public BtnSendMessage(Drawable imageUp, Drawable imageDown) {
        super(imageUp, imageDown);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Const.game.getGui().sendChartMessage();
                return true;
            }
        });
    }
}