package ru.megains.farlandsOld.shop.countWindowGroup;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyLabel;
import ru.megains.farlandsOld.gameobjects.MyTextField;
import ru.megains.farlandsOld.loaders.ElementsAtlasLoader;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.sclad.CountedButton;
import ru.megains.farlandsOld.shop.ShopWindowInsiders;

public class CountWindow extends Table {
    public CountWindow(final CountedButton clickedButton, final long itemId, final ShopWindowInsiders window) {
        super.setBackground(new SpriteDrawable(GuiAtlasLoader.bg));
        new TextField.TextFieldStyle();
        BtnOkay btnOkay = new BtnOkay(ElementsAtlasLoader.btn_ok, ElementsAtlasLoader.sel_ok, ElementsAtlasLoader.over_ok, ElementsAtlasLoader.dis_ok);
        BtnCancel btnCancel = new BtnCancel(ElementsAtlasLoader.btn_cancel, ElementsAtlasLoader.sel_cancel, ElementsAtlasLoader.over_cancel, ElementsAtlasLoader.dis_cancel);
        btnOkay.setActive(true);
        btnCancel.setActive(true);
        final MyTextField textFieldCount = new MyTextField();
        btnOkay.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                String textCount = textFieldCount.getText();
                if (textCount.length() <= 0) {
                    return true;
                } else {
                    try {
                        int count = Integer.parseInt(textCount);
                        clickedButton.click(itemId, count);
                        window.closeCountWindow();
                    } catch (NumberFormatException var8) {
                        textFieldCount.setText("");
                    }

                    return true;
                }
            }
        });
        btnCancel.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                window.closeCountWindow();
                return true;
            }
        });
        this.setBounds(400.0F, 240.0F, 180.0F, 120.0F);
        this.add(new MyLabel("Количество:", Styles.labelBlack)).padBottom(10.0F).center().expand().padTop(5.0F);
        this.add(textFieldCount).width(60.0F).height(20.0F).padTop(10.0F).center().padTop(5.0F);
        this.row();
        this.add(btnOkay).left().padLeft(5.0F).padRight(5.0F).padBottom(5.0F);
        this.add(btnCancel).right().padBottom(5.0F);
        this.pack();
    }

    public CountWindow() {
        super.setBackground(new SpriteDrawable(GuiAtlasLoader.bg));
    }
}
