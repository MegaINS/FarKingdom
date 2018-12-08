package ru.megains.farlandsOld;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public AssetManager manager = new AssetManager();
    public static final AssetDescriptor<Skin> uiSkin = new AssetDescriptor("skins/uiskin.json", Skin.class, new SkinLoader.SkinParameter("skins/uiskin.atlas"));
    public static BitmapFont chatFont;

    public Assets() {
    }

    public void load() {
        this.manager.load(uiSkin);
    }

    public void dispose() {
        this.manager.dispose();
    }
}
