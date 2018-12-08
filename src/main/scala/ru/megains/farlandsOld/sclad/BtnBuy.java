package ru.megains.farlandsOld.sclad;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.StoreAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnBuy extends ImageButton {
    public BtnBuy(final int weight, final int scladId) {
        super(new SpriteDrawable(StoreAtlasLoader.btn_buy));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                SendPasket.buyScladCell(weight, scladId);
                return true;
            }
        });
    }
}
