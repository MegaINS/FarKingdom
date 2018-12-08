package ru.megains.farlandsOld.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class StoreAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite btn_buy;
    public static Sprite btn_open;
    public static Sprite btn_add;
    public static Sprite btn_remove;
    public static Sprite bg_type_count;
    public static Sprite cell_bg1;
    public static Sprite cell_bg2;
    public static Sprite cell_bg3;
    public static Sprite cell_sel_bg1;
    public static Sprite cell_sel_bg2;
    public static Sprite cell_sel_bg3;

    public StoreAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("gui/store.pack"));
        btn_buy = new Sprite(atlas.findRegion("btn_buy"));
        btn_open = new Sprite(atlas.findRegion("btn_open"));
        btn_add = new Sprite(atlas.findRegion("btn_add"));
        btn_remove = new Sprite(atlas.findRegion("btn_remove"));
        bg_type_count = new Sprite(atlas.findRegion("bg_type_count"));
        cell_bg1 = new Sprite(atlas.findRegion("cell_bg1"));
        cell_bg2 = new Sprite(atlas.findRegion("cell_bg2"));
        cell_bg3 = new Sprite(atlas.findRegion("cell_bg3"));
        cell_sel_bg1 = new Sprite(atlas.findRegion("cell_sel_bg1"));
        cell_sel_bg2 = new Sprite(atlas.findRegion("cell_sel_bg2"));
        cell_sel_bg3 = new Sprite(atlas.findRegion("cell_sel_bg3"));
    }
}
