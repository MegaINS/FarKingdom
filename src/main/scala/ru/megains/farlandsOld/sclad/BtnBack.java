package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gui.Gui;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

public class BtnBack extends ImageButton {
    public BtnBack(final SkladWindow skladWindow, int skladId) {
        super(new SpriteDrawable(GuiAtlasLoader.btnEnter));
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (skladWindow.getInsiders().getScladCellActor() != null) {
                    Gdx.app.postRunnable(new Runnable() {
                        public void run() {
                            SendPasket.changeLoc(Const.game.getGui().getGuiLeftDown().getBtnEnter().getWarpPointId());
                        }
                    });
                } else {
                    Gui.guiLeftWindow.setVisible(true);
                    skladWindow.close();
                }

                return true;
            }
        });
    }
}
