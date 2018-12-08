package ru.megains.farlandsOld.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;

public class TrapsAtlasLoader {
    private static TextureAtlas atlas;
    private static HashMap<Integer, Sprite> traps;

    public TrapsAtlasLoader() {
    }

    public static void load() {
        traps = new HashMap();
        atlas = new TextureAtlas(Gdx.files.internal("danges/traps.pack"));
        Sprite trap = new Sprite(atlas.findRegion("forest_kornevik"));
        traps.put(1, trap);
        trap = new Sprite(atlas.findRegion("forest_monster"));
        traps.put(2, trap);
        trap = new Sprite(atlas.findRegion("forest_shipocvet"));
        traps.put(3, trap);
        trap = new Sprite(atlas.findRegion("forest_vyvoroten"));
        traps.put(4, trap);
        trap = new Sprite(atlas.findRegion("mine_monster"));
        traps.put(5, trap);
        trap = new Sprite(atlas.findRegion("mine_mor"));
        traps.put(6, trap);
        trap = new Sprite(atlas.findRegion("mine_treschatnik"));
        traps.put(7, trap);
        trap = new Sprite(atlas.findRegion("mine_vzriven"));
        traps.put(8, trap);
        trap = new Sprite(atlas.findRegion("unknown"));
        traps.put(9, trap);
    }

    public static Sprite getSpriteById(int id) {
        return (Sprite)traps.get(id);
    }
}
