package ru.megains.farlandsOld.gui.guileft;


import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.loaders.GuiAtlasLoader;

public class BtnStatsDown extends MyButton {
    private FreeStats freeStats;
    private String statName;

    public BtnStatsDown(FreeStats freeStats, String statName) {
        super(GuiAtlasLoader.btn_sub, GuiAtlasLoader.sel_sub, GuiAtlasLoader.sel_sub, GuiAtlasLoader.dis_sub);
        this.freeStats = freeStats;
        this.statName = statName;
    }

    protected void clickAction() {
        String var1 = this.statName;
        byte var2 = -1;
        switch(var1.hashCode()) {
            case -1897344401:
                if (var1.equals("stamina")) {
                    var2 = 1;
                }
                break;
            case 104431:
                if (var1.equals("int")) {
                    var2 = 3;
                }
                break;
            case 3059489:
                if (var1.equals("conc")) {
                    var2 = 0;
                }
                break;
            case 1791315673:
                if (var1.equals("strenght")) {
                    var2 = 2;
                }
        }

        switch(var2) {
            case 0:
                this.freeStats.takeConc(1);
                break;
            case 1:
                this.freeStats.takeStamina(1);
                break;
            case 2:
                this.freeStats.takeStrenght(1);
                break;
            case 3:
                this.freeStats.takeIntellect(1);
        }

    }
}

