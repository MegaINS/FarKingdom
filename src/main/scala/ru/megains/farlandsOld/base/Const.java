package ru.megains.farlandsOld.base;

import org.jboss.netty.channel.Channel;
import ru.megains.farlandsOld.GameScreen;
import ru.megains.farlandsOld.FMain;
import ru.megains.farlandsOld.MainMenu;

public abstract class Const {
    public static final int port = 15453;
    public static final String host = "91.201.42.21";
    public static final String GAME_VERSION = "0.11";
    public static final float SCREEN_WIDTH = 1024.0F;
    public static final float SCREEN_HEIGHT = 768.0F;
    public static Channel channel = null;
    public static FMain game = null;
    public static GameScreen screen;
    public static MainMenu mainMenu = null;

    public Const() {
    }
}

