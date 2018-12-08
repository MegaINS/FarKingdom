package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.StoreAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnOpen extends ImageButton {
    private SkladWindow skladWindow;

    public BtnOpen(final SkladWindow skladWindow) {
        super(new SpriteDrawable(StoreAtlasLoader.btn_open));
        this.skladWindow = skladWindow;
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                long selected = skladWindow.getCellList().getSelected();
                if (selected >= 0L) {
                    System.out.println("" + selected);
                    SendPasket.openScladCell(selected, skladWindow.getSkladId());
                }

                return true;
            }
        });
    }
}

