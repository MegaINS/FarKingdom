package ru.megains.farlands.old;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class MyAnimatedActor extends MyActor {
    private float animTime;
    private float curentAnimTime;
    private int lenght;
    private int curentFrame;
    private Array<Sprite> frames;
    private boolean played;

    public MyAnimatedActor(float animTime) {
        this.animTime = animTime;
        this.played = false;
    }

    public MyAnimatedActor(Array<Sprite> frames, float animTime) {
        super((Sprite)frames.get(0));
        this.frames = frames;
        this.animTime = animTime;
        this.lenght = frames.size;
        this.curentFrame = 0;
        this.curentAnimTime = 0.0F;
        this.played = false;

        for(int i = 0; i < frames.size; ++i) {
            if (this.getWidth() < ((Sprite)frames.get(i)).getWidth()) {
                this.setWidth(((Sprite)frames.get(i)).getWidth());
            }
        }

    }

    public MyAnimatedActor(Array<Sprite> frames, float animTime, boolean animStart) {
        super((Sprite)frames.get(0));
        this.frames = frames;
        this.animTime = animTime;
        this.lenght = frames.size;
        this.curentFrame = 0;
        this.curentAnimTime = 0.0F;
        this.played = animStart;

        for(int i = 0; i < frames.size; ++i) {
            if (this.getWidth() < ((Sprite)frames.get(i)).getWidth()) {
                this.setWidth(((Sprite)frames.get(i)).getWidth());
            }
        }

    }

    public void setAnimation(Array<Sprite> frames) {
        this.frames = frames;
        this.lenght = frames.size;
        this.curentFrame = 0;
        this.curentAnimTime = 0.0F;
        super.setSprite((Sprite)frames.get(0));

        for(int i = 0; i < frames.size; ++i) {
            if (this.getWidth() < ((Sprite)frames.get(i)).getWidth()) {
                this.setWidth(((Sprite)frames.get(i)).getWidth());
            }
        }

    }

    public MyAnimatedActor instance() {
        return new MyAnimatedActor(this.frames, this.animTime, this.played);
    }

    public void start() {
        this.played = true;
    }

    public void stop() {
        this.played = false;
    }

    public void act(float delta) {
        super.act(delta);
        if (this.played) {
            if (this.frames != null && this.frames.size > 0) {
                if (this.curentAnimTime < this.animTime) {
                    this.curentAnimTime += delta;
                } else if (this.curentFrame < this.lenght - 1) {
                    this.setSprite((Sprite)this.frames.get(++this.curentFrame));
                    this.curentAnimTime = 0.0F;
                } else {
                    this.setSprite((Sprite)this.frames.get(0));
                    this.curentFrame = 0;
                    this.curentAnimTime = 0.0F;
                }

            }
        }
    }
}

