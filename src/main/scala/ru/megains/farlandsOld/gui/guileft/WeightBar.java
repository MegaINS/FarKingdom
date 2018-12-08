package ru.megains.farlandsOld.gui.guileft;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyAnimatedActor;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.tooltip.SimpleTooltip;

public class WeightBar extends MyAnimatedActor {
    private int frameCols = 5;
    private int frameRows = 1;
    private Array<Sprite> bars;
    private Sprite green;
    private SimpleTooltip tooltip;

    public WeightBar() {
        super(0.15F);
        this.green = GuiAtlasLoader.bar_weight;
        this.bars = new Array();
        Texture animationSheet = new Texture(Gdx.files.internal("gui/animations/weight_bar_anim.png"));
        TextureRegion[][] tmp = TextureRegion.split(animationSheet, animationSheet.getWidth() / this.frameCols, animationSheet.getHeight() / this.frameRows);

        for(int i = 0; i < this.frameRows; ++i) {
            for(int j = 0; j < this.frameCols; ++j) {
                this.bars.add(new Sprite(tmp[i][j]));
            }
        }

        this.tooltip = new SimpleTooltip("Вес", Styles.tooltipLabel, this);
    }

    public void start() {
        this.setAnimation(this.bars);
        super.start();
    }

    public void stop() {
        super.stop();
        this.setSprite(this.green);
    }

    public void update(float current, float max) {
        this.tooltip.update(" " + current + "/" + max);
    }
}

