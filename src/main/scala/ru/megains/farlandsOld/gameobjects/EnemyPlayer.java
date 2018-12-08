package ru.megains.farlandsOld.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class EnemyPlayer extends MyActor {
    public EnemyPlayer(Sprite sprite, String name) {
        super(sprite);
        super.setName(name);
    }

    public void setPosition(float x, float y) {
        super.setPosition(x * 100.0F, y * 100.0F);
    }

    public void act(float delta) {
        super.act(delta);
        this.setZIndex(6);
    }
}
