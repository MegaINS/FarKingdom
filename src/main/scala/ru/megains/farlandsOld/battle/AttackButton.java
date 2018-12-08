package ru.megains.farlandsOld.battle;


import com.badlogic.gdx.graphics.g2d.Sprite;
import ru.megains.farlandsOld.gameobjects.MyButton;
import ru.megains.farlandsOld.net.SendPasket;

public class AttackButton extends MyButton {
    private int battleId;
    private int attackId;

    public AttackButton(Sprite imageUp, Sprite imageDown, Sprite imageOver, Sprite disActiv, int attackId, int battleId) {
        super(imageUp, imageDown, imageOver, disActiv);
        this.attackId = attackId;
        this.battleId = battleId;
    }

    protected void clickAction() {
        SendPasket.finishRound(this.attackId, this.battleId);
    }
}

