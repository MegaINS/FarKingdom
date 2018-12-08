package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.net.SendPasket;

public class DropCountWindow extends Window {
    public DropCountWindow(int maxCount, final long itemId) {
        super("", Styles.guiSkin);
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
                        SendPasket.dropItem(itemId, count);
                        DropCountWindow.this.addAction(Actions.removeActor());
                    } catch (NumberFormatException var8) {
                        inputField.setText("");
                    }

                    return true;
                }
            }
        });
        CancelButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DropCountWindow.this.addAction(Actions.removeActor());
                return true;
            }
        });
        this.add(new Label("Количество", Styles.labelYellow));
        this.row();
        this.add(inputField);
        this.row();
        this.add(OkButton);
        this.add(CancelButton);
        this.pack();
    }
}

