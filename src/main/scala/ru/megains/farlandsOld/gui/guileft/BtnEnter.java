package ru.megains.farlandsOld.gui.guileft;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.Warp;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnEnter extends ImageButton {
    private int warpPointId;

    public BtnEnter(Drawable imageUp, Drawable imageDown) {
        super(imageUp, imageDown);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            if (Const.game.getGame().getPlayer().isBlocked()) {
                                return;
                            }

                            SendPasket.changeLoc(BtnEnter.this.warpPointId);
                        } catch (Exception var2) {
                            var2.printStackTrace();
                        }

                    }
                });
                return true;
            }
        });
    }

    public void disable() {
        this.setVisible(false);
    }

    public void enable(Warp warp) {
        this.setVisible(true);
        this.warpPointId = warp.getWarpId();
    }

    public int getWarpPointId() {
        return this.warpPointId;
    }
}
