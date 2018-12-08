package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import ru.megains.farlandsOld.gameobjects.MyActor;

public class MyClassButton extends MyActor {
    private ButtonsParentGroup classButtonGroup;
    private int id;
    private boolean checked = false;
    private Sprite imageUp;
    private Sprite imageDown;
    private Sprite imageChecked;

    public MyClassButton(final Sprite imageUp, final Sprite imageDown, Sprite imageChecked, final int id, final ButtonsParentGroup classButtonGroup) {
        super(imageUp);
        this.classButtonGroup = classButtonGroup;
        this.id = id;
        this.imageUp = imageUp;
        this.imageDown = imageDown;
        this.imageChecked = imageChecked;
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (!MyClassButton.this.checked) {
                    classButtonGroup.click(id);
                }

                return true;
            }
        });
        this.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!MyClassButton.this.checked) {
                    MyClassButton.this.setSprite(imageDown);
                }

            }
        });
        this.addListener(new InputListener() {
            public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!MyClassButton.this.checked) {
                    MyClassButton.this.setSprite(imageUp);
                }

            }
        });
    }

    public void click(int id) {
        if (this.id == id) {
            this.check(true);
            super.setSprite(this.imageChecked);
        } else {
            this.check(false);
            this.setSprite(this.imageUp);
        }

    }

    public void check(boolean checked) {
        this.checked = checked;
    }
}

