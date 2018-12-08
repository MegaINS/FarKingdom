package ru.megains.farlands.old;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.megains.farlands.network.NetworkManager$;
import ru.megains.farlands.network.packet.play.SPlayerAction;
import ru.megains.farlands.player.PlayerAction$;

public class BtnEnter extends ImageButton {
    private int warpPointId;
    private String transit;
    public BtnEnter(Drawable imageUp, Drawable imageDown) {
        super(imageUp, imageDown);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.postRunnable(new Runnable() {
                    public void run() {
                        try {
                            System.out.println("sds");
//                            if (Const.game.getGame().getPlayer().isBlocked()) {
//                                return;
//                            }
//

                            NetworkManager$.MODULE$.sendPacket(new SPlayerAction(PlayerAction$.MODULE$.CHANGE_LOC(),0,0,0, transit));
//                            SendPasket.changeLoc(BtnEnter.this.warpPointId);
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

    public void enable(String transitIn) {
        transit = transitIn;
        this.setVisible(true);
       // this.warpPointId = warp.getWarpId();
    }

    public int getWarpPointId() {
        return this.warpPointId;
    }
}
