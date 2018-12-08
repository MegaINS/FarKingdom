package ru.megains.farlandsOld.inventory.skill;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;

public class SkillCategoryWiget extends Table {
    public SkillCategoryWiget(Sprite bgImage, Sprite iconImage, String name, int level, int persent) {
        this.setBounds(0.0F, 0.0F, 394.0F, 46.0F);
        MyActor bg = new MyActor(bgImage);
        MyActor icon = new MyActor(iconImage);
        Label labelName = new Label(name, Styles.labelYellow);
        this.add(bg);
        icon.setPosition(9.0F, 1.0F);
        this.addActor(icon);
        labelName.setPosition(55.0F, 11.0F);
        this.addActor(labelName);
    }
}

