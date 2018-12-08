package ru.megains.farlandsOld.gui.guitop;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class ButtonLog extends ImageButton {
    public ButtonLog() {
        super(new SpriteDrawable(GuiAtlasLoader.btn_log), new SpriteDrawable(GuiAtlasLoader.over_log));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }
}

