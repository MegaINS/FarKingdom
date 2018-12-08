package ru.megains.farlandsOld.gui.guibottom;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import ru.megains.farlandsOld.base.Styles;

public class LogFilter extends CheckBox {
    public LogFilter(final ChartTable chat) {
        super("", Styles.guiSkin);
        this.setChecked(false);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                chat.checkLogFilter(!LogFilter.this.isChecked());
                return true;
            }
        });
    }
}
