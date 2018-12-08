package ru.megains.farlandsOld.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.HashMap;

public class ArmorEquipedAtlasLoader {
    private static TextureAtlas atlas;
    private static HashMap<Integer, Sprite> items = new HashMap();

    public ArmorEquipedAtlasLoader() {
    }

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("items/armorequip.pack"));
        Sprite item = new Sprite(atlas.findRegion("amr_armor_banded1"));
        items.put(64, item);
        item = new Sprite(atlas.findRegion("amr_armor_banded2"));
        items.put(65, item);
        item = new Sprite(atlas.findRegion("amr_armor_banded3"));
        items.put(66, item);
        item = new Sprite(atlas.findRegion("amr_armor_banded4"));
        items.put(67, item);
        item = new Sprite(atlas.findRegion("amr_armor_banded5"));
        items.put(68, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain1"));
        items.put(69, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain2"));
        items.put(70, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain3"));
        items.put(71, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain3r"));
        items.put(72, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain4"));
        items.put(73, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain5"));
        items.put(74, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain6"));
        items.put(75, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain6g"));
        items.put(76, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain7"));
        items.put(77, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain8"));
        items.put(78, item);
        item = new Sprite(atlas.findRegion("amr_armor_chain9"));
        items.put(79, item);
        item = new Sprite(atlas.findRegion("amr_armor_hunter1"));
        items.put(80, item);
        item = new Sprite(atlas.findRegion("amr_armor_hunter2"));
        items.put(81, item);
        item = new Sprite(atlas.findRegion("amr_armor_hunter3"));
        items.put(82, item);
        item = new Sprite(atlas.findRegion("amr_armor_hunter4"));
        items.put(83, item);
        item = new Sprite(atlas.findRegion("amr_armor_hunter5"));
        items.put(84, item);
        item = new Sprite(atlas.findRegion("amr_armor_leather1"));
        items.put(85, item);
        item = new Sprite(atlas.findRegion("amr_armor_leather2"));
        items.put(86, item);
        item = new Sprite(atlas.findRegion("amr_armor_leather3"));
        items.put(87, item);
        item = new Sprite(atlas.findRegion("amr_armor_leather4"));
        items.put(88, item);
        item = new Sprite(atlas.findRegion("amr_armor_leather5"));
        items.put(89, item);
        item = new Sprite(atlas.findRegion("amr_armor_leather6"));
        items.put(90, item);
        item = new Sprite(atlas.findRegion("amr_armor_leather7"));
        items.put(91, item);
        item = new Sprite(atlas.findRegion("amr_armor_mine1"));
        items.put(92, item);
        item = new Sprite(atlas.findRegion("amr_armor_mine2"));
        items.put(93, item);
        item = new Sprite(atlas.findRegion("amr_armor_mine3"));
        items.put(94, item);
        item = new Sprite(atlas.findRegion("amr_armor_mine4"));
        items.put(96, item);
        item = new Sprite(atlas.findRegion("amr_armor_mine5"));
        items.put(97, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate_saakri"));
        items.put(98, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate1"));
        items.put(99, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate2"));
        items.put(100, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate3"));
        items.put(101, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate4"));
        items.put(102, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate5"));
        items.put(103, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate6"));
        items.put(104, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate6_l"));
        items.put(105, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate7"));
        items.put(106, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate8"));
        items.put(107, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate9"));
        items.put(108, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate10"));
        items.put(109, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate11"));
        items.put(110, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate12"));
        items.put(111, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate13"));
        items.put(112, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate14"));
        items.put(113, item);
        item = new Sprite(atlas.findRegion("amr_armor_plate15"));
        items.put(114, item);
        item = new Sprite(atlas.findRegion("amr_armor_wood1"));
        items.put(115, item);
        item = new Sprite(atlas.findRegion("amr_armor_wood2"));
        items.put(116, item);
        item = new Sprite(atlas.findRegion("amr_armor_wood3"));
        items.put(117, item);
        item = new Sprite(atlas.findRegion("amr_armor_wood4"));
        items.put(118, item);
        item = new Sprite(atlas.findRegion("amr_armor_wood5"));
        items.put(119, item);
    }

    public static Sprite getItem(int id) {
        return (Sprite)items.get(id);
    }
}

