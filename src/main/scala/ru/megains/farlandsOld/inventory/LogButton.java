package ru.megains.farlandsOld.inventory;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class LogButton extends ImageButton {
    public LogButton(InventoryWindow inventory) {
        super(new SpriteDrawable(UserInfoAtlasLoader.btn_log), new SpriteDrawable(UserInfoAtlasLoader.sel_log));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }
}