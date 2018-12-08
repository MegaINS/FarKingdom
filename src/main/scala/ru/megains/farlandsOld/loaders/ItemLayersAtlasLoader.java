package ru.megains.farlandsOld.loaders;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ItemLayersAtlasLoader {
    private static TextureAtlas atlas;
    private static Sprite armor_class0;
    private static Sprite armor_class1;
    private static Sprite armor_class2;
    private static Sprite armor_class3;
    private static Sprite armor_class4;
    private static Sprite armor_class5;
    private static Sprite armor_class6;
    private static Sprite armor_class7;
    private static Sprite armor_class8;
    private static Sprite class0;
    private static Sprite class1;
    private static Sprite class2;
    private static Sprite class3;
    private static Sprite class4;
    private static Sprite class5;
    private static Sprite class6;
    private static Sprite class7;
    private static Sprite class8;
    private static Sprite bg_class0;
    private static Sprite bg_class1;
    private static Sprite bg_class2;
    private static Sprite bg_class3;
    private static Sprite bg_class4;
    private static Sprite bg_class5;
    private static Sprite bg_class6;
    private static Sprite bg_class7;
    private static Sprite bg_class8;
    private static Sprite bg_class_0_sel;
    private static Sprite bg_class_1_sel;
    private static Sprite bg_class_2_sel;
    private static Sprite bg_class_3_sel;
    private static Sprite bg_class_4_sel;
    private static Sprite bg_class_5_sel;
    private static Sprite bg_class_6_sel;
    private static Sprite bg_class_7_sel;
    private static Sprite bg_class_8_sel;
    public static Sprite att_damage;
    public static Sprite att_defence;
    public static Sprite bg_item_weight;
    public static Sprite bg_right;
    public static Sprite item_bar;
    public static Sprite item_health;
    public static Sprite item_bg;
    public static Sprite bg;
    public static Sprite coin;
    public static Sprite bg_type_count;
    public static Sprite selected_equip;
    public static Sprite bg_1_info;
    public static Sprite bg_2_info;
    public static Sprite bg_3_info;
    public static Sprite item_bg_info;
    public static Sprite line_info;

    public ItemLayersAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("items/itemlayers.pack"));
        bg_1_info = new Sprite(atlas.findRegion("bg_1_info"));
        bg_2_info = new Sprite(atlas.findRegion("bg_2_info"));
        bg_3_info = new Sprite(atlas.findRegion("bg_3_info"));
        item_bg_info = new Sprite(atlas.findRegion("item_bg_info"));
        line_info = new Sprite(atlas.findRegion("line_info"));
        coin = new Sprite(atlas.findRegion("coin"));
        att_damage = new Sprite(atlas.findRegion("att_damage"));
        att_defence = new Sprite(atlas.findRegion("att_defence"));
        bg_item_weight = new Sprite(atlas.findRegion("bg_item_weight"));
        bg_right = new Sprite(atlas.findRegion("bg_right"));
        item_bar = new Sprite(atlas.findRegion("item_bar"));
        item_health = new Sprite(atlas.findRegion("item_health"));
        item_bg = new Sprite(atlas.findRegion("item_bg"));
        bg = new Sprite(atlas.findRegion("bg"));
        bg_type_count = new Sprite(atlas.findRegion("bg_type_count"));
        selected_equip = new Sprite(atlas.findRegion("selected_equip"));
        bg_class0 = new Sprite(atlas.findRegion("bg_class0"));
        bg_class1 = new Sprite(atlas.findRegion("bg_class1"));
        bg_class2 = new Sprite(atlas.findRegion("bg_class2"));
        bg_class3 = new Sprite(atlas.findRegion("bg_class3"));
        bg_class4 = new Sprite(atlas.findRegion("bg_class4"));
        bg_class5 = new Sprite(atlas.findRegion("bg_class5"));
        bg_class6 = new Sprite(atlas.findRegion("bg_class6"));
        bg_class7 = new Sprite(atlas.findRegion("bg_class7"));
        bg_class8 = new Sprite(atlas.findRegion("bg_class8"));
        bg_class_0_sel = new Sprite(atlas.findRegion("bg_class_0_sel"));
        bg_class_1_sel = new Sprite(atlas.findRegion("bg_class_1_sel"));
        bg_class_2_sel = new Sprite(atlas.findRegion("bg_class_2_sel"));
        bg_class_3_sel = new Sprite(atlas.findRegion("bg_class_3_sel"));
        bg_class_4_sel = new Sprite(atlas.findRegion("bg_class_4_sel"));
        bg_class_5_sel = new Sprite(atlas.findRegion("bg_class_5_sel"));
        bg_class_6_sel = new Sprite(atlas.findRegion("bg_class_6_sel"));
        bg_class_7_sel = new Sprite(atlas.findRegion("bg_class_7_sel"));
        bg_class_8_sel = new Sprite(atlas.findRegion("bg_class_8_sel"));
        armor_class0 = new Sprite(atlas.findRegion("armor_class0"));
        armor_class1 = new Sprite(atlas.findRegion("armor_class1"));
        armor_class2 = new Sprite(atlas.findRegion("armor_class2"));
        armor_class3 = new Sprite(atlas.findRegion("armor_class3"));
        armor_class4 = new Sprite(atlas.findRegion("armor_class4"));
        armor_class5 = new Sprite(atlas.findRegion("armor_class5"));
        armor_class6 = new Sprite(atlas.findRegion("armor_class6"));
        armor_class7 = new Sprite(atlas.findRegion("armor_class7"));
        armor_class8 = new Sprite(atlas.findRegion("armor_class8"));
        class0 = new Sprite(atlas.findRegion("class0"));
        class1 = new Sprite(atlas.findRegion("class1"));
        class2 = new Sprite(atlas.findRegion("class2"));
        class3 = new Sprite(atlas.findRegion("class3"));
        class4 = new Sprite(atlas.findRegion("class4"));
        class5 = new Sprite(atlas.findRegion("class5"));
        class6 = new Sprite(atlas.findRegion("class6"));
        class7 = new Sprite(atlas.findRegion("class7"));
        class8 = new Sprite(atlas.findRegion("class8"));
    }

    public static Sprite getItemLayer(int itemClass, boolean isArmor) {
        Sprite result = null;
        switch(itemClass) {
            case 0:
                if (isArmor) {
                    result = armor_class0;
                } else {
                    result = class0;
                }
                break;
            case 1:
                if (isArmor) {
                    result = armor_class1;
                } else {
                    result = class1;
                }
                break;
            case 2:
                if (isArmor) {
                    result = armor_class2;
                } else {
                    result = class2;
                }
                break;
            case 3:
                if (isArmor) {
                    result = armor_class3;
                } else {
                    result = class3;
                }
                break;
            case 4:
                if (isArmor) {
                    result = armor_class4;
                } else {
                    result = class4;
                }
                break;
            case 5:
                if (isArmor) {
                    result = armor_class5;
                } else {
                    result = class5;
                }
                break;
            case 6:
                if (isArmor) {
                    result = armor_class6;
                } else {
                    result = class6;
                }
                break;
            case 7:
                if (isArmor) {
                    result = armor_class7;
                } else {
                    result = class7;
                }
                break;
            case 8:
                if (isArmor) {
                    result = armor_class8;
                } else {
                    result = class8;
                }
        }

        return result;
    }

    public static Sprite getInfoLayer(int itemClass, boolean isSelected) {
        Sprite result = null;
        switch(itemClass) {
            case 0:
                if (!isSelected) {
                    result = bg_class0;
                } else {
                    result = bg_class_0_sel;
                }
                break;
            case 1:
                if (!isSelected) {
                    result = bg_class1;
                } else {
                    result = bg_class_1_sel;
                }
                break;
            case 2:
                if (!isSelected) {
                    result = bg_class2;
                } else {
                    result = bg_class_2_sel;
                }
                break;
            case 3:
                if (!isSelected) {
                    result = bg_class3;
                } else {
                    result = bg_class_3_sel;
                }
                break;
            case 4:
                if (!isSelected) {
                    result = bg_class4;
                } else {
                    result = bg_class_4_sel;
                }
                break;
            case 5:
                if (!isSelected) {
                    result = bg_class5;
                } else {
                    result = bg_class_5_sel;
                }
                break;
            case 6:
                if (!isSelected) {
                    result = bg_class6;
                } else {
                    result = bg_class_6_sel;
                }
                break;
            case 7:
                if (!isSelected) {
                    result = bg_class7;
                } else {
                    result = bg_class_7_sel;
                }
                break;
            case 8:
                if (!isSelected) {
                    result = bg_class8;
                } else {
                    result = bg_class_8_sel;
                }
        }

        return result;
    }
}

