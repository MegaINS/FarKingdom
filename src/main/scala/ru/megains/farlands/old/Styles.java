package ru.megains.farlands.old;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Styles {
    public static Skin guiSkin;
    public static Label.LabelStyle labelGreen;
    public static Label.LabelStyle labelYellow;
    public static Label.LabelStyle labelBlack;
    public static Label.LabelStyle labelRed;
    public static Label.LabelStyle tooltipLabel;
    public static Label.LabelStyle labelWhite11;
    public static Label.LabelStyle labelRound;
    public static Label.LabelStyle labelTimer;
    public static BitmapFont chatFont;
    public static BitmapFont chatFontBolb;
    public static BitmapFont chatFontItalic;

    public Styles() {
    }

    public static void load() {
        Assets assets = new Assets();
        assets.load();
        assets.manager.finishLoading();
        guiSkin = (Skin)assets.manager.get(Assets.uiSkin);
        FileHandleResolver resolver = new InternalFileHandleResolver();
        AssetManager manager = new AssetManager();
       // manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
       // manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        Fonts.load(manager);
        manager.finishLoading();
        Fonts.build(manager);
        labelGreen = new Label.LabelStyle();
        labelGreen.fontColor = new Color(0.1F, 0.85F, 0.4F, 1.0F);
        labelGreen.font = Fonts.ARIAL_12B.get();
        labelYellow = new Label.LabelStyle();
        labelYellow.font = Fonts.ARIAL_12B.get();
        labelRound = new Label.LabelStyle();
        labelRound.fontColor = new Color(0.9F, 0.85F, 0.7F, 1.0F);
        labelRound.font = Fonts.ARIAL_BLACK28.get();
        labelTimer = new Label.LabelStyle();
        labelTimer.fontColor = new Color(0.9F, 0.85F, 0.7F, 1.0F);
        labelTimer.font = Fonts.TIMER.get();
        labelWhite11 = new Label.LabelStyle();
        labelWhite11.fontColor = new Color(0.88F, 0.87F, 0.75F, 1.0F);
        labelWhite11.font = Fonts.ARIAL_11_WHITE.get();
        labelBlack = new Label.LabelStyle();
        labelBlack.fontColor = new Color(0.0F, 0.0F, 0.0F, 1.0F);
        labelBlack.font = Fonts.ARIAL_12B.get();
        labelRed = new Label.LabelStyle();
        labelRed.fontColor = new Color(0.9F, 0.0F, 0.0F, 1.0F);
        labelRed.font = Fonts.CHAT_SIMPLE.get();
        tooltipLabel = new Label.LabelStyle();
        tooltipLabel.fontColor = new Color(0.0F, 0.0F, 0.0F, 1.0F);
        tooltipLabel.font = Fonts.ARIAL_12B.get();
        tooltipLabel.background = new SpriteDrawable(GuiAtlasLoader.bg);
        chatFont = Fonts.CHAT_SIMPLE.get();
        chatFontBolb = Fonts.CHAT_BOLD.get();
        chatFontItalic = Fonts.CHAT_ITALIC.get();
    }
}

