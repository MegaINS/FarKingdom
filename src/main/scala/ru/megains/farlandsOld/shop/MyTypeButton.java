package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.net.SendPasket;

public class MyTypeButton extends MyActor {
    private Sprite imageUp;
    private Sprite imageDown;
    private Sprite imageChecked;
    private String itemTag;
    private String subTag;
    private int id;
    private boolean checked = false;
    private int locId;

    public MyTypeButton(final Sprite imageUp, final Sprite imageDown, Sprite imageChecked, final int id, String itemTag, String subTag, final ButtonsParentGroup typeButtonGroup) {
        super(imageUp);
        this.id = id;
        this.imageUp = imageUp;
        this.imageDown = imageDown;
        this.imageChecked = imageChecked;
        this.itemTag = itemTag;
        this.subTag = subTag;
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (!MyTypeButton.this.checked) {
                    typeButtonGroup.click(id);
                }

                return true;
            }
        });
        this.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!MyTypeButton.this.checked) {
                    MyTypeButton.this.setSprite(imageDown);
                }

            }
        });
        this.addListener(new InputListener() {
            public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!MyTypeButton.this.checked) {
                    MyTypeButton.this.setSprite(imageUp);
                }

            }
        });
    }

    public void click(int id, int itemClass) {
        if (this.isVisible()) {
            if (this.id == id) {
                this.check(true);
                super.setSprite(this.imageChecked);
                SendPasket.loadShopInventory(this.locId, itemClass, this.itemTag, this.subTag);
            } else {
                this.check(false);
                this.setSprite(this.imageUp);
            }

        }
    }

    public void check(boolean checked) {
        this.checked = checked;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }
}

