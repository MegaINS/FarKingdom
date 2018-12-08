package ru.megains.farlandsOld.gameobjects;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.loaders.TextFieldAtlasLoader;

public class MyTextField extends Group {
    private MyActor leftTopCorner;
    private MyActor leftBottomCorner;
    private MyActor rightTopCorner;
    private MyActor rightBottomCorner;
    private MyActor leftSide;
    private MyActor topSide;
    private MyActor bottomSide;
    private MyActor rightSide;
    private MyActor middlePart;
    private TextField textField;

    public MyTextField() {
        this.leftTopCorner = new MyActor(TextFieldAtlasLoader.leftTopCorner);
        this.leftBottomCorner = new MyActor(TextFieldAtlasLoader.leftBottomCorner);
        this.rightTopCorner = new MyActor(TextFieldAtlasLoader.rightTopCorner);
        this.rightBottomCorner = new MyActor(TextFieldAtlasLoader.rightBottomCorner);
        this.textField = new TextField("", Styles.guiSkin);
        this.textField.setWidth(60.0F);
        this.textField.setAlignment(3);
        this.addActor(this.textField);
        this.addActor(this.leftTopCorner);
        this.addActor(this.leftBottomCorner);
        this.addActor(this.rightTopCorner);
        this.addActor(this.rightBottomCorner);
        this.setResizeble();
    }

    public void setResizeble() {
        this.leftTopCorner.setPosition(0.0F, this.textField.getHeight() - 9.0F);
        this.leftBottomCorner.setPosition(0.0F, 0.0F);
        this.rightTopCorner.setPosition(this.textField.getWidth() - 9.0F, this.textField.getHeight() - 9.0F);
        this.rightBottomCorner.setPosition(this.textField.getWidth() - 9.0F, 0.0F);
    }

    public String getText() {
        return this.textField.getText();
    }

    public void setText(String text) {
        this.textField.setText(text);
    }
}
