package ru.megains.farlandsOld.gui.guitop;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class ButtonProfile extends ImageButton {
    public ButtonProfile() {
        super(new SpriteDrawable(GuiAtlasLoader.btn_profile), new SpriteDrawable(GuiAtlasLoader.over_profile));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (Const.game.getGui().getInventoryWindow().isVisible()) {
                    Const.game.getGui().getInventoryWindow().setVisible(false);
                } else {
                    Const.game.getGui().getInventoryWindow().setVisible(true);
                    Const.game.getGui().getInventoryWindow().showProfileTab();
                }

                return true;
            }
        });
    }
}

