package ru.megains.farlandsOld.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class CursorsAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite c0;
    public static Sprite c1;
    public static Sprite c2;
    public static Sprite c3;
    public static Sprite c4;
    public static Sprite c5;
    public static Sprite c6;
    public static Sprite c7;
    public static Sprite c8;
    public static Sprite c9;

    public CursorsAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("gui/cursors.pack"));
        c0 = new Sprite(atlas.findRegion("0"));
        c1 = new Sprite(atlas.findRegion("1"));
        c2 = new Sprite(atlas.findRegion("2"));
        c3 = new Sprite(atlas.findRegion("3"));
        c4 = new Sprite(atlas.findRegion("4"));
        c6 = new Sprite(atlas.findRegion("6"));
        c7 = new Sprite(atlas.findRegion("7"));
        c8 = new Sprite(atlas.findRegion("8"));
        c9 = new Sprite(atlas.findRegion("9"));
    }
}
