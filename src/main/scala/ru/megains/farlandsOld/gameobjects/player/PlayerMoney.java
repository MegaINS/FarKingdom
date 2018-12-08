package ru.megains.farlandsOld.gameobjects.player;

import org.json.simple.JSONObject;

public class PlayerMoney {
    private float zet = 0.0F;
    private float ezet = 0.0F;

    public PlayerMoney() {
    }

    public void init(JSONObject json) {
        this.zet = ((Double)json.get("zet")).floatValue();
        this.ezet = ((Double)json.get("ezet")).floatValue();
    }

    public float getZet() {
        return this.zet;
    }

    public void setZet(float zet) {
        this.zet = zet;
    }

    public float getEzet() {
        return this.ezet;
    }

    public void setEzet(float ezet) {
        this.ezet = ezet;
    }
}