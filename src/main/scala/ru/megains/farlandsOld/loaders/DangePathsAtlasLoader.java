package ru.megains.farlandsOld.loaders;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class DangePathsAtlasLoader {
    private static TextureAtlas atlas;
    private static TextureAtlas izvestniakAtlas;
    public static Sprite path0;
    public static Sprite path1;
    public static Sprite path2;
    public static Sprite path3;
    public static Sprite path4;
    public static Sprite path5;
    public static Sprite path6;
    public static Sprite path7;
    public static Sprite path8;
    public static Sprite path9;
    public static Sprite path10;
    public static Sprite path11;
    public static Sprite path12;
    public static Sprite path13;
    public static Sprite path14;
    public static Sprite path15;

    public DangePathsAtlasLoader() {
    }

    public static void load(int locCellType) {
        atlas = new TextureAtlas(Gdx.files.internal("danges/paths.pack"));
        izvestniakAtlas = new TextureAtlas(Gdx.files.internal("danges/izvestnyakPath.pack"));
        switch(locCellType) {
            case 1:
                path0 = new Sprite(atlas.findRegion("forest_bush0"));
                path1 = new Sprite(atlas.findRegion("forest_bush1"));
                path2 = new Sprite(atlas.findRegion("forest_bush2"));
                path3 = new Sprite(atlas.findRegion("forest_bush3"));
                path4 = new Sprite(atlas.findRegion("forest_bush4"));
                path5 = new Sprite(atlas.findRegion("forest_bush5"));
                path6 = new Sprite(atlas.findRegion("forest_bush6"));
                path7 = new Sprite(atlas.findRegion("forest_bush7"));
                path8 = new Sprite(atlas.findRegion("forest_bush8"));
                path9 = new Sprite(atlas.findRegion("forest_bush9"));
                path10 = new Sprite(atlas.findRegion("forest_bush10"));
                path11 = new Sprite(atlas.findRegion("forest_bush11"));
                path12 = new Sprite(atlas.findRegion("forest_bush12"));
                path13 = new Sprite(atlas.findRegion("forest_bush13"));
                path14 = new Sprite(atlas.findRegion("forest_bush14"));
                path15 = new Sprite(atlas.findRegion("forest_bush15"));
                break;
            case 2:
                path0 = new Sprite(atlas.findRegion("hunting_green0"));
                path1 = new Sprite(atlas.findRegion("hunting_green1"));
                path2 = new Sprite(atlas.findRegion("hunting_green2"));
                path3 = new Sprite(atlas.findRegion("hunting_green3"));
                path4 = new Sprite(atlas.findRegion("hunting_green4"));
                path5 = new Sprite(atlas.findRegion("hunting_green5"));
                path6 = new Sprite(atlas.findRegion("hunting_green6"));
                path7 = new Sprite(atlas.findRegion("hunting_green7"));
                path8 = new Sprite(atlas.findRegion("hunting_green8"));
                path9 = new Sprite(atlas.findRegion("hunting_green9"));
                path10 = new Sprite(atlas.findRegion("hunting_green10"));
                path11 = new Sprite(atlas.findRegion("hunting_green11"));
                path12 = new Sprite(atlas.findRegion("hunting_green12"));
                path13 = new Sprite(atlas.findRegion("hunting_green13"));
                path14 = new Sprite(atlas.findRegion("hunting_green14"));
                path15 = new Sprite(atlas.findRegion("hunting_green15"));
                break;
            case 3:
                path0 = new Sprite(atlas.findRegion("peschanik0"));
                path1 = new Sprite(atlas.findRegion("peschanik1"));
                path2 = new Sprite(atlas.findRegion("peschanik2"));
                path3 = new Sprite(atlas.findRegion("peschanik3"));
                path4 = new Sprite(atlas.findRegion("peschanik4"));
                path5 = new Sprite(atlas.findRegion("peschanik5"));
                path6 = new Sprite(atlas.findRegion("peschanik6"));
                path7 = new Sprite(atlas.findRegion("peschanik7"));
                path8 = new Sprite(atlas.findRegion("peschanik8"));
                path9 = new Sprite(atlas.findRegion("peschanik9"));
                path10 = new Sprite(atlas.findRegion("peschanik10"));
                path11 = new Sprite(atlas.findRegion("peschanik11"));
                path12 = new Sprite(atlas.findRegion("peschanik12"));
                path13 = new Sprite(atlas.findRegion("peschanik13"));
                path14 = new Sprite(atlas.findRegion("peschanik14"));
                path15 = new Sprite(atlas.findRegion("peschanik15"));
                break;
            case 4:
                path0 = new Sprite(atlas.findRegion("forest_2a0"));
                path1 = new Sprite(atlas.findRegion("forest_2a1"));
                path2 = new Sprite(atlas.findRegion("forest_2a2"));
                path3 = new Sprite(atlas.findRegion("forest_2a3"));
                path4 = new Sprite(atlas.findRegion("forest_2a4"));
                path5 = new Sprite(atlas.findRegion("forest_2a5"));
                path6 = new Sprite(atlas.findRegion("forest_2a6"));
                path7 = new Sprite(atlas.findRegion("forest_2a7"));
                path8 = new Sprite(atlas.findRegion("forest_2a8"));
                path9 = new Sprite(atlas.findRegion("forest_2a9"));
                path10 = new Sprite(atlas.findRegion("forest_2a10"));
                path11 = new Sprite(atlas.findRegion("forest_2a11"));
                path12 = new Sprite(atlas.findRegion("forest_2a12"));
                path13 = new Sprite(atlas.findRegion("forest_2a13"));
                path14 = new Sprite(atlas.findRegion("forest_2a14"));
                path15 = new Sprite(atlas.findRegion("forest_2a15"));
                break;
            case 5:
                path0 = new Sprite(atlas.findRegion("hunting_3b0"));
                path1 = new Sprite(atlas.findRegion("hunting_3b1"));
                path2 = new Sprite(atlas.findRegion("hunting_3b2"));
                path3 = new Sprite(atlas.findRegion("hunting_3b3"));
                path4 = new Sprite(atlas.findRegion("hunting_3b4"));
                path5 = new Sprite(atlas.findRegion("hunting_3b5"));
                path6 = new Sprite(atlas.findRegion("hunting_3b6"));
                path7 = new Sprite(atlas.findRegion("hunting_3b7"));
                path8 = new Sprite(atlas.findRegion("hunting_3b8"));
                path9 = new Sprite(atlas.findRegion("hunting_3b9"));
                path10 = new Sprite(atlas.findRegion("hunting_3b10"));
                path11 = new Sprite(atlas.findRegion("hunting_3b11"));
                path12 = new Sprite(atlas.findRegion("hunting_3b12"));
                path13 = new Sprite(atlas.findRegion("hunting_3b13"));
                path14 = new Sprite(atlas.findRegion("hunting_3b14"));
                path15 = new Sprite(atlas.findRegion("hunting_3b15"));
                break;
            case 6:
                path0 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_0a"));
                path1 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_1a"));
                path2 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_2a"));
                path3 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_3a"));
                path4 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_5a"));
                path5 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_4a"));
                path6 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_6a"));
                path7 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_7a"));
                path8 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_8a"));
                path9 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_9a"));
                path10 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_10a"));
                path11 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_11a"));
                path12 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_12a"));
                path13 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_13a"));
                path14 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_14a"));
                path15 = new Sprite(izvestniakAtlas.findRegion("izvestnyak_15a"));
                break;
            case 7:
                path0 = new Sprite(atlas.findRegion("granit0"));
                path1 = new Sprite(atlas.findRegion("granit1"));
                path2 = new Sprite(atlas.findRegion("granit2"));
                path3 = new Sprite(atlas.findRegion("granit3"));
                path4 = new Sprite(atlas.findRegion("granit4"));
                path5 = new Sprite(atlas.findRegion("granit5"));
                path6 = new Sprite(atlas.findRegion("granit6"));
                path7 = new Sprite(atlas.findRegion("granit7"));
                path8 = new Sprite(atlas.findRegion("granit8"));
                path9 = new Sprite(atlas.findRegion("granit9"));
                path10 = new Sprite(atlas.findRegion("granit10"));
                path11 = new Sprite(atlas.findRegion("granit11"));
                path12 = new Sprite(atlas.findRegion("granit12"));
                path13 = new Sprite(atlas.findRegion("granit13"));
                path14 = new Sprite(atlas.findRegion("granit14"));
                path15 = new Sprite(atlas.findRegion("granit15"));
                break;
            case 8:
                path0 = new Sprite(atlas.findRegion("forest_1a0"));
                path1 = new Sprite(atlas.findRegion("forest_1a1"));
                path2 = new Sprite(atlas.findRegion("forest_1a2"));
                path3 = new Sprite(atlas.findRegion("forest_1a3"));
                path4 = new Sprite(atlas.findRegion("forest_1a4"));
                path5 = new Sprite(atlas.findRegion("forest_1a5"));
                path6 = new Sprite(atlas.findRegion("forest_1a6"));
                path7 = new Sprite(atlas.findRegion("forest_1a7"));
                path8 = new Sprite(atlas.findRegion("forest_1a8"));
                path9 = new Sprite(atlas.findRegion("forest_1a9"));
                path10 = new Sprite(atlas.findRegion("forest_1a10"));
                path11 = new Sprite(atlas.findRegion("forest_1a11"));
                path12 = new Sprite(atlas.findRegion("forest_1a12"));
                path13 = new Sprite(atlas.findRegion("forest_1a13"));
                path14 = new Sprite(atlas.findRegion("forest_1a14"));
                path15 = new Sprite(atlas.findRegion("forest_1a15"));
                break;
            case 9:
                path0 = new Sprite(atlas.findRegion("hunting_2a0"));
                path1 = new Sprite(atlas.findRegion("hunting_2a1"));
                path2 = new Sprite(atlas.findRegion("hunting_2a2"));
                path3 = new Sprite(atlas.findRegion("hunting_2a3"));
                path4 = new Sprite(atlas.findRegion("hunting_2a4"));
                path5 = new Sprite(atlas.findRegion("hunting_2a5"));
                path6 = new Sprite(atlas.findRegion("hunting_2a6"));
                path7 = new Sprite(atlas.findRegion("hunting_2a7"));
                path8 = new Sprite(atlas.findRegion("hunting_2a8"));
                path9 = new Sprite(atlas.findRegion("hunting_2a9"));
                path10 = new Sprite(atlas.findRegion("hunting_2a10"));
                path11 = new Sprite(atlas.findRegion("hunting_2a11"));
                path12 = new Sprite(atlas.findRegion("hunting_2a12"));
                path13 = new Sprite(atlas.findRegion("hunting_2a13"));
                path14 = new Sprite(atlas.findRegion("hunting_2a14"));
                path15 = new Sprite(atlas.findRegion("hunting_2a15"));
                break;
            case 10:
                path0 = new Sprite(atlas.findRegion("granit_a0"));
                path1 = new Sprite(atlas.findRegion("granit_a1"));
                path2 = new Sprite(atlas.findRegion("granit_a2"));
                path3 = new Sprite(atlas.findRegion("granit_a3"));
                path4 = new Sprite(atlas.findRegion("granit_a4"));
                path5 = new Sprite(atlas.findRegion("granit_a5"));
                path6 = new Sprite(atlas.findRegion("granit_a6"));
                path7 = new Sprite(atlas.findRegion("granit_a7"));
                path8 = new Sprite(atlas.findRegion("granit_a8"));
                path9 = new Sprite(atlas.findRegion("granit_a9"));
                path10 = new Sprite(atlas.findRegion("granit_a10"));
                path11 = new Sprite(atlas.findRegion("granit_a11"));
                path12 = new Sprite(atlas.findRegion("granit_a12"));
                path13 = new Sprite(atlas.findRegion("granit_a13"));
                path14 = new Sprite(atlas.findRegion("granit_a14"));
                path15 = new Sprite(atlas.findRegion("granit_a15"));
                break;
            case 11:
                path0 = new Sprite(atlas.findRegion("forest_2a0"));
                path1 = new Sprite(atlas.findRegion("forest_2a1"));
                path2 = new Sprite(atlas.findRegion("forest_2a2"));
                path3 = new Sprite(atlas.findRegion("forest_2a3"));
                path4 = new Sprite(atlas.findRegion("forest_2a4"));
                path5 = new Sprite(atlas.findRegion("forest_2a5"));
                path6 = new Sprite(atlas.findRegion("forest_2a6"));
                path7 = new Sprite(atlas.findRegion("forest_2a7"));
                path8 = new Sprite(atlas.findRegion("forest_2a8"));
                path9 = new Sprite(atlas.findRegion("forest_2a9"));
                path10 = new Sprite(atlas.findRegion("forest_2a10"));
                path11 = new Sprite(atlas.findRegion("forest_2a11"));
                path12 = new Sprite(atlas.findRegion("forest_2a12"));
                path13 = new Sprite(atlas.findRegion("forest_2a13"));
                path14 = new Sprite(atlas.findRegion("forest_2a14"));
                path15 = new Sprite(atlas.findRegion("forest_2a15"));
                break;
            case 12:
                path0 = new Sprite(atlas.findRegion("hunting_1b0"));
                path1 = new Sprite(atlas.findRegion("hunting_1b1"));
                path2 = new Sprite(atlas.findRegion("hunting_1b2"));
                path3 = new Sprite(atlas.findRegion("hunting_1b3"));
                path4 = new Sprite(atlas.findRegion("hunting_1b4"));
                path5 = new Sprite(atlas.findRegion("hunting_1b5"));
                path6 = new Sprite(atlas.findRegion("hunting_1b6"));
                path7 = new Sprite(atlas.findRegion("hunting_1b7"));
                path8 = new Sprite(atlas.findRegion("hunting_1b8"));
                path9 = new Sprite(atlas.findRegion("hunting_1b9"));
                path10 = new Sprite(atlas.findRegion("hunting_1b10"));
                path11 = new Sprite(atlas.findRegion("hunting_1b11"));
                path12 = new Sprite(atlas.findRegion("hunting_1b12"));
                path13 = new Sprite(atlas.findRegion("hunting_1b13"));
                path14 = new Sprite(atlas.findRegion("hunting_1b14"));
                path15 = new Sprite(atlas.findRegion("hunting_1b15"));
        }

    }
}
