package ru.megains.farlandsOld.gameobjects.mainmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.megains.farlandsOld.base.Const;

public class BtnExitMenu extends ImageButton {
    public BtnExitMenu(Drawable imageUp, Drawable imageDown) {
        super(imageUp, imageDown);
        this.setPosition(340.0F, 100.0F);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (Const.channel != null && Const.channel.isOpen()) {
                    Const.channel.close();
                }

                Gdx.app.exit();
                return true;
            }
        });
    }
}
