package ru.megains.farlandsOld.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MainMenuAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite bg;
    public static Sprite bgLogin;
    public static Sprite btnLoginUp;
    public static Sprite btnLoginDown;
    public static Sprite btnExitUp;
    public static Sprite btnExitDown;
    public static Sprite back;
    public static Sprite btnregistration;
    public static Sprite selregistration;

    public MainMenuAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("mainmenu/mainmenu.pack"));
        bg = new Sprite(atlas.findRegion("bg"));
        bgLogin = new Sprite(atlas.findRegion("bglogin"));
        btnregistration = new Sprite(atlas.findRegion("btnregistration"));
        selregistration = new Sprite(atlas.findRegion("selregistration"));
        btnLoginUp = new Sprite(atlas.findRegion("btnenter"));
        btnLoginDown = new Sprite(atlas.findRegion("selenter"));
        btnExitUp = new Sprite(atlas.findRegion("btnexit"));
        btnExitDown = new Sprite(atlas.findRegion("selexit"));
        back = new Sprite(atlas.findRegion("selexit"));
    }
}
