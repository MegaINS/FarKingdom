package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import ru.megains.farlandsOld.gameobjects.MyActor;

public class MyGroupNameButton extends MyActor {
    private ButtonsParentGroup classButtonGroup;
    private int id;
    private boolean checked = false;
    private Sprite imageUp;
    private Sprite imageDown;
    private Sprite imageChecked;
    private MyTypeButtonGroup buttonGroup;

    public MyGroupNameButton(final Sprite imageUp, final Sprite imageDown, Sprite imageChecked, MyTypeButtonGroup buttonGroup, final int id, final ButtonsParentGroup classButtonGroup) {
        super(imageUp);
        this.imageUp = imageUp;
        this.imageDown = imageDown;
        this.imageChecked = imageChecked;
        this.buttonGroup = buttonGroup;
        this.id = id;
        this.classButtonGroup = classButtonGroup;
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (!MyGroupNameButton.this.checked) {
                    classButtonGroup.click(id);
                }

                return true;
            }
        });
        this.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!MyGroupNameButton.this.checked) {
                    MyGroupNameButton.this.setSprite(imageDown);
                }

            }
        });
        this.addListener(new InputListener() {
            public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!MyGroupNameButton.this.checked) {
                    MyGroupNameButton.this.setSprite(imageUp);
                }

            }
        });
    }

    public void clickChildren(int buttonId) {
        if (this.id == buttonId) {
            this.check(true);
            this.setSprite(this.imageChecked);
            this.buttonGroup.setVisible(true);
            this.buttonGroup.click(this.buttonGroup.getButtonSelected());
        } else {
            this.check(false);
            this.setSprite(this.imageUp);
            this.buttonGroup.setVisible(false);
        }

    }

    public void check(boolean checked) {
        this.checked = checked;
    }
}

