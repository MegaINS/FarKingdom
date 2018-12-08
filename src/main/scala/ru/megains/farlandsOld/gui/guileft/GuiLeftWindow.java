package ru.megains.farlandsOld.gui.guileft;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import ru.megains.farlandsOld.base.Const;

public class GuiLeftWindow extends Table {
    private Actor actor;
    GuiLeft guiLeft;
    GuiLeftDown guiLeftDown;

    public GuiLeftWindow() {
        this.guiLeft = new GuiLeft(false, Const.game.getGame().getPlayer().getParameters(), Const.game.getGame().getPlayer().getMoney());
        this.guiLeftDown = new GuiLeftDown();
        this.actor = this;
        this.addActor(this.guiLeftDown);
        this.addActor(this.guiLeft);
        this.guiLeft.setPosition(0.0F, 104.0F);
        this.addListener(new DragListener() {
            public void drag(InputEvent event, float x, float y, int pointer) {
                GuiLeftWindow.this.actor.setPosition(GuiLeftWindow.this.actor.getX() + (float) Gdx.input.getDeltaX(), GuiLeftWindow.this.actor.getY() - (float) Gdx.input.getDeltaY());
            }
        });
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    public GuiLeft getGuiLeft() {
        return this.guiLeft;
    }

    public GuiLeftDown getGuiLeftDown() {
        return this.guiLeftDown;
    }
}

