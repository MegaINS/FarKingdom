package ru.megains.farlandsOld.loaders;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class SkillsAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite bar;
    public static Sprite bg;
    public static Sprite bg_1blue;
    public static Sprite bg_1green;
    public static Sprite bg_1indigo;
    public static Sprite bg_1orange;
    public static Sprite bg_1red;
    public static Sprite bg_1violet;
    public static Sprite bg_2blue;
    public static Sprite bg_2green;
    public static Sprite bg_2indigo;
    public static Sprite bg_2orange;
    public static Sprite bg_2red;
    public static Sprite bg_2violet;
    public static Sprite bg_3ablue;
    public static Sprite bg_3agreen;
    public static Sprite bg_3aindigo;
    public static Sprite bg_3aorange;
    public static Sprite bg_3ared;
    public static Sprite bg_3aviolet;
    public static Sprite bg_3blue;
    public static Sprite bg_3green;
    public static Sprite bg_3indigo;
    public static Sprite bg_3orange;
    public static Sprite bg_3red;
    public static Sprite bg_3violet;
    public static Sprite bg_bar;
    public static Sprite bullet;
    public static Sprite skill_breaklock;
    public static Sprite skill_craft_alchemy;
    public static Sprite skill_craft_carpenter;
    public static Sprite skill_craft_carpenter_bow;
    public static Sprite skill_craft_carpenter_carpe;
    public static Sprite skill_craft_carpenter_shield;
    public static Sprite skill_craft_forge_axe;
    public static Sprite skill_craft_forge_dagger;
    public static Sprite skill_craft_forge_hammer;
    public static Sprite skill_craft_forge_mineaxe;
    public static Sprite skill_craft_forge_pickaxe;
    public static Sprite skill_craft_forge_sword;
    public static Sprite skill_craft_forging;
    public static Sprite skill_craft_jewelry;
    public static Sprite skill_craft_jewelry_amulets;
    public static Sprite skill_craft_jewelry_bracers;
    public static Sprite skill_craft_jewelry_diadems;
    public static Sprite skill_craft_jewelry_earrings;
    public static Sprite skill_craft_jewelry_rings;
    public static Sprite skill_craft_leather_armor;
    public static Sprite skill_craft_leather_boots;
    public static Sprite skill_craft_leather_forging;
    public static Sprite skill_craft_leather_gloves;
    public static Sprite skill_craft_leather_helmet;
    public static Sprite skill_craft_metal_armor;
    public static Sprite skill_craft_process;
    public static Sprite skill_fight;
    public static Sprite skill_fight_axe;
    public static Sprite skill_fight_bow;
    public static Sprite skill_fight_dagger;
    public static Sprite skill_fight_double;
    public static Sprite skill_fight_hammer;
    public static Sprite skill_fight_magic;
    public static Sprite skill_fight_sword;
    public static Sprite skill_fight_unarmed;
    public static Sprite skill_magic;
    public static Sprite skill_magic_runes;
    public static Sprite skill_magic_scrolls;
    public static Sprite skill_make_cloth;
    public static Sprite skill_make_coal;
    public static Sprite skill_make_leather;
    public static Sprite skill_make_wood;
    public static Sprite skill_mine;
    public static Sprite skill_mine_metal;
    public static Sprite skill_mine_skin;
    public static Sprite skill_mine_wood;
    public static Sprite skill_steal;

    public SkillsAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("skills/skills.pack"));
        bg = new Sprite(atlas.findRegion("bg"));
        bg_bar = new Sprite(atlas.findRegion("bg_bar"));
        bar = new Sprite(atlas.findRegion("bar"));
        bg_1blue = new Sprite(atlas.findRegion("bg_1blue"));
        bg_2blue = new Sprite(atlas.findRegion("bg_2blue"));
        bg_1red = new Sprite(atlas.findRegion("bg_1red"));
        bg_2red = new Sprite(atlas.findRegion("bg_2red"));
        skill_craft_alchemy = new Sprite(atlas.findRegion("skill_craft_alchemy"));
        skill_fight = new Sprite(atlas.findRegion("skill_fight"));
        skill_fight_sword = new Sprite(atlas.findRegion("skill_fight_sword"));
        skill_fight_axe = new Sprite(atlas.findRegion("skill_fight_axe"));
        skill_fight_hammer = new Sprite(atlas.findRegion("skill_fight_hammer"));
        skill_mine = new Sprite(atlas.findRegion("skill_mine"));
        skill_mine_metal = new Sprite(atlas.findRegion("skill_mine_metal"));
        skill_mine_skin = new Sprite(atlas.findRegion("skill_mine_skin"));
        skill_mine_wood = new Sprite(atlas.findRegion("skill_mine_wood"));
        skill_steal = new Sprite(atlas.findRegion("skill_steal"));
    }
}

