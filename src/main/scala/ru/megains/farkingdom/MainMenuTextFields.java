package ru.megains.farkingdom;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;


public class MainMenuTextFields {
    private TextField.TextFieldStyle style = new TextField.TextFieldStyle();
    private TextField txLogin;
    private TextField txPassword;

//    public MainMenuTextFields() {
//        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ttfs/cour.ttf"));
//        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
//
//        BitmapFont font24 = generator.generateFont(parameter); // font size 24 pixels
//        generator.dispose();
//        style.messageFontColor = Color.WHITE;
//        style.font = font24;
//        style.fontColor = Color.WHITE;
//       // style.selection = new TextureRegionDrawable(GuiAtlasLoader.bg_addresed);
//        txLogin = new TextField("Bukka",style);
//        txLogin.setPosition(423.0F, 246.0F);
//        txLogin.setWidth(130.0F);
//        txPassword = new TextField("04041992",style);
//        txPassword.setPosition(423.0F, 221.0F);
//        txPassword.setWidth(130.0F);
//    }

    public TextField getInputLogin() {
        return txLogin;
    }

    public TextField getInputPassword() {
        return txPassword;
    }
}
