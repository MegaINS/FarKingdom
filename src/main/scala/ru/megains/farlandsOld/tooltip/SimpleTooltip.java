package ru.megains.farlandsOld.tooltip;


import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class SimpleTooltip extends Group {
    private Actor targetActor;
    private Actor targetActor2;
    private SimpleTooltipListener listener;
    private Label textLabel;
    private Label.LabelStyle style;

    public SimpleTooltip(CharSequence text, Label.LabelStyle style, Actor targetActor) {
        this.targetActor = targetActor;
        this.style = style;
        this.setTouchable(Touchable.disabled);
        this.textLabel = new Label(text, style);
        this.addActor(this.textLabel);
        this.listener = new SimpleTooltipListener(this, true);
        targetActor.addListener(this.listener);
    }

    public SimpleTooltip(CharSequence text, Label.LabelStyle style, Actor targetActor, Actor targetActor2) {
        this.targetActor = targetActor;
        this.targetActor2 = targetActor2;
        this.style = style;
        this.setTouchable(Touchable.disabled);
        this.textLabel = new Label(text, style);
        this.addActor(this.textLabel);
        this.listener = new SimpleTooltipListener(this, true);
        targetActor.addListener(this.listener);
        targetActor2.addListener(this.listener);
    }

    public void update(CharSequence text) {
        this.removeActor(this.textLabel);
        this.textLabel = new Label(text, this.style);
        this.addActor(this.textLabel);
    }

    public void act(float delta) {
        super.act(delta);
        if (this.targetActor != null && this.targetActor2 != null && this.targetActor.getStage() == null && this.targetActor2.getStage() == null) {
            this.remove();
        }

    }
}

