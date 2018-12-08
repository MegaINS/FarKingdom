package ru.megains.farlands.old;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public abstract class Levels {
    private static final String ANTIRIA = "levels/antiria/antiria.tmx";
    private static final String FIRST = "levels/first/first.tmx";
    private static final String TUMAN = "levels/tuman/tuman.tmx";
    private static TiledMap ANTIRIA_MAP = null;
    private static TiledMap FIRST_MAP = null;
    private static TiledMap TUMAN_MAP = null;
    private static boolean load = false;
    private static final AssetManager  assetManager = new AssetManager();






    public Levels() {
    }

    public static void load() {
        assetManager.setLoader( TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
        assetManager.load(ANTIRIA, TiledMap.class);
        assetManager.load(FIRST, TiledMap.class);
        assetManager.load(TUMAN, TiledMap.class);
        assetManager.finishLoading();
        ANTIRIA_MAP = assetManager.get(ANTIRIA);
        FIRST_MAP = assetManager.get(FIRST);
        TUMAN_MAP = assetManager.get(TUMAN);
    }

//    public static String getLevel(int levelId) {
//        String result = null;
//        switch(levelId) {
//            case 1:
//                result = ANTIRIA;
//                break;
//            case 2:
//                result = "levels/first/first.tmx";
//                break;
//            case 3:
//                result = "levels/tuman/tuman.tmx";
//        }
//
//        return result;
//    }


    public static TiledMap getLevel(int levelId) {


        TiledMap result = null;
        switch(levelId) {
            case 1:
                result = ANTIRIA_MAP;
                break;
            case 2:
                result = FIRST_MAP;
                break;
            case 3:
                result = TUMAN_MAP;
        }

        return result;
    }


}
