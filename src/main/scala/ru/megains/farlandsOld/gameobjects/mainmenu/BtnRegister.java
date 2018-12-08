package ru.megains.farlandsOld.gameobjects.mainmenu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.megains.farlandsOld.MainMenu;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnRegister extends ImageButton {
    public BtnRegister(Drawable imageUp, Drawable imageDown, final MainMenu mainMenu) {
        super(imageUp, imageDown);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                SendPasket.sendRegister(mainMenu.getLogin(), mainMenu.getPassword());
                return true;
            }
        });
    }
}