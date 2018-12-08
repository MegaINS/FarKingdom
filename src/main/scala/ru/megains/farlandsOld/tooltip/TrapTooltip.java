package ru.megains.farlandsOld.tooltip;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.trap.Trap;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class TrapTooltip extends Table {
    private Trap trap;
    private SimpleTooltipListener listener;
    private Label.LabelStyle labelWhite;
    private static final int padLeft = 5;
    private static final int padRight = 5;

    public TrapTooltip(Trap trap) {
        this.labelWhite = Styles.labelWhite11;
        this.trap = trap;
        this.setTouchable(Touchable.disabled);
        this.setBackground(new SpriteDrawable(new Sprite(UserInfoAtlasLoader.bgtooltip)));
        this.top();
        this.listener = new SimpleTooltipListener(this, true);
        this.drawTooltip();
        trap.addListener(this.listener);
    }

    private void drawTooltip() {
        this.clear();
        this.add(new Label(this.trap.getName(), this.labelWhite)).colspan(2).left();
        this.row();
        this.add(new Label("Урон: " + this.trap.getDamage() + "-" + (this.trap.getDamage() + this.trap.getDamageRange()), this.labelWhite)).colspan(2).left();
        this.row();
        this.pack();
    }

    public void act(float delta) {
        super.act(delta);
        if (this.trap == null) {
            this.remove();
        }

        if (this.trap != null && this.trap.getStage() == null) {
            this.remove();
        }

        this.toFront();
    }
}

