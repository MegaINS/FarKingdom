package ru.megains.farlands.old;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {
    private Sprite sprite;

    public MyActor() {
    }

    public MyActor(Sprite sprite) {
        this.sprite = sprite;
        this.setSize(sprite.getWidth(), sprite.getHeight());
        this.setBounds(0.0F, 0.0F, this.getWidth(), this.getHeight());
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
    }

    public void draw(Batch batch, float parentAlpha) {
        if (this.sprite != null) {
            batch.draw(this.sprite, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(), this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
        }
    }

    public void trim(int w, int h) {
        int sdvigX = (int)((this.sprite.getWidth() - (float)w) / 2.0F);
        int sdvigY = (int)((this.sprite.getHeight() - (float)h) / 2.0F);
        Sprite newSprite = new Sprite(this.sprite.getTexture(), this.sprite.getRegionX() + sdvigX, this.sprite.getRegionY() + sdvigY, w, h);
        this.sprite = newSprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
        if (this.getWidth() == 0.0F) {
            this.setSize(sprite.getWidth(), sprite.getHeight());
        }

    }
}
