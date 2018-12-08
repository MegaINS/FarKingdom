package ru.megains.farlandsOld.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Fonts;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.battle.BattleWindow;
import ru.megains.farlandsOld.battle.arena.ArenaWindow;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gameobjects.Warp;
import ru.megains.farlandsOld.gameobjects.enemyInfoWindow.EnemyInfoWindow;
import ru.megains.farlandsOld.gui.guibottom.*;
import ru.megains.farlandsOld.gui.guibottom.playersList.PlayerNode;
import ru.megains.farlandsOld.gui.guibottom.playersList.PlayersTable;
import ru.megains.farlandsOld.gui.guileft.GuiLeft;
import ru.megains.farlandsOld.gui.guileft.GuiLeftDown;
import ru.megains.farlandsOld.gui.guileft.GuiLeftWindow;
import ru.megains.farlandsOld.gui.guitop.GuiTop;
import ru.megains.farlandsOld.helpers.SystemMessage;
import ru.megains.farlandsOld.inventory.InventoryWindow;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;
import ru.megains.farlandsOld.sclad.SkladWindow;
import ru.megains.farlandsOld.shop.ShopWindow;

import java.util.ArrayList;

public class Gui extends Stage {
    private ScreenViewport view;
    private MyActor bgleft;
    private MyActor bgblue;
    private MyActor bgright_min;
    private BtnClear btnClear;
    private BtnSmile btnSmile;
    private Skin skin;
    private ScrollPane playersTreeScrollPane;
    private ChartScrollPane chartScrollPane;
    private SplitPane splitPane;
    private ChartTable chartTable;
    private PlayersTable playersTable;
    private TextField inputMessage;
    private BtnSendMessage btnSendMessage;
    private SplitPane outerSplitPane;
    public static GuiLeftWindow guiLeftWindow;
    private GuiTop guiTop;
    private OrthographicCamera cam;
    private InventoryWindow inventoryActor;
    private SkladWindow sclad;
    private ShopWindow shop;
    private BattleWindow battle;
    private ArenaWindow arena;
    private SmilesBox smilesBox;
    private LogFilter logFilter;
    private float splitAmount;

    public Gui() throws ParseException {
        this.cam = new OrthographicCamera((float)(Gdx.graphics.getWidth() * 2), (float)(Gdx.graphics.getHeight() * 2));
        this.view = new ScreenViewport(this.cam);
        this.setViewport(this.view);
        this.skin = Styles.guiSkin;
      //  this.bgleft = new MyActor(GuiAtlasLoader.bgleft);
        this.bgblue = new MyActor(GuiAtlasLoader.bgblue);
        this.bgright_min = new MyActor(GuiAtlasLoader.bgright_min);
        this.btnClear = new BtnClear(new SpriteDrawable(GuiAtlasLoader.btnclear), new SpriteDrawable(GuiAtlasLoader.selclear), this);
        this.inputMessage = new TextField("", this.skin);
        this.btnSendMessage = new BtnSendMessage(new SpriteDrawable(GuiAtlasLoader.btnenter), new SpriteDrawable(GuiAtlasLoader.overenter));
        this.chartTable = new ChartTable(this.inputMessage);
        this.chartScrollPane = new ChartScrollPane(this.chartTable.left().top(), this.skin);
        this.chartScrollPane.setFadeScrollBars(false);
        this.chartTable.setPane(this.chartScrollPane);
        this.chartScrollPane.setOverscroll(false, false);
        this.playersTable = new PlayersTable();
        this.playersTreeScrollPane = new ScrollPane(this.playersTable, this.skin);
        this.playersTreeScrollPane.setFadeScrollBars(false);
        this.splitPane = new SplitPane(this.chartScrollPane, this.playersTreeScrollPane, false, this.skin);
        this.splitPane.setMaxSplitAmount(0.9F);
        this.splitPane.setMinSplitAmount(0.6F);
        this.splitPane.setSplitAmount(0.8F);
        this.splitPane.setWidth(99.0F);
        this.logFilter = new LogFilter(this.chartTable);
        Table emptyTable = new Table(this.skin);
        this.outerSplitPane = new SplitPane(emptyTable, this.splitPane, true, this.skin);
        this.outerSplitPane.setSplitAmount(0.8F);
        this.outerSplitPane.setMaxSplitAmount(0.9F);
        this.outerSplitPane.setMinSplitAmount(0.6F);
        guiLeftWindow = new GuiLeftWindow();
        guiLeftWindow.setPosition(5.0F, (float)(Gdx.graphics.getHeight() - 350));
        this.guiTop = new GuiTop(this);
        Window.WindowStyle style = new Window.WindowStyle();
        style.background = new SpriteDrawable(UserInfoAtlasLoader.bg);
        style.titleFont = Fonts.ARIAL_12B.get();
        this.inventoryActor = new InventoryWindow(Const.game.getGame().getPlayer().getInventory(), Const.game.getGame().getPlayer().getEquipped());
        this.inventoryActor.setPosition(250.0F, 150.0F);
        this.smilesBox = new SmilesBox(this.chartTable.getSmiles());
        this.smilesBox.setVisible(false);
        this.btnSmile = new BtnSmile(this.smilesBox);
//        this.addActor(this.bgleft);
        this.addActor(this.bgblue);
        this.addActor(this.bgright_min);
        this.addActor(this.btnClear);
        this.addActor(this.inputMessage);
        this.addActor(this.btnSendMessage);
        this.addActor(this.outerSplitPane);
     //   this.addActor(this.guiTop);
        this.addActor(guiLeftWindow);
        this.addActor(this.inventoryActor);
        this.addActor(this.btnSmile);
        this.addActor(this.smilesBox);
        this.addActor(this.logFilter);
        this.inventoryActor.setVisible(false);
        this.sclad = null;
        this.shop = null;
    }

