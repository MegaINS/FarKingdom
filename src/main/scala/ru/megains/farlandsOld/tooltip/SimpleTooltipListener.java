package ru.megains.farlandsOld.tooltip;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SimpleTooltipListener extends InputListener {
    private boolean inside;
    private Actor tooltip;
    private boolean followCursor;
    private Vector2 position = new Vector2();
    private Vector2 tmp = new Vector2();
    private Vector2 offset = new Vector2(10.0F, 5.0F);

    public SimpleTooltipListener(Actor tooltip, boolean followCursor) {
        this.tooltip = tooltip;
        this.followCursor = followCursor;
    }

    public boolean mouseMoved(InputEvent event, float x, float y) {
        if (this.inside && this.followCursor) {
            this.updateTooltipPosition(event, x, y);
        }

        return false;
    }

    public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        this.inside = true;
        event.getStage().addActor(this.tooltip);
        this.tooltip.setVisible(true);
        this.tooltip.toFront();
        this.updateTooltipPosition(event, x, y);
    }

    private void updateTooltipPosition(InputEvent event, float x, float y) {
        event.getListenerActor().localToStageCoordinates(this.tmp.set(x, y));
        this.tooltip.setPosition(this.tmp.x + this.position.x + this.offset.x, this.tmp.y + this.position.y + this.offset.y);
    }

    public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        this.inside = false;
        this.tooltip.setVisible(false);
        this.tooltip.remove();
    }

    public void setOffset(float offsetX, float offsetY) {
        this.offset.set(offsetX, offsetY);
    }
}

