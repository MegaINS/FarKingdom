package ru.megains.farlandsOld.tooltip;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.mob.Mob;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class MobTooltip extends Table {
    private Mob mob;
    private SimpleTooltipListener listener;
    private Label.LabelStyle labelWhite;
    private static final int padLeft = 5;
    private static final int padRight = 5;

    public MobTooltip(Mob mob) {
        this.labelWhite = Styles.labelWhite11;
        this.mob = mob;
        this.setTouchable(Touchable.disabled);
        this.setBackground(new SpriteDrawable(new Sprite(UserInfoAtlasLoader.bgtooltip)));
        this.top();
        this.listener = new SimpleTooltipListener(this, true);
        this.drawTooltip();
        mob.addListener(this.listener);
    }

    private void drawTooltip() {
        this.clear();
        this.add(new Label(this.mob.getName(), this.labelWhite)).colspan(2).left();
        this.row();
        this.add(new Label("Уровень: " + this.mob.getLevel(), this.labelWhite)).colspan(2).left();
        this.row();
        this.add(new Label("Жизнь: " + this.mob.getHpCurent(), this.labelWhite)).colspan(2).left();
        this.row();
        this.add(new Label("Урон: " + this.mob.getDamage() + "-" + (this.mob.getDamage() + this.mob.getDamageRange()) + " (" + this.mob.getCrit() + ")", this.labelWhite)).colspan(2).left();
        this.row();
        this.add(new Label("Защита: " + this.mob.getDefence() + " (" + this.mob.getAntiCrit() + ")", this.labelWhite)).colspan(2).left();
        this.row();
        this.add(new Label("Концентрация: " + this.mob.getConc(), this.labelWhite)).colspan(2).left();
        this.row();
        this.pack();
    }

    public void act(float delta) {
        super.act(delta);
        if (this.mob == null) {
            this.remove();
        }

        if (this.mob != null && this.mob.getStage() == null) {
            this.remove();
        }

        this.toFront();
    }
}

