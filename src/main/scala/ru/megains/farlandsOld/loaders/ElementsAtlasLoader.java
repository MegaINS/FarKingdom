package ru.megains.farlandsOld.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ElementsAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite btn_cancel;
    public static Sprite sel_cancel;
    public static Sprite over_cancel;
    public static Sprite dis_cancel;
    public static Sprite btn_ok;
    public static Sprite sel_ok;
    public static Sprite over_ok;
    public static Sprite dis_ok;
    public static Sprite btn_yes;
    public static Sprite sel_yes;
    public static Sprite over_yes;
    public static Sprite dis_yes;
    public static Sprite btn_no;
    public static Sprite sel_no;
    public static Sprite over_no;
    public static Sprite dis_no;

    public ElementsAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("gui/elements.atlas"));
        btn_cancel = new Sprite(atlas.findRegion("btn_cancel"));
        sel_cancel = new Sprite(atlas.findRegion("sel_cancel"));
        over_cancel = new Sprite(atlas.findRegion("over_cancel"));
        dis_cancel = new Sprite(atlas.findRegion("dis_cancel"));
        btn_ok = new Sprite(atlas.findRegion("btn_ok"));
        sel_ok = new Sprite(atlas.findRegion("sel_ok"));
        over_ok = new Sprite(atlas.findRegion("over_ok"));
        dis_ok = new Sprite(atlas.findRegion("dis_ok"));
        btn_yes = new Sprite(atlas.findRegion("btn_yes"));
        sel_yes = new Sprite(atlas.findRegion("sel_yes"));
        over_yes = new Sprite(atlas.findRegion("over_yes"));
        dis_yes = new Sprite(atlas.findRegion("dis_yes"));
        btn_no = new Sprite(atlas.findRegion("btn_no"));
        sel_no = new Sprite(atlas.findRegion("sel_no"));
        over_no = new Sprite(atlas.findRegion("over_no"));
        dis_no = new Sprite(atlas.findRegion("dis_no"));
    }
}
