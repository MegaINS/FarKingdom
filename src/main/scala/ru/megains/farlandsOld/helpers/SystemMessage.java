package ru.megains.farlandsOld.helpers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.loaders.ElementsAtlasLoader;
import ru.megains.farlandsOld.shop.countWindowGroup.BtnOkay;

public class SystemMessage extends Window {
    public SystemMessage(String title, String text) {
        super(title, Styles.guiSkin);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        this.setBounds(400.0F, 240.0F, 180.0F, 120.0F);
        BtnOkay btnOkay = new BtnOkay(ElementsAtlasLoader.btn_ok, ElementsAtlasLoader.sel_ok, ElementsAtlasLoader.over_ok, ElementsAtlasLoader.dis_ok);
        btnOkay.setActive(true);
        this.add(text);
        this.row();
        btnOkay.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                SystemMessage.this.addAction(Actions.removeActor());
                return true;
            }
        });
        this.add(btnOkay).padBottom(5.0F);
        this.pack();
    }
}
