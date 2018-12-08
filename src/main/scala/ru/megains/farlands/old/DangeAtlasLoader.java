package ru.megains.farlands.old;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class DangeAtlasLoader {
    private static TextureAtlas atlas;
    public static Sprite bush;
    public static Sprite bush1;
    public static Sprite bush2;
    public static Sprite bush3;
    public static Sprite bush4;
    public static Sprite bush5;
    public static Sprite bush6;
    public static Sprite enter;
    public static Sprite exit;
    public static Sprite mask1;
    public static Sprite mask2;
    public static Sprite mask3;
    public static Sprite mask4;
    public static Sprite mask5;
    public static Sprite mask6;
    public static Sprite mask7;
    public static Sprite mask8;
    public static Sprite mask9;
    public static Sprite mask10;
    public static Sprite mask11;
    public static Sprite mask12;
    public static Sprite mask13;
    public static Sprite mask14;

    public DangeAtlasLoader() {
    }

    public static void load(int locCellType) {
        atlas = new TextureAtlas(Gdx.files.internal("danges/danges.pack"));
        mask1 = new Sprite(atlas.findRegion("mask1"));
        mask2 = new Sprite(atlas.findRegion("mask2"));
        mask3 = new Sprite(atlas.findRegion("mask3"));
        mask4 = new Sprite(atlas.findRegion("mask4"));
        mask5 = new Sprite(atlas.findRegion("mask5"));
        mask6 = new Sprite(atlas.findRegion("mask6"));
        mask7 = new Sprite(atlas.findRegion("mask7"));
        mask8 = new Sprite(atlas.findRegion("mask8"));
        mask9 = new Sprite(atlas.findRegion("mask9"));
        mask10 = new Sprite(atlas.findRegion("mask10"));
        mask11 = new Sprite(atlas.findRegion("mask11"));
        mask12 = new Sprite(atlas.findRegion("mask12"));
        mask13 = new Sprite(atlas.findRegion("mask13"));
        mask14 = new Sprite(atlas.findRegion("mask50"));
        switch(locCellType) {
            case 1:
                bush = new Sprite(atlas.findRegion("forest_bush"));
                bush1 = new Sprite(atlas.findRegion("forest_bush1"));
                bush2 = new Sprite(atlas.findRegion("forest_bush2"));
                bush3 = new Sprite(atlas.findRegion("forest_bush3"));
                bush4 = new Sprite(atlas.findRegion("forest_bush4"));
                bush5 = new Sprite(atlas.findRegion("forest_bush5"));
                bush6 = new Sprite(atlas.findRegion("forest_bush6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
                break;
            case 2:
                bush = new Sprite(atlas.findRegion("hunting_green"));
                bush1 = new Sprite(atlas.findRegion("hunting_green1"));
                bush2 = new Sprite(atlas.findRegion("hunting_green2"));
                bush3 = new Sprite(atlas.findRegion("hunting_green3"));
                bush4 = new Sprite(atlas.findRegion("hunting_green4"));
                bush5 = new Sprite(atlas.findRegion("hunting_green5"));
                bush6 = new Sprite(atlas.findRegion("hunting_green6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
                break;
            case 3:
                bush = new Sprite(atlas.findRegion("peschanik0"));
                bush1 = new Sprite(atlas.findRegion("peschanik1"));
                bush2 = new Sprite(atlas.findRegion("peschanik2"));
                bush3 = new Sprite(atlas.findRegion("peschanik3"));
                bush4 = new Sprite(atlas.findRegion("peschanik4"));
                bush5 = new Sprite(atlas.findRegion("peschanik5"));
                bush6 = new Sprite(atlas.findRegion("peschanik0"));
                enter = new Sprite(atlas.findRegion("mine_stairs"));
                exit = new Sprite(atlas.findRegion("mine_exit"));
                break;
            case 4:
                bush = new Sprite(atlas.findRegion("forest_2a0"));
                bush1 = new Sprite(atlas.findRegion("forest_2a1"));
                bush2 = new Sprite(atlas.findRegion("forest_2a2"));
                bush3 = new Sprite(atlas.findRegion("forest_2a3"));
                bush4 = new Sprite(atlas.findRegion("forest_2a4"));
                bush5 = new Sprite(atlas.findRegion("forest_2a5"));
                bush6 = new Sprite(atlas.findRegion("forest_2a6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
                break;
            case 5:
                bush = new Sprite(atlas.findRegion("hunting_3b0"));
                bush1 = new Sprite(atlas.findRegion("hunting_3b1"));
                bush2 = new Sprite(atlas.findRegion("hunting_3b2"));
                bush3 = new Sprite(atlas.findRegion("hunting_3b3"));
                bush4 = new Sprite(atlas.findRegion("hunting_3b4"));
                bush5 = new Sprite(atlas.findRegion("hunting_3b5"));
                bush6 = new Sprite(atlas.findRegion("hunting_3b6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
                break;
            case 6:
                bush = new Sprite(atlas.findRegion("izvestnyak0"));
                bush1 = new Sprite(atlas.findRegion("izvestnyak1"));
                bush2 = new Sprite(atlas.findRegion("izvestnyak2"));
                bush3 = new Sprite(atlas.findRegion("izvestnyak3"));
                bush4 = new Sprite(atlas.findRegion("izvestnyak4"));
                bush5 = new Sprite(atlas.findRegion("izvestnyak5"));
                bush6 = new Sprite(atlas.findRegion("izvestnyak1"));
                enter = new Sprite(atlas.findRegion("mine_stairs"));
                exit = new Sprite(atlas.findRegion("mine_exit"));
                break;
            case 7:
                bush = new Sprite(atlas.findRegion("granit0"));
                bush1 = new Sprite(atlas.findRegion("granit1"));
                bush2 = new Sprite(atlas.findRegion("granit2"));
                bush3 = new Sprite(atlas.findRegion("granit3"));
                bush4 = new Sprite(atlas.findRegion("granit4"));
                bush5 = new Sprite(atlas.findRegion("granit5"));
                bush6 = new Sprite(atlas.findRegion("granit0"));
                enter = new Sprite(atlas.findRegion("mine_stairs"));
                exit = new Sprite(atlas.findRegion("mine_exit"));
                break;
            case 8:
                bush = new Sprite(atlas.findRegion("forest_1a0"));
                bush1 = new Sprite(atlas.findRegion("forest_1a1"));
                bush2 = new Sprite(atlas.findRegion("forest_1a2"));
                bush3 = new Sprite(atlas.findRegion("forest_1a3"));
                bush4 = new Sprite(atlas.findRegion("forest_1a4"));
                bush5 = new Sprite(atlas.findRegion("forest_1a5"));
                bush6 = new Sprite(atlas.findRegion("forest_1a6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
                break;
            case 9:
                bush = new Sprite(atlas.findRegion("hunting_2a0"));
                bush1 = new Sprite(atlas.findRegion("hunting_2a1"));
                bush2 = new Sprite(atlas.findRegion("hunting_2a2"));
                bush3 = new Sprite(atlas.findRegion("hunting_2a3"));
                bush4 = new Sprite(atlas.findRegion("hunting_2a4"));
                bush5 = new Sprite(atlas.findRegion("hunting_2a5"));
                bush6 = new Sprite(atlas.findRegion("hunting_2a6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
                break;
            case 10:
                bush = new Sprite(atlas.findRegion("granit_a0"));
                bush1 = new Sprite(atlas.findRegion("granit_a1"));
                bush2 = new Sprite(atlas.findRegion("granit_a2"));
                bush3 = new Sprite(atlas.findRegion("granit_a3"));
                bush4 = new Sprite(atlas.findRegion("granit_a4"));
                bush5 = new Sprite(atlas.findRegion("granit_a5"));
                bush6 = new Sprite(atlas.findRegion("granit_a0"));
                enter = new Sprite(atlas.findRegion("mine_stairs"));
                exit = new Sprite(atlas.findRegion("mine_exit"));
                break;
            case 11:
                bush = new Sprite(atlas.findRegion("forest_2a0"));
                bush1 = new Sprite(atlas.findRegion("forest_2a1"));
                bush2 = new Sprite(atlas.findRegion("forest_2a2"));
                bush3 = new Sprite(atlas.findRegion("forest_2a3"));
                bush4 = new Sprite(atlas.findRegion("forest_2a4"));
                bush5 = new Sprite(atlas.findRegion("forest_2a5"));
                bush6 = new Sprite(atlas.findRegion("forest_2a6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
                break;
            case 12:
                bush = new Sprite(atlas.findRegion("hunting_1b0"));
                bush1 = new Sprite(atlas.findRegion("hunting_1b1"));
                bush2 = new Sprite(atlas.findRegion("hunting_1b2"));
                bush3 = new Sprite(atlas.findRegion("hunting_1b3"));
                bush4 = new Sprite(atlas.findRegion("hunting_1b4"));
                bush5 = new Sprite(atlas.findRegion("hunting_1b5"));
                bush6 = new Sprite(atlas.findRegion("hunting_1b6"));
                enter = new Sprite(atlas.findRegion("foresthunting_stairs"));
                exit = new Sprite(atlas.findRegion("foresthunting_exit"));
        }

        System.out.println("DangeAtlasLoader " + locCellType);
    }
}

