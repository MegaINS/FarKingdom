package ru.megains.farlandsOld.gameobjects;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public abstract class MyButton extends MyActor {
    private Sprite imageUp;
    private Sprite imageDown;
    private Sprite imageOver;
    private Sprite disActiv;
    private boolean active;

    public MyButton(final Sprite imageUp, Sprite imageDown, final Sprite imageOver, Sprite disActiv) {
        super(disActiv);
        this.imageUp = imageUp;
        this.imageDown = imageDown;
        this.imageOver = imageOver;
        this.disActiv = disActiv;
        this.active = false;
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (MyButton.this.active) {
                    MyButton.this.clickAction();
                }

                return true;
            }
        });
        this.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (MyButton.this.active) {
                    MyButton.this.setSprite(imageOver);
                }

            }
        });
        this.addListener(new InputListener() {
            public void exit(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (MyButton.this.active) {
                    MyButton.this.setSprite(imageUp);
                }

            }
        });
    }

    protected abstract void clickAction();

    public void setActive(boolean active) {
        this.active = active;
        if (active) {
            this.setSprite(this.imageUp);
        } else {
            this.setSprite(this.disActiv);
        }

    }
}

