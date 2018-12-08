package ru.megains.farlandsOld.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class TumanMaskActor extends MyActor {
    public TumanMaskActor(Sprite sprite) {
        super(sprite);
        this.setTouchable(Touchable.disabled);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return false;
            }
        });
    }
}
