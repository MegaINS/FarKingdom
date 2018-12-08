package ru.megains.farlandsOld.battle;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Fonts;
import ru.megains.farlandsOld.loaders.BattleAtlasLoader;

public class BattleLogTable extends Table {
    private Label.LabelStyle stylePlayer;
    private Label.LabelStyle styleEnemy;
    private Label.LabelStyle styleRound;

    public BattleLogTable() {
        this.padLeft(20.0F);
        this.padRight(20.0F);
        this.setBackground(new SpriteDrawable(BattleAtlasLoader.bg_all2));
        this.stylePlayer = new Label.LabelStyle();
        this.stylePlayer.fontColor = Color.GREEN;
        this.stylePlayer.font = Fonts.ARENA_TIMES.get();
        this.styleEnemy = new Label.LabelStyle();
        this.styleEnemy.fontColor = Color.RED;
        this.styleEnemy.font = Fonts.ARENA_TIMES.get();
        this.styleRound = new Label.LabelStyle();
        this.styleRound.fontColor = Color.BLACK;
        this.styleRound.font = Fonts.ARENA_TIMES.get();
    }

    public void setDefaults(int c1, int c2) {
    }

    public void finishRound(int round, String playerStr, String enemyStr) {
        this.row();
        Table table = (new Table()).top().left();
        table.add(new Label("Вы: ", this.stylePlayer)).left().top();
        table.add(new Label(playerStr, this.stylePlayer)).left();
        this.add(table).left().top().prefWidth(800.0F);
        Table table1 = (new Table()).top().right();
        table1.add(new Label("Противник: ", this.styleEnemy)).right().top();
        table1.add(new Label(enemyStr, this.styleEnemy)).right().prefWidth(800.0F);
        this.add(table1).top().right();
        this.row();
    }
}
