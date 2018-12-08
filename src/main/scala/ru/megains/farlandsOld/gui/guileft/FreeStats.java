package ru.megains.farlandsOld.gui.guileft;


import ru.megains.farlandsOld.net.SendPasket;

public class FreeStats {
    private int strenght;
    private int conc;
    private int intellect;
    private int stamina;
    private int freeStats = 100;
    private ParametersListener bgStatsUp;

    public FreeStats(ParametersListener bgStatsUp) {
        this.bgStatsUp = bgStatsUp;
    }

    public void apply() {
        if (this.stamina > 0 || this.conc > 0 || this.strenght > 0 || this.intellect > 0) {
            SendPasket.applyStats(this.strenght, this.stamina, this.conc, this.intellect);
        }

    }

    public void reset(int freeStats) {
        this.freeStats = freeStats;
        this.strenght = 0;
        this.stamina = 0;
        this.intellect = 0;
        this.conc = 0;
    }

    public void takeStrenght(int strenght) {
        if (strenght > 0) {
            this.strenght -= strenght;
            this.freeStats += strenght;
            this.bgStatsUp.hasChanged();
        }

    }

    public void takeConc(int conc) {
        if (conc > 0) {
            this.conc -= conc;
            this.freeStats += conc;
            this.bgStatsUp.hasChanged();
        }

    }

    public void takeIntellect(int intellect) {
        if (intellect > 0) {
            this.intellect -= intellect;
            this.freeStats += intellect;
            this.bgStatsUp.hasChanged();
        }

    }

    public void takeStamina(int stamina) {
        if (stamina > 0) {
            this.stamina -= stamina;
            this.freeStats += stamina;
            this.bgStatsUp.hasChanged();
        }

    }

    public void addStrenght(int strenght) {
        if (this.freeStats >= strenght) {
            this.strenght += strenght;
            this.freeStats -= strenght;
            this.bgStatsUp.hasChanged();
        }

    }

    public void addConc(int conc) {
        if (this.freeStats >= conc) {
            this.conc += conc;
            this.freeStats -= conc;
            this.bgStatsUp.hasChanged();
        }

    }

    public void addIntellect(int intellect) {
        if (this.freeStats >= intellect) {
            this.intellect += intellect;
            this.freeStats -= intellect;
            this.bgStatsUp.hasChanged();
        }

    }

    public void addStamina(int stamina) {
        if (this.freeStats >= stamina) {
            this.stamina += stamina;
            this.freeStats -= stamina;
            this.bgStatsUp.hasChanged();
        }

    }

    public void addFreeStats(int freeStats) {
        this.freeStats = freeStats;
    }

    public int getTotal() {
        return this.freeStats + this.stamina + this.intellect + this.conc + this.strenght;
    }

    public int getFreeStats() {
        return this.freeStats;
    }

    public int getStrenght() {
        return this.strenght;
    }

    public int getConc() {
        return this.conc;
    }

    public int getIntellect() {
        return this.intellect;
    }

    public int getStamina() {
        return this.stamina;
    }
}

