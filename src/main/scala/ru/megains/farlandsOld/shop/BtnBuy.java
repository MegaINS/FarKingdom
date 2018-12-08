package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.megains.farlandsOld.inventory.InfinityInventoryActor;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.net.SendPasket;
import ru.megains.farlandsOld.sclad.CountedButton;

public class BtnBuy extends ImageButton implements CountedButton {
    private int locId;
    private CountedButton btnBuy = this;

    public BtnBuy(Drawable imageUp, Drawable imageDown, int locId, final InfinityInventoryActor inventoryActor, final ShopWindowInsiders shopWindow) {
        super(imageUp, imageDown);
        this.locId = locId;
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                shopWindow.closeCountWindow();
                if (inventoryActor.getselectedId() >= 0L) {
                    if (((Item)inventoryActor.getInventory().getItemsList().get(inventoryActor.getselectedId())).getCount() != 1 && ((Item)inventoryActor.getInventory().getItemsList().get(inventoryActor.getselectedId())).isStacked()) {
                        shopWindow.openCountWindow(BtnBuy.this.btnBuy, inventoryActor.getselectedId());
                    } else {
                        BtnBuy.this.click(inventoryActor.getselectedId(), 1);
                    }
                }

                return true;
            }
        });
    }

    public void click(long itemId, int count) {
        SendPasket.buyItemInShop(this.locId, itemId, count);
    }
}

