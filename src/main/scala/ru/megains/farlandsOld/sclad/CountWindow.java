package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import ru.megains.farlandsOld.base.Styles;

public class CountWindow extends Window {
    public CountWindow(final SkladWindow window, final long itemMid, final boolean put) {
        super("", Styles.guiSkin);
        super.setBounds(400.0F, 240.0F, 300.0F, 500.0F);
        Button CancelButton = new TextButton("Отмена", Styles.guiSkin);
        Button OkButton = new TextButton("OK", Styles.guiSkin);
        final TextField inputField = new TextField("", Styles.guiSkin);
        OkButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                String textCount = inputField.getText();
                if (textCount.length() <= 0) {
                    return true;
                } else {
                    try {
                        int count = Integer.parseInt(textCount);
                        if (put) {
                            window.putItemToSclad(itemMid, count);
                        } else {
                            window.takeItemFromSklad(itemMid, count);
                        }

                        window.closeCountWindow();
                    } catch (NumberFormatException var8) {
                        inputField.setText("");
                    }

                    return true;
                }
            }
        });
        CancelButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                window.closeCountWindow();
                return true;
            }
        });
        this.setBounds(400.0F, 240.0F, 180.0F, 100.0F);
        this.add(new Label("Количество:", Styles.labelYellow)).padBottom(10.0F).center().expand().padTop(5.0F);
        this.add(inputField).width(60.0F).height(20.0F).padBottom(10.0F).center().expand().padTop(5.0F);
        this.row();
        this.add(OkButton).width(80.0F).height(20.0F).left().padRight(5.0F);
        this.add(CancelButton).width(80.0F).height(20.0F).right();
        this.pack();
    }
}

