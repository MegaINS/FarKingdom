package ru.megains.farlandsOld.inventory;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class ItemButton extends ImageButton {
    public ItemButton(final InventoryWindow inventory) {
        super(new SpriteDrawable(UserInfoAtlasLoader.btn_inventory), new SpriteDrawable(UserInfoAtlasLoader.sel_inventory));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                inventory.showInventoryTab();
                return true;
            }
        });
    }
}
