package ru.megains.farlandsOld.inventory.skill;


import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import org.json.simple.JSONObject;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.loaders.SkillsAtlasLoader;

public class SkillListPane extends ScrollPane {
    Table skillsTable = (Table)this.getActor();

    public SkillListPane() {
        super(new Table(), Styles.guiSkin);
        this.skillsTable.left().top();
        this.skillsTable.setBackground(new SpriteDrawable(SkillsAtlasLoader.bg));
        this.setBounds(0.0F, 0.0F, 400.0F, 330.0F);
        this.setFadeScrollBars(false);
        this.setFlickScroll(true);
        this.setScrollingDisabled(true, false);
        this.setOverscroll(false, false);
    }

    public void loadSkills(JSONObject skillsJson) {
        this.skillsTable.clear();
        PlayerSkills skills = new PlayerSkills(skillsJson);
        this.skillsTable.add(new SkillCategoryWiget(SkillsAtlasLoader.bg_1red, SkillsAtlasLoader.skill_fight, "БОЕВЫЕ НАВЫКИ", 1, 30));
        this.skillsTable.row();
        if (skills.getSkillWpnSword() > 0.0F) {
            this.skillsTable.add(new SkillSubCategiryWiget(SkillsAtlasLoader.bg_2red, SkillsAtlasLoader.skill_fight_sword, "Клинковое оружие", skills.getSkillWpnSwordLevel(), skills.getSkillWpnSword(), skills.getSkillWpnSwordWidth()));
            this.skillsTable.row();
        }

        if (skills.getSkillWpnAxe() > 0.0F) {
            this.skillsTable.add(new SkillSubCategiryWiget(SkillsAtlasLoader.bg_2red, SkillsAtlasLoader.skill_fight_axe, "Рубящее оружие", skills.getSkillWpnAxeLevel(), skills.getSkillWpnAxe(), skills.getSkillWpnAxeWidth()));
            this.skillsTable.row();
        }

        if (skills.getSkillWpnHammer() > 0.0F) {
            this.skillsTable.add(new SkillSubCategiryWiget(SkillsAtlasLoader.bg_2red, SkillsAtlasLoader.skill_fight_hammer, "Дробящее оружие", skills.getSkillWpnHammerLevel(), skills.getSkillWpnHammer(), skills.getSkillWpnHammerWidth()));
            this.skillsTable.row();
        }

        this.skillsTable.add(new SkillCategoryWiget(SkillsAtlasLoader.bg_1blue, SkillsAtlasLoader.skill_mine, "НАВЫКИ ДОБЫЧИ", 1, 30));
        this.skillsTable.row();
        if (skills.getSkillMineMetall() > 0.0F) {
            this.skillsTable.add(new SkillSubCategiryWiget(SkillsAtlasLoader.bg_2blue, SkillsAtlasLoader.skill_mine_metal, "Рудокоп", skills.getSkillMineMetallLevel(), skills.getSkillMineMetall(), skills.getSkillMineMetallWidth()));
            this.skillsTable.row();
        }

        if (skills.getSkillMineSkin() > 0.0F) {
            this.skillsTable.add(new SkillSubCategiryWiget(SkillsAtlasLoader.bg_2blue, SkillsAtlasLoader.skill_mine_skin, "Охотник", skills.getSkillMineSkinLevel(), skills.getSkillMineSkin(), skills.getSkillMineSkinWidth()));
            this.skillsTable.row();
        }

        if (skills.getSkillMineWood() > 0.0F) {
            this.skillsTable.add(new SkillSubCategiryWiget(SkillsAtlasLoader.bg_2blue, SkillsAtlasLoader.skill_mine_wood, "Дровосек", skills.getSkillMineWoodLevel(), skills.getSkillMineWood(), skills.getSkillMineWoodWidth()));
            this.skillsTable.row();
        }

        if (skills.getSkillMineTreasure() > 0.0F) {
            this.skillsTable.add(new SkillSubCategiryWiget(SkillsAtlasLoader.bg_2blue, SkillsAtlasLoader.skill_steal, "Кладоискатель", skills.getSkillMineTreasureLevel(), skills.getSkillMineTreasure(), skills.getSkillMineTreasureWidth()));
            this.skillsTable.row();
        }

    }
}

