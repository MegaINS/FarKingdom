package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.inventory.InfinityInventoryActor;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class SkladWindow extends Group {
    private Group bg;
    private Gui gui;
    private ScladWindowInsiders insiders;
    private int skladId;

    public SkladWindow(Gui gui, int skladId) throws ParseException {
        this.gui = gui;
        this.skladId = skladId;
        this.setScladBounds();
        this.bg = new Group();
        this.setBg();
        this.addActor(this.bg);
        this.insiders = new ScladWindowInsiders(gui, skladId, this);
        this.addActor(this.insiders);
        this.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), (int)(Const.game.getGui().getOuterSplitPane().getHeight() * Const.game.getGui().getOuterSplitPane().getSplitAmount()));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    }

    private void setScladBounds() {
        this.setWidth((float) Gdx.graphics.getWidth());
        this.setHeight((float)(Gdx.graphics.getHeight() - 25 - 37 - 5) - this.gui.getSplitPane().getHeight());
        this.setPosition(0.0F, this.gui.getSplitPane().getHeight() + 37.0F + 5.0F);
    }

    private void setBg() {
        this.bg.clear();
        this.bg.setBounds(0.0F, 0.0F, (float) Gdx.graphics.getWidth(), (float) Gdx.graphics.getHeight());

        for(int i = 0; (float)i < this.bg.getWidth() / 160.0F; ++i) {
            for(int j = 0; (float)j < this.bg.getWidth() / 200.0F; ++j) {
                MyActor bgActor = new MyActor(UserInfoAtlasLoader.bg);
                bgActor.setPosition((float)(i * 168), (float)(j * 200));
                this.bg.addActor(bgActor);
            }
        }

        this.bg.setPosition(0.0F, 0.0F);
    }

    public void loadCellList(JSONObject list) throws ParseException {
        this.insiders.loadCellList(list);
    }

    public void openScladCell(JSONObject jsonData) throws ParseException {
        this.insiders.openScladCell(jsonData);
    }

    public SkladCellActor getSkladCellActor() {
        return this.insiders.getScladCellActor();
    }

    public int getSkladId() {
        return this.skladId;
    }

    public void resize(int w, int h, int splitH) {
        this.setBg();
        this.insiders.setPosition(10.0F, (float)(splitH - 560));
        this.insiders.setEquiped();
    }

    public CellList getCellList() {
        return this.insiders.getCellList();
    }

    public InfinityInventoryActor getInventory() {
        return this.insiders.getInventory();
    }

    public void putItemToSclad(long itemMid, int count) {
        SendPasket.putItemToSclad(itemMid, this.skladId, this.getSkladCellActor().getCellId(), count);
    }

    public void takeItemFromSklad(long itemMid, int count) {
        SendPasket.takeItemFromSclad(itemMid, this.skladId, this.getSkladCellActor().getCellId(), count);
    }

    public ScladWindowInsiders getInsiders() {
        return this.insiders;
    }

    public void close() {
        if (this.bg != null) {
            this.bg.remove();
        }

        this.gui.getOuterSplitPane().setFirstWidget((Actor)null);
        this.remove();
    }

    public void closeCountWindow() {
        this.insiders.closeCountWindow();
    }

    public void openCountWindow(long selected, boolean b) {
        this.insiders.openCountWindow(selected, b);
    }


}

