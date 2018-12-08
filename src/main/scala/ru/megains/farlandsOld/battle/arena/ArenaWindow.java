package ru.megains.farlandsOld.battle.arena;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class ArenaWindow extends Group {
    private Group bg;
    private Gui gui;
    private int arenaId;
    private ArenaWindowInsiders arena;

    public ArenaWindow(Gui gui, int arenaId) throws ParseException {
        this.gui = gui;
        this.arenaId = arenaId;
        this.arena = new ArenaWindowInsiders(gui, arenaId);
        this.setBounds();
        this.bg = new Group();
        this.setBg(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.addActor(this.bg);
        this.arena.setPosition(0.0F, 0.0F);
        this.addActor(this.arena);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    private void setBounds() {
        this.setWidth((float) Gdx.graphics.getWidth());
        this.setHeight((float)(Gdx.graphics.getHeight() - 25 - 37 - 5) - this.gui.getSplitPane().getHeight());
        this.setPosition(0.0F, this.gui.getSplitPane().getHeight() + 37.0F + 5.0F);
    }

    private void setBg(int w, int h) {
        this.bg.clear();
        this.bg.setBounds(0.0F, 0.0F, (float)w, (float)h);

        for(int i = 0; (float)i < this.bg.getWidth() / 160.0F; ++i) {
            for(int j = 0; (float)j < this.bg.getWidth() / 200.0F; ++j) {
                MyActor bgActor = new MyActor(UserInfoAtlasLoader.bg);
                bgActor.setPosition((float)(i * 168), (float)(j * 200));
                this.bg.addActor(bgActor);
            }
        }

        this.bg.setPosition(0.0F, 0.0F);
    }

    public void resize(int w, int h, int splitH) {
        this.setBg(w, h);
        this.arena.setPosition(10.0F, (float)(splitH - 530));
    }

    public void startTimer() {
        this.arena.startTimer();
    }

    public void cancelBattle() {
        this.arena.cancelBattle();
    }

    public void close() {
        this.remove();
    }
}

