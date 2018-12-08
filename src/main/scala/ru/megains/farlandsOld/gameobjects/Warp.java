package ru.megains.farlandsOld.gameobjects;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import ru.megains.farlandsOld.loaders.DangeAtlasLoader;

public class Warp extends Actor {
    public static final int ANTIRIA_TO_SITY_FOREST = 1;
    public static final int ANTIRIA_TO_SITY_MINE = 2;
    public static final int ANTIRIA_TO_SITY_HUNTING = 3;
    public static final int ANTIRIA_SCLAD = 4;
    public static final int ANTIRIA_SHOP_RES = 5;
    public static final int ANTIRIA_SHOP_BOOKS = 6;
    public static final int ANTIRIA_SHOP_JEWELS = 7;
    public static final int ANTIRIA_SHOP_WEAPON = 8;
    private int warpId;
    private String title;
    private Sprite sprite = null;

    public Warp(String title, int warpId, Vector2 warpPosition) {
        this.setBounds(0.0F, 0.0F, 100.0F, 100.0F);
        this.title = title;
        this.setPosition(warpPosition.x * 100.0F, warpPosition.y * 100.0F);
        this.warpId = warpId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setSpriteOut() {
        this.sprite = DangeAtlasLoader.exit;
    }

    public void setSpriteIn() {
        this.sprite = DangeAtlasLoader.enter;
    }

    public void draw(Batch batch, float parentAlpha) {
        if (this.sprite != null) {
            batch.draw(this.sprite, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(), this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
        }

    }

    public int getWarpId() {
        return this.warpId;
    }
}

