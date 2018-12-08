package ru.megains.farlandsOld.gameobjects.res;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.tooltip.SimpleTooltipListener;

public class ResTooltip extends Table {
    private ResCell res;
    private SimpleTooltipListener listener;
    private Label.LabelStyle labelWhite;
    private static final int padLeft = 5;
    private static final int padRight = 5;

    public ResTooltip(ResCell res) {
        this.labelWhite = Styles.labelWhite11;
        this.res = res;
        this.setTouchable(Touchable.disabled);
        this.setBackground(new SpriteDrawable(new Sprite(UserInfoAtlasLoader.bgtooltip)));
        this.top();
        this.listener = new SimpleTooltipListener(this, true);
        this.drawTooltip();
        res.addListener(this.listener);
    }

    private void drawTooltip() {
        this.clear();
        this.add(new Label(this.res.getName(), this.labelWhite));
        this.row();
        this.add(new Label("кол-во: " + this.res.getCount(), this.labelWhite)).colspan(2).left();
        this.row();
        this.add(new Label("Урон: " + this.res.getDamage(), this.labelWhite)).colspan(2).left();
        this.row();
        this.pack();
    }

    public void act(float delta) {
        super.act(delta);
        if (this.res == null) {
            this.remove();
        }

        if (this.res != null && this.res.getStage() == null) {
            this.remove();
        }

        this.toFront();
    }
}

