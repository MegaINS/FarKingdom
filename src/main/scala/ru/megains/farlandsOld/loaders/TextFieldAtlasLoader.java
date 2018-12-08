package ru.megains.farlandsOld.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TextFieldAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite leftTopCorner;
    public static Sprite leftBottomCorner;
    public static Sprite rightTopCorner;
    public static Sprite rightBottomCorner;
    public static Sprite leftSide;
    public static Sprite topSide;
    public static Sprite bottomSide;
    public static Sprite rightSide;
    public static Sprite middlePart;

    public TextFieldAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("gui/textField.atlas"));
        leftTopCorner = new Sprite(atlas.findRegion("3"));
        leftBottomCorner = new Sprite(atlas.findRegion("9"));
        rightTopCorner = new Sprite(atlas.findRegion("1"));
        rightBottomCorner = new Sprite(atlas.findRegion("7"));
        leftSide = new Sprite(atlas.findRegion("4"));
        rightSide = new Sprite(atlas.findRegion("6"));
        topSide = new Sprite(atlas.findRegion("8"));
        bottomSide = new Sprite(atlas.findRegion("2"));
        middlePart = new Sprite(atlas.findRegion("5"));
    }
}