    public boolean keyDown(int keycode) {
        super.keyDown(keycode);
        if (keycode == 66) {
            this.sendChartMessage();
        }

        return true;
    }

    public void sendChartMessage() {
        String line = this.getInputMessage().getText();
        if (line.length() > 0) {
            ChartMessageDAO dao = new ChartMessageDAO(line);
            if (dao.getText().length() <= 0) {
                this.getInputMessage().setText("");
                return;
            }

            SendPasket.sendChartMessage(dao);
            this.getInputMessage().setText("");
        }

    }

    public void resize(int w, int h) {
       // this.bgleft.setPosition(0.0F, 0.0F);
        this.bgblue.setBounds(73.0F, 0.0F, (float)(w - 208), 37.0F);
        this.bgright_min.setPosition((float)(w - 135), 0.0F);
        this.btnClear.setPosition(16.0F, 3.0F);
        this.outerSplitPane.setBounds(0.0F, 37.0F, (float)w, (float)(h - 37 - 20));
        this.inputMessage.setBounds(78.0F, 4.0F, (float)(w - 300), 29.0F);
        this.btnSendMessage.setPosition((float)(w - 216), 4.0F);
        this.btnSmile.setPosition((float)(w - 175), 4.0F);
        this.logFilter.setPosition((float)(w - 117), 9.0F);
        this.smilesBox.setPosition((float)(w - 350), 50.0F);
     //   this.guiTop.setPosition(0.0F, (float)(h - 25));
      //  this.guiTop.resize(w, h);
        this.chartTable.drawMessages();
        if (this.sclad != null) {
            this.sclad.resize(w, h, (int)(this.outerSplitPane.getHeight() * this.outerSplitPane.getSplitAmount()));
        }

        if (this.shop != null) {
            this.shop.resize(w, h, (int)(this.outerSplitPane.getHeight() * this.outerSplitPane.getSplitAmount()));
        }

        if (this.arena != null) {
            this.arena.resize(w, h, (int)(this.outerSplitPane.getHeight() * this.outerSplitPane.getSplitAmount()));
        }

        if (this.battle != null) {
            this.battle.resize(w, h, (int)(this.outerSplitPane.getHeight() * this.outerSplitPane.getSplitAmount()));
        }

    }

    public SplitPane getSplitPane() {
        return this.splitPane;
    }

    public ChartTable getChartTable() {
        return this.chartTable;
    }

    public TextField getInputMessage() {
        return this.inputMessage;
    }

    public void enableWarpFields(Warp warp) {
        guiLeftWindow.getGuiLeftDown().getBtnEnter().enable(warp);
    }

    public void disableWarpFields() {
        guiLeftWindow.getGuiLeftDown().getBtnEnter().disable();
    }

    public GuiLeft getGuiLeft() {
        return guiLeftWindow.getGuiLeft();
    }

    public GuiLeftDown getGuiLeftDown() {
        return guiLeftWindow.getGuiLeftDown();
    }

    public BtnRest getBtnRest() {
        return guiLeftWindow.getGuiLeftDown().getBtnRest();
    }

    public InventoryWindow getInventoryWindow() {
        return this.inventoryActor;
    }

    public void setTitle(String newTitle) {
        this.guiTop.setTitle(newTitle);
    }

    public void incSystemMessage(String title, String text) {
        SystemMessage message = new SystemMessage(title, text);
        this.addActor(message);
    }

