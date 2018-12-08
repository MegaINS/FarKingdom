package ru.megains.farlandsOld.gameobjects.player;


import org.json.simple.JSONObject;
import ru.megains.farlandsOld.gui.guileft.ParametersListener;

import java.util.ArrayList;

public class PlayerParameters {
    private int level;
    private float exp;
    private float nextExp;
    private int freeStats;
    private int hpMax;
    private int hpCurent;
    private int energyMax;
    private int energyCurrent;
    private int balanceMax;
    private int balanceCurrent;
    private int strenght;
    private int stamina;
    private int conc;
    private int intellect;
    private int damage = 0;
    private int damageRange = 0;
    private int crit = 0;
    private int defence = 0;
    private int antiCrit = 0;
    private float carryingMax;
    private float carryingCurent;
    private ArrayList<ParametersListener> parametersListeners = new ArrayList();

    public PlayerParameters() {
    }

    public void init(JSONObject initObj) {
        this.level = ((Long)initObj.get("level")).intValue();
        this.exp = ((Double)initObj.get("exp")).floatValue();
        this.nextExp = ((Double)initObj.get("nextexp")).floatValue();
        this.freeStats = ((Long)initObj.get("freeStats")).intValue();
        this.strenght = ((Long)initObj.get("strenght")).intValue();
        this.conc = ((Long)initObj.get("conc")).intValue();
        this.intellect = ((Long)initObj.get("intellect")).intValue();
        this.stamina = ((Long)initObj.get("stamina")).intValue();
        this.damage = ((Long)initObj.get("damage")).intValue();
        this.damageRange = ((Long)initObj.get("damageRange")).intValue();
        this.crit = ((Long)initObj.get("crit")).intValue();
        this.defence = ((Long)initObj.get("defence")).intValue();
        this.antiCrit = ((Long)initObj.get("antiCrit")).intValue();
        this.hpMax = ((Long)initObj.get("hpMax")).intValue();
        this.hpCurent = ((Long)initObj.get("hpCurent")).intValue();
        this.energyMax = ((Long)initObj.get("energyMax")).intValue();
        this.energyCurrent = ((Long)initObj.get("energyCurrent")).intValue();
        this.balanceMax = ((Long)initObj.get("balanceMax")).intValue();
        this.balanceCurrent = ((Long)initObj.get("balanceCurent")).intValue();
        this.carryingMax = ((Double)initObj.get("carryingMax")).floatValue();
        this.carryingCurent = ((Double)initObj.get("carryingCurent")).floatValue();
        this.notyfiListeners();
    }

    public void addListener(ParametersListener listener) {
        this.parametersListeners.add(listener);
    }

    public void notyfiListeners() {
        for(int i = 0; i < this.parametersListeners.size(); ++i) {
            ((ParametersListener)this.parametersListeners.get(i)).hasChanged();
        }

    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getExp() {
        return this.exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public float getNextExp() {
        return this.nextExp;
    }

    public void setNextExp(float nextExp) {
        this.nextExp = nextExp;
    }

    public int getFreeStats() {
        return this.freeStats;
    }

    public void setFreeStats(int freeStats) {
        this.freeStats = freeStats;
    }

    public int getHpMax() {
        return this.hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHpCurent() {
        return this.hpCurent;
    }

    public void setHpCurent(int hpCurent) {
        this.hpCurent = hpCurent;
    }

    public int getEnergyMax() {
        return this.energyMax;
    }

    public void setEnergyMax(int energyMax) {
        this.energyMax = energyMax;
    }

    public int getEnergyCurrent() {
        return this.energyCurrent;
    }

    public void setEnergyCurrent(int energyCurrent) {
        this.energyCurrent = energyCurrent;
    }

    public int getBalanceMax() {
        return this.balanceMax;
    }

    public void setBalanceMax(int balanceMax) {
        this.balanceMax = balanceMax;
    }

    public int getBalanceCurrent() {
        return this.balanceCurrent;
    }

    public void setBalanceCurrent(int balanceCurrent) {
        this.balanceCurrent = balanceCurrent;
    }

    public int getStrenght() {
        return this.strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getConc() {
        return this.conc;
    }

    public void setConc(int conc) {
        this.conc = conc;
    }

    public int getIntellect() {
        return this.intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamageRange() {
        return this.damageRange;
    }

    public void setDamageRange(int damageRange) {
        this.damageRange = damageRange;
    }

    public int getCrit() {
        return this.crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAntiCrit() {
        return this.antiCrit;
    }

    public void setAntiCrit(int antiCrit) {
        this.antiCrit = antiCrit;
    }

    public float getCarryingMax() {
        return this.carryingMax;
    }

    public void setCarryingMax(float carryingMax) {
        this.carryingMax = carryingMax;
    }

    public float getCarryingCurent() {
        return this.carryingCurent;
    }

    public void setCarryingCurent(float carryingCurent) {
        this.carryingCurent = carryingCurent;
    }
}
