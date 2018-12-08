package ru.megains.farlandsOld.inventory.skill;


import org.json.simple.JSONObject;
import ru.megains.farlandsOld.base.ExpTable;

public class PlayerSkills {
    private float skillMineMetallWidth = 0.0F;
    private int skillMineMetallLevel = 0;
    private float skillMineMetall = 0.0F;
    private float skillMineWood = 0.0F;
    private int skillMineWoodLevel = 0;
    private float skillMineWoodWidth = 0.0F;
    private float skillMineSkin = 0.0F;
    private int skillMineSkinLevel = 0;
    private float skillMineSkinWidth = 0.0F;
    private float skillMineTreasure = 0.0F;
    private int skillMineTreasureLevel = 0;
    private float skillMineTreasureWidth = 0.0F;
    private float skillWpnSword = 0.0F;
    private int skillWpnSwordLevel = 0;
    private float skillWpnSwordWidth = 0.0F;
    private float skillWpnAxe = 0.0F;
    private int skillWpnAxeLevel = 0;
    private float skillWpnAxeWidth = 0.0F;
    private float skillWpnHammer = 0.0F;
    private int skillWpnHammerLevel = 0;
    private float skillWpnHammerWidth = 0.0F;

    public PlayerSkills(JSONObject jsonObject) {
        this.load(jsonObject);
    }

    public void load(JSONObject skillsJSON) {
        this.skillMineMetall = ((Double)skillsJSON.get("skillMineMetall")).floatValue();
        this.skillMineWood = ((Double)skillsJSON.get("skillMineWood")).floatValue();
        this.skillMineSkin = ((Double)skillsJSON.get("skillMineSkin")).floatValue();
        this.skillMineTreasure = ((Double)skillsJSON.get("skillMineTreasure")).floatValue();
        this.skillWpnSword = ((Double)skillsJSON.get("skillWpnSword")).floatValue();
        this.skillWpnAxe = ((Double)skillsJSON.get("skillWpnAxe")).floatValue();
        this.skillWpnHammer = ((Double)skillsJSON.get("skillWpnHammer")).floatValue();
        this.skillMineMetallLevel = ExpTable.getCurentLevel(this.skillMineMetall);
        this.skillMineWoodLevel = ExpTable.getCurentLevel(this.skillMineWood);
        this.skillMineSkinLevel = ExpTable.getCurentLevel(this.skillMineSkin);
        this.skillMineTreasureLevel = ExpTable.getCurentLevel(this.skillMineTreasure);
        this.skillWpnSwordLevel = ExpTable.getCurentLevel(this.skillWpnSword);
        this.skillWpnAxeLevel = ExpTable.getCurentLevel(this.skillWpnAxe);
        this.skillWpnHammerLevel = ExpTable.getCurentLevel(this.skillWpnHammer);
        this.calculateWidth();
    }

    private void calculateWidth() {
        float expDiv;
        if (this.skillMineMetall != 0.0F) {
            expDiv = ExpTable.getLevelExp(this.skillMineMetallLevel);
            this.skillMineMetallWidth = 100.0F * (this.skillMineMetall - expDiv) / (ExpTable.getLevelExp(this.skillMineMetallLevel + 1) - expDiv) * 0.72F;
        }

        if (this.skillMineSkin != 0.0F) {
            expDiv = ExpTable.getLevelExp(this.skillMineSkinLevel);
            this.skillMineSkinWidth = 100.0F * (this.skillMineSkin - expDiv) / (ExpTable.getLevelExp(this.skillMineSkinLevel + 1) - expDiv) * 0.72F;
        }

        if (this.skillMineWood != 0.0F) {
            expDiv = ExpTable.getLevelExp(this.skillMineWoodLevel);
            this.skillMineWoodWidth = 100.0F * (this.skillMineWood - expDiv) / (ExpTable.getLevelExp(this.skillMineWoodLevel + 1) - expDiv) * 0.72F;
        }

        if (this.skillMineTreasure != 0.0F) {
            expDiv = ExpTable.getLevelExp(this.skillMineTreasureLevel);
            this.skillMineTreasureWidth = 100.0F * (this.skillMineTreasure - expDiv) / (ExpTable.getLevelExp(this.skillMineTreasureLevel + 1) - expDiv) * 0.72F;
        }

        if (this.skillWpnSword != 0.0F) {
            expDiv = ExpTable.getLevelExp(this.skillWpnSwordLevel);
            this.skillWpnSwordWidth = 100.0F * (this.skillWpnSword - expDiv) / (ExpTable.getLevelExp(this.skillWpnSwordLevel + 1) - expDiv) * 0.72F;
        }

        if (this.skillWpnAxe != 0.0F) {
            expDiv = ExpTable.getLevelExp(this.skillWpnAxeLevel);
            this.skillWpnAxeWidth = 100.0F * (this.skillWpnAxe - expDiv) / (ExpTable.getLevelExp(this.skillWpnAxeLevel + 1) - expDiv) * 0.72F;
        }

        if (this.skillWpnHammer != 0.0F) {
            expDiv = ExpTable.getLevelExp(this.skillWpnHammerLevel);
            this.skillWpnHammerWidth = 100.0F * (this.skillWpnHammer - expDiv) / (ExpTable.getLevelExp(this.skillWpnHammerLevel + 1) - expDiv) * 0.72F;
        }

    }

    public float getSkillMineMetall() {
        return this.skillMineMetall;
    }

    public int getSkillMineMetallLevel() {
        return this.skillMineMetallLevel;
    }

    public float getSkillMineWood() {
        return this.skillMineWood;
    }

    public int getSkillMineWoodLevel() {
        return this.skillMineWoodLevel;
    }

    public float getSkillMineSkin() {
        return this.skillMineSkin;
    }

    public int getSkillMineSkinLevel() {
        return this.skillMineSkinLevel;
    }

    public float getSkillMineTreasure() {
        return this.skillMineTreasure;
    }

    public int getSkillMineTreasureLevel() {
        return this.skillMineTreasureLevel;
    }

    public float getSkillWpnSword() {
        return this.skillWpnSword;
    }

    public int getSkillWpnSwordLevel() {
        return this.skillWpnSwordLevel;
    }

    public float getSkillWpnAxe() {
        return this.skillWpnAxe;
    }

    public int getSkillWpnAxeLevel() {
        return this.skillWpnAxeLevel;
    }

    public float getSkillWpnHammer() {
        return this.skillWpnHammer;
    }

    public int getSkillWpnHammerLevel() {
        return this.skillWpnHammerLevel;
    }

    public float getSkillMineMetallWidth() {
        return this.skillMineMetallWidth;
    }

    public float getSkillMineWoodWidth() {
        return this.skillMineWoodWidth;
    }

    public float getSkillMineTreasureWidth() {
        return this.skillMineTreasureWidth;
    }

    public float getSkillMineSkinWidth() {
        return this.skillMineSkinWidth;
    }

    public float getSkillWpnSwordWidth() {
        return this.skillWpnSwordWidth;
    }

    public float getSkillWpnAxeWidth() {
        return this.skillWpnAxeWidth;
    }

    public float getSkillWpnHammerWidth() {
        return this.skillWpnHammerWidth;
    }
}

