package ru.megains.farlandsOld.gui.guibottom;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import ru.megains.farlandsOld.gameobjects.MyAnimatedActor;

public class Smile extends MyAnimatedActor {
    public Smile(Array<Sprite> frames, final String name, final TextField inputMessage) {
        super(frames, 0.14F, true);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                inputMessage.appendText(":" + name + ":");
                return true;
            }
        });
    }
}
