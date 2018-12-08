package ru.megains.farlandsOld.loaders;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PlayersAtlasLoader {
    private static TextureAtlas atlas;
    private static boolean male;
    public static Sprite red_female;
    public static Sprite red_male;
    public static Sprite idle;
    public static Sprite sleep;
    public static Sprite down_move1;
    public static Sprite down_move2;
    public static Sprite down_move3;
    public static Sprite down_move4;
    public static Sprite left_move1;
    public static Sprite left_move2;
    public static Sprite left_move3;
    public static Sprite left_move4;
    public static Sprite right_move1;
    public static Sprite right_move2;
    public static Sprite right_move3;
    public static Sprite right_move4;
    public static Sprite top_move1;
    public static Sprite top_move2;
    public static Sprite top_move3;
    public static Sprite top_move4;
    public static Sprite extract_res_left1;
    public static Sprite extract_res_left2;
    public static Sprite extract_res_left3;
    public static Sprite extract_res_left4;
    public static Sprite extract_res_left5;
    public static Sprite extract_res_right1;
    public static Sprite extract_res_right2;
    public static Sprite extract_res_right3;
    public static Sprite extract_res_right4;
    public static Sprite extract_res_right5;
    public static Sprite extract_res_top1;
    public static Sprite extract_res_top2;
    public static Sprite extract_res_top3;
    public static Sprite extract_res_top4;
    public static Sprite extract_res_top5;
    public static Sprite extract_res_down1;
    public static Sprite extract_res_down2;
    public static Sprite extract_res_down3;
    public static Sprite extract_res_down4;
    public static Sprite extract_res_down5;

    public PlayersAtlasLoader() {
    }

    public static void load(boolean isMale) {
        male = isMale;
        atlas = new TextureAtlas(Gdx.files.internal("players/moveAnimatoins.pack"));
        red_female = new Sprite(atlas.findRegion("red_female"));
        red_male = new Sprite(atlas.findRegion("red_male"));
        if (isMale) {
            idle = new Sprite(atlas.findRegion("idle_male"));
            sleep = new Sprite(atlas.findRegion("sleep_male"));
            down_move1 = new Sprite(atlas.findRegion("male_down_move1"));
            down_move2 = new Sprite(atlas.findRegion("male_down_move2"));
            down_move3 = new Sprite(atlas.findRegion("male_down_move3"));
            down_move4 = new Sprite(atlas.findRegion("male_down_move4"));
            left_move1 = new Sprite(atlas.findRegion("male_left_move1"));
            left_move2 = new Sprite(atlas.findRegion("male_left_move2"));
            left_move3 = new Sprite(atlas.findRegion("male_left_move3"));
            left_move4 = new Sprite(atlas.findRegion("male_left_move4"));
            right_move1 = new Sprite(atlas.findRegion("male_right_move1"));
            right_move2 = new Sprite(atlas.findRegion("male_right_move2"));
            right_move3 = new Sprite(atlas.findRegion("male_right_move3"));
            right_move4 = new Sprite(atlas.findRegion("male_right_move4"));
            top_move1 = new Sprite(atlas.findRegion("male_top_move1"));
            top_move2 = new Sprite(atlas.findRegion("male_top_move2"));
            top_move3 = new Sprite(atlas.findRegion("male_top_move3"));
            top_move4 = new Sprite(atlas.findRegion("male_top_move4"));
        } else {
            idle = new Sprite(atlas.findRegion("idle_male"));
            sleep = new Sprite(atlas.findRegion("sleep_female"));
            down_move1 = new Sprite(atlas.findRegion("female_down_move1"));
            down_move2 = new Sprite(atlas.findRegion("female_down_move2"));
            down_move3 = new Sprite(atlas.findRegion("female_down_move3"));
            down_move4 = new Sprite(atlas.findRegion("female_down_move4"));
            left_move1 = new Sprite(atlas.findRegion("female_left_move1"));
            left_move2 = new Sprite(atlas.findRegion("female_left_move2"));
            left_move3 = new Sprite(atlas.findRegion("female_left_move3"));
            left_move4 = new Sprite(atlas.findRegion("female_left_move4"));
            right_move1 = new Sprite(atlas.findRegion("female_right_move1"));
            right_move2 = new Sprite(atlas.findRegion("female_right_move2"));
            right_move3 = new Sprite(atlas.findRegion("female_right_move3"));
            right_move4 = new Sprite(atlas.findRegion("female_right_move4"));
            top_move1 = new Sprite(atlas.findRegion("female_top_move1"));
            top_move2 = new Sprite(atlas.findRegion("female_top_move2"));
            top_move3 = new Sprite(atlas.findRegion("female_top_move3"));
            top_move4 = new Sprite(atlas.findRegion("female_top_move4"));
        }

    }

    public static void loadLocAnimations(int locCellType) {
        if (locCellType != 1 && locCellType != 4 && !male) {
            if (locCellType == 1 || locCellType == 4 || !male) {
                extract_res_left1 = new Sprite(atlas.findRegion("female_wood_left1"));
                extract_res_left2 = new Sprite(atlas.findRegion("female_wood_left2"));
                extract_res_left3 = new Sprite(atlas.findRegion("female_wood_left3"));
                extract_res_left4 = new Sprite(atlas.findRegion("female_wood_left4"));
                extract_res_left5 = new Sprite(atlas.findRegion("female_wood_left5"));
                extract_res_right1 = new Sprite(atlas.findRegion("female_wood_right1"));
                extract_res_right2 = new Sprite(atlas.findRegion("female_wood_right2"));
                extract_res_right3 = new Sprite(atlas.findRegion("female_wood_right3"));
                extract_res_right4 = new Sprite(atlas.findRegion("female_wood_right4"));
                extract_res_right5 = new Sprite(atlas.findRegion("female_wood_right5"));
                extract_res_top1 = new Sprite(atlas.findRegion("female_wood_top1"));
                extract_res_top2 = new Sprite(atlas.findRegion("female_wood_top2"));
                extract_res_top3 = new Sprite(atlas.findRegion("female_wood_top3"));
                extract_res_top4 = new Sprite(atlas.findRegion("female_wood_top4"));
                extract_res_top5 = new Sprite(atlas.findRegion("female_wood_top5"));
                extract_res_down1 = new Sprite(atlas.findRegion("female_wood_down1"));
                extract_res_down2 = new Sprite(atlas.findRegion("female_wood_down2"));
                extract_res_down3 = new Sprite(atlas.findRegion("female_wood_down3"));
                extract_res_down4 = new Sprite(atlas.findRegion("female_wood_down4"));
                extract_res_down5 = new Sprite(atlas.findRegion("female_wood_down5"));
            }
        } else {
            extract_res_left1 = new Sprite(atlas.findRegion("male_wood_left1"));
            extract_res_left2 = new Sprite(atlas.findRegion("male_wood_left2"));
            extract_res_left3 = new Sprite(atlas.findRegion("male_wood_left3"));
            extract_res_left4 = new Sprite(atlas.findRegion("male_wood_left4"));
            extract_res_left5 = new Sprite(atlas.findRegion("male_wood_left5"));
            extract_res_right1 = new Sprite(atlas.findRegion("male_wood_right1"));
            extract_res_right2 = new Sprite(atlas.findRegion("male_wood_right2"));
            extract_res_right3 = new Sprite(atlas.findRegion("male_wood_right3"));
            extract_res_right4 = new Sprite(atlas.findRegion("male_wood_right4"));
            extract_res_right5 = new Sprite(atlas.findRegion("male_wood_right5"));
            extract_res_top1 = new Sprite(atlas.findRegion("male_wood_top1"));
            extract_res_top2 = new Sprite(atlas.findRegion("male_wood_top2"));
            extract_res_top3 = new Sprite(atlas.findRegion("male_wood_top3"));
            extract_res_top4 = new Sprite(atlas.findRegion("male_wood_top4"));
            extract_res_top5 = new Sprite(atlas.findRegion("male_wood_top5"));
            extract_res_down1 = new Sprite(atlas.findRegion("male_wood_down1"));
            extract_res_down2 = new Sprite(atlas.findRegion("male_wood_down2"));
            extract_res_down3 = new Sprite(atlas.findRegion("male_wood_down3"));
            extract_res_down4 = new Sprite(atlas.findRegion("male_wood_down4"));
            extract_res_down5 = new Sprite(atlas.findRegion("male_wood_down5"));
        }

    }
}
