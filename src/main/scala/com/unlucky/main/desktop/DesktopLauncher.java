package com.unlucky.main.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.unlucky.main.Unlucky;

/**
 * Desktop version access
 */
public class DesktopLauncher {

	public static void main(String[] args) {

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle(Unlucky.TITLE);
        config.setWindowedMode(Unlucky.V_WIDTH * Unlucky.V_SCALE,Unlucky.V_HEIGHT * Unlucky.V_SCALE);
       // config.resizable = false;
       // config.vSyncEnabled = false;
       // config.backgroundFPS = 10;
       // config.foregroundFPS = 60;
       // config.addIcon("desktop_icon128.png", Files.FileType.Internal);
       // config.addIcon("desktop_icon32.png", Files.FileType.Internal);
      //  config.addIcon("desktop_icon16.png", Files.FileType.Internal);
        new Lwjgl3Application(new Unlucky(), config);
    }

}
