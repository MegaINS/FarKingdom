package ru.megains.farlandsOld.loaders;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class BattleAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite border;
    public static Sprite btn_block;
    public static Sprite btn_dodge;
    public static Sprite btn_fight;
    public static Sprite btn_hit;
    public static Sprite btn_hit2;
    public static Sprite btn_pray;
    public static Sprite dis_fight;
    public static Sprite dis_pray;
    public static Sprite over_block;
    public static Sprite over_dodge;
    public static Sprite over_fight;
    public static Sprite over_hit;
    public static Sprite over_hit2;
    public static Sprite over_pray;
    public static Sprite pic;
    public static Sprite sel_block;
    public static Sprite sel_dodge;
    public static Sprite sel_fight;
    public static Sprite sel_hit;
    public static Sprite sel_hit2;
    public static Sprite sel_pray;
    public static Sprite dis_cancel;
    public static Sprite over_cancel;
    public static Sprite btn_cancel;
    public static Sprite sel_cancel;
    public static Sprite duel;
    public static Sprite bg;
    public static Sprite bg_all2;
    public static Sprite bar_container;

    public BattleAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("battle/battle.pack"));
        border = new Sprite(atlas.findRegion("border"));
        btn_block = new Sprite(atlas.findRegion("btn_block"));
        btn_dodge = new Sprite(atlas.findRegion("btn_dodge"));
        btn_fight = new Sprite(atlas.findRegion("btn_fight"));
        btn_hit = new Sprite(atlas.findRegion("btn_hit"));
        btn_hit2 = new Sprite(atlas.findRegion("btn_hit2"));
        btn_pray = new Sprite(atlas.findRegion("btn_pray"));
        dis_fight = new Sprite(atlas.findRegion("dis_fight"));
        dis_pray = new Sprite(atlas.findRegion("dis_pray"));
        over_block = new Sprite(atlas.findRegion("over_block"));
        over_dodge = new Sprite(atlas.findRegion("over_dodge"));
        over_fight = new Sprite(atlas.findRegion("over_fight"));
        over_hit = new Sprite(atlas.findRegion("over_hit"));
        over_hit2 = new Sprite(atlas.findRegion("over_hit2"));
        over_pray = new Sprite(atlas.findRegion("over_pray"));
        pic = new Sprite(atlas.findRegion("pic"));
        sel_block = new Sprite(atlas.findRegion("sel_block"));
        sel_dodge = new Sprite(atlas.findRegion("sel_dodge"));
        sel_fight = new Sprite(atlas.findRegion("sel_fight"));
        sel_hit = new Sprite(atlas.findRegion("sel_hit"));
        sel_hit2 = new Sprite(atlas.findRegion("sel_hit2"));
        sel_pray = new Sprite(atlas.findRegion("sel_pray"));
        dis_cancel = new Sprite(atlas.findRegion("dis_cancel"));
        over_cancel = new Sprite(atlas.findRegion("over_cancel"));
        btn_cancel = new Sprite(atlas.findRegion("btn_cancel"));
        sel_cancel = new Sprite(atlas.findRegion("sel_cancel"));
        duel = new Sprite(atlas.findRegion("duel"));
        bg = new Sprite(atlas.findRegion("bg"));
        bg_all2 = new Sprite(atlas.findRegion("bg_all2"));
        bar_container = new Sprite(atlas.findRegion("bar_container"));
    }
}

