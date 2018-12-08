package ru.megains.farlands.old;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class UserInfoAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite bgsimple;
    public static Sprite bg_chars;
    public static Sprite bg_frame;
    public static Sprite bg_items;
    public static Sprite bg;
    public static Sprite bg_attrs;
    public static Sprite bg_stats;
    public static Sprite btn_profile;
    public static Sprite sel_profile;
    public static Sprite btn_inventory;
    public static Sprite sel_inventory;
    public static Sprite btn_log;
    public static Sprite sel_log;
    public static Sprite btn_info;
    public static Sprite sel_info;
    public static Sprite btn_wear;
    public static Sprite sel_wear;
    public static Sprite over_wear;
    public static Sprite dis_wear;
    public static Sprite btn_takeoff;
    public static Sprite sel_takeoff;
    public static Sprite btn_use;
    public static Sprite sel_use;
    public static Sprite over_use;
    public static Sprite dis_use;
    public static Sprite btn_drop;
    public static Sprite sel_drop;
    public static Sprite over_drop;
    public static Sprite dis_drop;
    public static Sprite mask_items;
    public static Sprite bar_exp_empty;
    public static Sprite bar_weight_empty;
    public static Sprite bg_zet;
    public static Sprite bg_ezet;
    public static TextureRegion bgtooltip;

    public UserInfoAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("gui/userinfo.pack"));
        bgsimple = new Sprite(atlas.findRegion("bgsimple"));
        bgtooltip = atlas.findRegion("bgtooltip");
        bg_chars = new Sprite(atlas.findRegion("bg_chars"));
        bg_frame = new Sprite(atlas.findRegion("bg_frame"));
        bg_items = new Sprite(atlas.findRegion("bg_items"));
        mask_items = new Sprite(atlas.findRegion("mask_items"));
        bg = new Sprite(atlas.findRegion("bg"));
        bg_attrs = new Sprite(atlas.findRegion("bg_attrs"));
        bg_stats = new Sprite(atlas.findRegion("bg_stats"));
        btn_profile = new Sprite(atlas.findRegion("btn_profile"));
        sel_profile = new Sprite(atlas.findRegion("sel_profile"));
        btn_inventory = new Sprite(atlas.findRegion("btn_inventory"));
        sel_inventory = new Sprite(atlas.findRegion("sel_inventory"));
        btn_log = new Sprite(atlas.findRegion("btn_log"));
        sel_log = new Sprite(atlas.findRegion("sel_log"));
        btn_info = new Sprite(atlas.findRegion("btn_info"));
        sel_info = new Sprite(atlas.findRegion("sel_info"));
        btn_wear = new Sprite(atlas.findRegion("btn_wear"));
        sel_wear = new Sprite(atlas.findRegion("sel_wear"));
        over_wear = new Sprite(atlas.findRegion("over_wear"));
        dis_wear = new Sprite(atlas.findRegion("dis_wear"));
        btn_takeoff = new Sprite(atlas.findRegion("btn_takeoff"));
        sel_takeoff = new Sprite(atlas.findRegion("sel_takeoff"));
        btn_use = new Sprite(atlas.findRegion("btn_use"));
        sel_use = new Sprite(atlas.findRegion("sel_use"));
        over_use = new Sprite(atlas.findRegion("over_use"));
        dis_use = new Sprite(atlas.findRegion("dis_use"));
        btn_drop = new Sprite(atlas.findRegion("btn_drop"));
        sel_drop = new Sprite(atlas.findRegion("sel_drop"));
        over_drop = new Sprite(atlas.findRegion("over_drop"));
        dis_drop = new Sprite(atlas.findRegion("dis_drop"));
        bar_exp_empty = new Sprite(atlas.findRegion("bar_exp_empty"));
        bar_weight_empty = new Sprite(atlas.findRegion("bar_weight_empty"));
        bg_zet = new Sprite(atlas.findRegion("bg_zet"));
        bg_ezet = new Sprite(atlas.findRegion("bg_ezet"));
    }
}

