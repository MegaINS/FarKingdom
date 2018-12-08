package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.StoreAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnTake extends ImageButton {
    public BtnTake(final SkladWindow skladWindow) {
        super(new SpriteDrawable(StoreAtlasLoader.btn_remove));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                skladWindow.closeCountWindow();
                long selected = skladWindow.getSkladCellActor().getselectedId();
                if (selected >= 0L) {
                    Item item = skladWindow.getSkladCellActor().getItem(selected);
                    if (item == null) {
                        return true;
                    }

                    if (item.getCount() == 1) {
                        System.out.println("BtnTake: item count = 1 ");
                        SendPasket.takeItemFromSclad(selected, skladWindow.getSkladId(), skladWindow.getSkladCellActor().getCellId(), 1);
                        return true;
                    }

                    skladWindow.openCountWindow(selected, false);
                }

                return true;
            }
        });
    }
}
