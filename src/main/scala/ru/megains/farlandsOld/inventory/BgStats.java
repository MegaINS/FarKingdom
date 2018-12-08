package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;

public class BgStats extends Group {
    private MyActor bg;
    private Label stamina;
    private Label conc;
    private Label intellect;
    private Label strength;

    public BgStats(Sprite sprite, int aligner) {
        this.bg = new MyActor(sprite);
        this.addActor(this.bg);
        this.strength = new Label("10", Styles.labelYellow);
        this.strength.setPosition((float)(8 - aligner), 3.0F);
        this.strength.setWidth(28.0F);
        this.strength.setAlignment(1);
        this.addActor(this.strength);
        this.stamina = new Label("10", Styles.labelYellow);
        this.stamina.setPosition((float)(50 - aligner), 3.0F);
        this.stamina.setWidth(28.0F);
        this.stamina.setAlignment(1);
        this.addActor(this.stamina);
        this.conc = new Label("10", Styles.labelYellow);
        this.conc.setPosition((float)(94 - aligner), 3.0F);
        this.conc.setWidth(28.0F);
        this.conc.setAlignment(1);
        this.addActor(this.conc);
        this.intellect = new Label("10", Styles.labelYellow);
        this.intellect.setPosition((float)(136 - aligner), 3.0F);
        this.intellect.setWidth(28.0F);
        this.intellect.setAlignment(1);
        this.addActor(this.intellect);
    }

    public void update(int stamina, int conc, int intellect, int strength) {
        this.stamina.setText(stamina + "");
        this.conc.setText(conc + "");
        this.intellect.setText(intellect + "");
        this.strength.setText(strength + "");
    }
}
