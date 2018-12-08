package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class ShopWindow extends Group {
    private ShopWindowInsiders shop;
    private Gui gui;
    private Group bg;

    public ShopWindow(Gui gui, int locId) throws ParseException {
        this.gui = gui;
        this.shop = new ShopWindowInsiders(gui, locId);
        this.bg = new Group();
        this.setBg(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.addActor(this.bg);
        this.shop.setPosition(0.0F, 0.0F);
        this.addActor(this.shop);
    }

    public void loadShopInventory(JSONArray items) throws ParseException {
        this.shop.loadShopInventory(items);
    }

    public void close() {
        this.remove();
    }

    public void resize(int w, int h, int splitH) {
        this.setBg(w, h);
        this.shop.setPosition(10.0F, (float)(splitH - 560));
    }

    public ShopButtonsGroup getTbg() {
        return this.shop.getTbg();
    }

    private void setBg(int w, int h) {
        this.bg.clear();
        this.bg.setBounds(0.0F, 0.0F, (float)w, (float)h);

        for(int i = 0; i < w / 160 + 1; ++i) {
            for(int j = 0; j < h / 200 + 1; ++j) {
                MyActor bgActor = new MyActor(UserInfoAtlasLoader.bg);
                bgActor.setPosition((float)(i * 168), (float)(j * 200));
                this.bg.addActor(bgActor);
            }
        }

        this.bg.setPosition(0.0F, 0.0F);
    }
}

