package ru.megains.farlandsOld.inventory.skill;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import ru.megains.farlandsOld.base.ExpTable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.SkillsAtlasLoader;
import ru.megains.farlandsOld.tooltip.SimpleTooltip;

public class SkillSubCategiryWiget extends Table {
    public SkillSubCategiryWiget(Sprite bgImage, Sprite iconImage, String name, int level, float exp, float barWidth) {
        this.setBounds(0.0F, 0.0F, 394.0F, 40.0F);
        MyActor bg = new MyActor(bgImage);
        MyActor icon = new MyActor(iconImage);
        Label labelName = new Label(name, Styles.labelYellow);
        MyActor lavelBg = new MyActor(SkillsAtlasLoader.bg_bar);
        Label labelLevel = new Label("" + level, Styles.labelYellow);
        MyActor bar = new MyActor(SkillsAtlasLoader.bar);
        this.add(bg);
        icon.setPosition(49.0F, 1.0F);
        this.addActor(icon);
        labelName.setPosition(95.0F, 11.0F);
        this.addActor(labelName);
        lavelBg.setPosition(280.0F, 12.0F);
        this.addActor(lavelBg);
        labelLevel.setPosition(364.0F, 11.0F);
        this.addActor(labelLevel);
        bar.setPosition(281.0F, 14.0F);
        bar.setWidth(barWidth);
        this.addActor(bar);
        new SimpleTooltip(" " + exp + " / " + ExpTable.getLevelExp(level + 1), Styles.tooltipLabel, bar, lavelBg);
    }
}
