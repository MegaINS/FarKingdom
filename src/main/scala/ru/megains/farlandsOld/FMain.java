package ru.megains.farlandsOld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.loaders.*;


public class FMain extends Game {
    private MainMenu menu;
    private MainGame game;
    private Gui gui;

    public FMain() {
    }

    public void create() {
        Gdx.app.log("Farlands", "created");
        MobAtlasLoader.load();
        TrapsAtlasLoader.load();
        GuiAtlasLoader.load();
        ElementsAtlasLoader.load();
        CursorsAtlasLoader.load();
        ItemsAtlasLoader.load();
        ArmorEquipedAtlasLoader.load();
        ItemLayersAtlasLoader.load();
        UserInfoAtlasLoader.load();
        StoreAtlasLoader.load();
        ShopAtlasLoader.load();
        Styles.load();
        TextFieldAtlasLoader.load();
        BattleAtlasLoader.load();
        SkillsAtlasLoader.load();
        Const.game = this;
        this.game = new MainGame();

        try {
            this.gui = new Gui();
        } catch (ParseException var2) {
            var2.printStackTrace();
        }

        this.menu = new MainMenu(this);
        Const.mainMenu = this.menu;
        this.setScreen(this.menu);
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        super.dispose();
    }

    public MainGame getGame() {
        return this.game;
    }

    public Gui getGui() {
        return this.gui;
    }
}
