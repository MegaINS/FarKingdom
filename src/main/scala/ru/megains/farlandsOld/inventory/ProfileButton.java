package ru.megains.farlandsOld.inventory;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class ProfileButton extends ImageButton {
    public ProfileButton(final InventoryWindow inventory) {
        super(new SpriteDrawable(UserInfoAtlasLoader.btn_profile), new SpriteDrawable(UserInfoAtlasLoader.sel_profile));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                inventory.showProfileTab();
                return true;
            }
        });
    }
}
