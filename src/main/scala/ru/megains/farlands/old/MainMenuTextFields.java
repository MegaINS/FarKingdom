package ru.megains.farlands.old;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class MainMenuTextFields {
    private TextField.TextFieldStyle style = new TextField.TextFieldStyle();
    private TextField txLogin;
    private TextField txPassword;

    public MainMenuTextFields() {
        this.style.messageFontColor = Color.WHITE;
        this.style.font = Fonts.MAIN_MENU_INPUT.get();
        this.style.fontColor = Color.WHITE;
        this.style.messageFontColor = Color.WHITE;
        this.style.selection = new TextureRegionDrawable(GuiAtlasLoader.bg_addresed);
        this.txLogin = new TextField("Bukka", this.style);
        this.txLogin.setPosition(423.0F, 246.0F);
        this.txLogin.setWidth(130.0F);
        this.txPassword = new TextField("04041992", this.style);
        this.txPassword.setPosition(423.0F, 221.0F);
        this.txPassword.setWidth(130.0F);
    }

    public TextField getInputLogin() {
        return this.txLogin;
    }

    public TextField getInputPassword() {
        return this.txPassword;
    }
}
