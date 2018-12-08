package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.StoreAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnAdd extends ImageButton implements CountedButton {
    private CountedButton btnAdd = this;

    public BtnAdd(final SkladWindow skladWindow) {
        super(new SpriteDrawable(StoreAtlasLoader.btn_add));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                skladWindow.closeCountWindow();
                long selected = skladWindow.getInventory().getselectedId();
                if (selected >= 0L) {
                    Item item = skladWindow.getInventory().getItem(selected);
                    if (item == null) {
                        return true;
                    }

                    if (item.getCount() == 1) {
                        SendPasket.putItemToSclad(selected, skladWindow.getSkladId(), skladWindow.getSkladCellActor().getCellId(), 1);
                        return true;
                    }

                    skladWindow.openCountWindow(selected, true);
                }

                return true;
            }
        });
    }

    public void click(long itemId, int count) {
    }
}

