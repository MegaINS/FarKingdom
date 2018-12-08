package ru.megains.farlandsOld.gui.guibottom;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

import java.util.Iterator;
import java.util.Map;

public class SmilesBox extends Table {
    private Map<String, Smile> smiles;
    private int w = 7;

    public SmilesBox(Map<String, Smile> smiles) {
        this.setBounds(0.0F, 0.0F, 300.0F, 280.0F);
        this.setBackground(new SpriteDrawable(GuiAtlasLoader.txtfield_bg));
        this.smiles = smiles;
        int lineCounter = 0;

        for(Iterator var3 = smiles.entrySet().iterator(); var3.hasNext(); ++lineCounter) {
            Map.Entry<String, Smile> entry = (Map.Entry)var3.next();
            if (lineCounter >= this.w) {
                lineCounter = 0;
                this.row();
            }

            this.add((Actor)entry.getValue());
        }

    }
}