    public void openSclad(int skladId) throws ParseException {
        if (this.sclad != null) {
            this.sclad.close();
        }

        guiLeftWindow.setVisible(false);
        this.sclad = new SkladWindow(this, skladId);
        this.outerSplitPane.setFirstWidget(this.sclad);
    }

    public void openShop(int locId) throws ParseException {
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        if (this.shop != null) {
            this.outerSplitPane.setFirstWidget((Actor)null);
            this.shop.close();
        }

        guiLeftWindow.setVisible(false);
        this.shop = new ShopWindow(this, locId);
        this.outerSplitPane.setFirstWidget(this.shop);
        this.shop.resize(w, h, (int)(this.outerSplitPane.getHeight() * this.outerSplitPane.getSplitAmount()));
    }

    public void closeShop() {
        this.outerSplitPane.setFirstWidget((Actor)null);
        if (this.shop != null) {
            this.shop.close();
            this.shop = null;
            guiLeftWindow.setVisible(true);
        }

    }

    public void openArena(int locId) throws ParseException {
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        this.closeArena();
        this.stopBattle();
        guiLeftWindow.setVisible(false);
        this.arena = new ArenaWindow(this, locId);
        this.outerSplitPane.setFirstWidget(this.arena);
        this.arena.resize(w, h, (int)(this.outerSplitPane.getHeight() * this.outerSplitPane.getSplitAmount()));
    }

    public void closeArena() {
        this.outerSplitPane.setFirstWidget((Actor)null);
        if (this.arena != null) {
            this.arena.close();
            this.arena = null;
            guiLeftWindow.setVisible(true);
        }

    }

    public void startArenaTimer() {
        if (this.arena != null) {
            this.arena.startTimer();
        }
    }

    public void arenaCancel() {
        if (this.arena != null) {
            this.arena.cancelBattle();
        }
    }

    public void startBattle(int battleId, int round, JSONObject enemyParameters, JSONObject enemyEquiped, String enemyName) throws ParseException {
        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        if (this.arena != null) {
            this.outerSplitPane.setFirstWidget((Actor)null);
            this.arena.close();
        }

        if (this.battle != null) {
            this.outerSplitPane.setFirstWidget((Actor)null);
            this.battle.close();
        }

        guiLeftWindow.setVisible(false);
        this.battle = new BattleWindow(this, battleId, round, enemyParameters, enemyEquiped, enemyName);
        this.outerSplitPane.setFirstWidget(this.battle);
        if (this.battle != null) {
            this.battle.resize(w, h, (int)(this.outerSplitPane.getHeight() * this.outerSplitPane.getSplitAmount()));
        }

    }

    public void stopBattle() {
        if (this.battle != null) {
            this.outerSplitPane.setFirstWidget((Actor)null);
            this.battle.close();
            guiLeftWindow.setVisible(true);
        }

    }

    public void setPlayersInLoc(JSONArray array) throws ParseException {
        ArrayList<PlayerNode> playerNodes = new ArrayList();
        JSONParser parser = new JSONParser();

        for(int i = 0; i < array.size(); ++i) {
            Object obj = parser.parse(array.get(i).toString());
            JSONObject jsonObj = (JSONObject)obj;
            PlayerNode node = new PlayerNode(((Long)jsonObj.get("id")).longValue(), (String)jsonObj.get("name"), ((Long)jsonObj.get("level")).intValue(), ((Long)jsonObj.get("x")).intValue(), ((Long)jsonObj.get("y")).intValue(), false);
            playerNodes.add(node);
        }

        this.playersTable.draw(playerNodes);
    }

    public void openEnemyInfoWindow(JSONObject jsonObj) throws ParseException {
        EnemyInfoWindow info = new EnemyInfoWindow((String)jsonObj.get("enemyname"), (JSONObject)jsonObj.get("enemyequiped"), (JSONObject)jsonObj.get("enemyparameters"), (JSONObject)jsonObj.get("profile"));
        this.addActor(info);
    }

    public void closeEnemyInfoWindow(EnemyInfoWindow enemyInfoWindow) {
        enemyInfoWindow.clear();
        enemyInfoWindow.remove();
    }

    public SkladWindow getScladWindow() {
        return this.sclad;
    }

    public ShopWindow getShop() {
        return this.shop;
    }

    public SplitPane getOuterSplitPane() {
        return this.outerSplitPane;
    }

    public BattleWindow getBattle() {
        return this.battle;
    }

    public void act(float delta) {
        super.act(delta);
        if (this.splitAmount != this.outerSplitPane.getSplitAmount()) {
            this.splitAmount = this.outerSplitPane.getSplitAmount();
            this.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }

    }
}
