package ru.megains.farlandsOld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gameobjects.mainmenu.BtnExitMenu;
import ru.megains.farlandsOld.gameobjects.mainmenu.BtnLogin;
import ru.megains.farlandsOld.gameobjects.mainmenu.BtnRegister;
import ru.megains.farlandsOld.gameobjects.mainmenu.MainMenuTextFields;
import ru.megains.farlandsOld.loaders.MainMenuAtlasLoader;

public class MainMenu implements Screen {
    FMain game;
    private MyActor bg;
    private Viewport view;
    private MyActor bgLogin;
    private BtnLogin btnLogin;
    private BtnRegister btnRegister;
    private BtnExitMenu btnExit;
    private MainMenuTextFields mmo;
    private Stage stage;
    private OrthographicCamera cam;
    private Label lblMessage;

    public MainMenu(FMain game) {
        this.game = game;
        MainMenuAtlasLoader.load();
        this.cam = new OrthographicCamera();
        this.cam.setToOrtho(false, 900.0F, 675.0F);
        this.view = new ExtendViewport(900.0F, 675.0F, this.cam);
        this.bg = new MyActor(MainMenuAtlasLoader.bg);
        this.mmo = new MainMenuTextFields();
        this.bgLogin = new MyActor(MainMenuAtlasLoader.bgLogin);
        this.btnLogin = new BtnLogin(new SpriteDrawable(MainMenuAtlasLoader.btnLoginUp), new SpriteDrawable(MainMenuAtlasLoader.btnLoginDown), this);
        this.btnRegister = new BtnRegister(new SpriteDrawable(MainMenuAtlasLoader.btnregistration), new SpriteDrawable(MainMenuAtlasLoader.selregistration), this);
        this.btnExit = new BtnExitMenu(new SpriteDrawable(MainMenuAtlasLoader.btnExitUp), new SpriteDrawable(MainMenuAtlasLoader.btnExitDown));
        this.lblMessage = new Label("", Styles.labelRed);
    }

    public void setMessageText(String text) {
        this.lblMessage.setText(text);
    }

    public void show() {
        this.stage = new Stage(this.view);
        Gdx.input.setInputProcessor(this.stage);
        this.bgLogin.setPosition(323.0F, 137.0F);
        this.btnRegister.setPosition(340.0F, 140.0F);
        this.lblMessage.setPosition(340.0F, 320.0F);
        this.stage.addActor(this.bg);
        this.stage.addActor(this.bgLogin);
        this.stage.addActor(this.btnLogin);
        this.stage.addActor(this.btnExit);
        this.stage.addActor(this.btnRegister);
        this.stage.addActor(this.mmo.getInputLogin());
        this.stage.addActor(this.mmo.getInputPassword());
        this.stage.addActor(this.lblMessage);
    }

    public String getLogin() {
        return this.mmo.getInputLogin().getText();
    }

    public String getPassword() {
        return this.mmo.getInputPassword().getText();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.stage.act(delta);
        this.stage.draw();
    }

    public void resize(int width, int height) {
        this.stage.getViewport().update(width, height, true);
        this.cam.viewportHeight = (float)height;
        this.cam.viewportWidth = (float)width;
        this.cam.update();
    }

    public void pause() {
    }

    public void resume() {
    }

    public void hide() {
        this.dispose();
    }

    public void dispose() {
        this.stage.dispose();
    }
}
