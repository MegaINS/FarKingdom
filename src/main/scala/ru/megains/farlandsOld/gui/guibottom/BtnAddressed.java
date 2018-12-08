package ru.megains.farlandsOld.gui.guibottom;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class BtnAddressed extends ImageButton {
    public BtnAddressed(Drawable imageUp, final String sender, final TextField inputMessage) {
        super(imageUp);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (inputMessage.getText().length() > 0 && inputMessage.getText().substring(0, 1).equals("#")) {
                    return true;
                } else {
                    inputMessage.setText("#Адресно для для >> " + sender + " : " + inputMessage.getText());
                    inputMessage.setCursorPosition(inputMessage.getText().length());
                    return true;
                }
            }
        });
    }
}
