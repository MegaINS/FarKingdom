package ru.megains.farlands.old;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public enum Fonts {
    MAIN_MENU_INPUT("ttfs/cour.ttf", 14, 0.0F, Color.WHITE, Color.DARK_GRAY),
    CHAT_SIMPLE("ttfs/cour.ttf", 14, 0.1F, Color.BLACK, Color.DARK_GRAY),
    CHAT_LOG_MESSAGE("ttfs/cour.ttf", 14, 0.0F, Color.BLACK, Color.DARK_GRAY),
    CHAT_BOLD("ttfs/courbd.ttf", 13, 0.1F, Color.BLACK, Color.DARK_GRAY),
    CHAT_ITALIC("ttfs/couri.ttf", 14, 0.1F, Color.BLACK, Color.DARK_GRAY),
    ARIAL_12B("ttfs/arialbd.ttf", 12, 0.0F, new Color(0.9F, 0.85F, 0.7F, 1.0F), Color.DARK_GRAY),
    ARIAL_11_WHITE("ttfs/arial.ttf", 11, 0.0F, Color.WHITE, Color.WHITE),
    ARIAL_12_WHITE("ttfs/arial.ttf", 12, 0.0F, Color.WHITE, Color.WHITE),
    TIMER("ttfs/arial.ttf", 16, 0.0F, Color.BLACK, Color.DARK_GRAY),
    PLAYER_TABLE_MI("ttfs/courbd.ttf", 14, 0.0F, Color.BLACK, Color.DARK_GRAY),
    PLAYER_TABLE_ENEMY("ttfs/cour.ttf", 14, 0.0F, Color.BLACK, Color.DARK_GRAY),
    ARIAL_BLACK28("ttfs/arial.ttf", 28, 0.3F, Color.BLACK, Color.DARK_GRAY),
    ARENA_TIMES("ttfs/times.ttf", 14, 0.0F, Color.WHITE, Color.DARK_GRAY);

    private final String path;
    private final int size;
    private final float borderSize;
    private final Color color;
    private final Color borderColor;
    private BitmapFont font;

    private Fonts(String path, int size, float borderSize) {
        this(path, size, borderSize, Color.WHITE, Color.BLACK);
    }

    private Fonts(String path, int size, float borderSize, Color color) {
        this(path, size, borderSize, color, Color.BLACK);
    }

    private Fonts(String path, int size, float borderSize, Color color, Color borderColor) {
        this.path = path;
        this.size = size;
        this.borderSize = borderSize;
        this.color = color;
        this.borderColor = borderColor;
    }

    public static void build(AssetManager manager) {
        float scale = 1.0F;

        for(int i = 0; i < values().length; ++i) {
//            FreeTypeFontGenerator.FreeTypeFontParameter myFontParameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
//            myFontParameters.borderWidth = values()[i].borderSize;
//            myFontParameters.borderColor = values()[i].borderColor;
//            myFontParameters.characters = createChars();
//            FreeTypeFontGenerator myFontGenerator = (FreeTypeFontGenerator)manager.get(values()[i].path, FreeTypeFontGenerator.class);
//            myFontParameters.size = (int)((float)values()[i].size * 1.0F);
//            myFontParameters.color = values()[i].color;
//            values()[i].font = myFontGenerator.generateFont(myFontParameters);
        }

    }

    public static void load(AssetManager manager) {
        for(int i = 0; i < values().length; ++i) {
            if (!manager.isLoaded(values()[i].path)) {
               // manager.load(values()[i].path, FreeTypeFontGenerator.class);
            }
        }

    }

    public static void unload(AssetManager manager) {
        for(int i = 0; i < values().length; ++i) {
            if (values()[i].font != null) {
                values()[i].font.dispose();
                values()[i].font = null;
                if (manager.isLoaded(values()[i].path)) {
                    manager.unload(values()[i].path);
                }
            }
        }

    }

    private static String createChars() {
        String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        return FONT_CHARS;
    }

    public BitmapFont get() {
        return this.font;
    }
}
