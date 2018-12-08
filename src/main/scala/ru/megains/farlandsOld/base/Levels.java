package ru.megains.farlandsOld.base;

public abstract class Levels {
    private static final String ANTIRIA = "levels/antiria/antiria.tmx";
    private static final String FIRST = "levels/first/first.tmx";
    private static final String TUMAN = "levels/tuman/tuman.tmx";

    public Levels() {
    }

    public static String getLevel(int levelId) {
        String result = null;
        switch(levelId) {
            case 1:
                result = "levels/antiria/antiria.tmx";
                break;
            case 2:
                result = "levels/first/first.tmx";
                break;
            case 3:
                result = "levels/tuman/tuman.tmx";
        }

        return result;
    }
}
