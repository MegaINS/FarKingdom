package ru.megains.farlandsOld.gameobjects.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import org.json.simple.JSONObject;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.gameobjects.MyAnimatedActor;
import ru.megains.farlandsOld.gameobjects.Warp;
import ru.megains.farlandsOld.inventory.EquipedInventory;
import ru.megains.farlandsOld.inventory.PlayerInventory;
import ru.megains.farlandsOld.loaders.PlayersAtlasLoader;
import ru.megains.farlandsOld.net.SendPasket;

import java.util.Iterator;

public class Player extends MyAnimatedActor {
    private String name;
    private long id = 0L;
    private PlayerInventory inventory = new PlayerInventory();
    private EquipedInventory equipped = new EquipedInventory();
    private PlayerParameters parameters = new PlayerParameters();
    private PlayerMoney money = new PlayerMoney();
    private boolean blocked;
    private boolean move;
    private boolean inWarp;
    private Sprite idle;
    private Sprite sleep;
    private Array<Sprite> animMoveLeft;
    private Array<Sprite> animMoveRight;
    private Array<Sprite> animMoveDown;
    private Array<Sprite> animMoveTop;
    private Array<Sprite> animExtractResLeft = new Array();
    private Array<Sprite> animExtractResRight = new Array();
    private Array<Sprite> animExtractResDown = new Array();
    private Array<Sprite> animExtractResTop = new Array();

    public Player() {
        super(0.25F);
    }

    public void loadPlayerAtlas(boolean isMale) {
        PlayersAtlasLoader.load(isMale);
    }

    public void initPosition(JSONObject initObj) {
        int initPosX = ((Long)initObj.get("posX")).intValue();
        int initPosY = ((Long)initObj.get("posY")).intValue();
        this.setPosition((float)initPosX, (float)initPosY);
    }

    public void init(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public void initParameters(JSONObject jsonParameters, JSONObject jsonMoney) {
        this.money.init(jsonMoney);
        this.parameters.init(jsonParameters);
        Const.game.getGui().getInventoryWindow().getEquipInventory().updateLabels(this.parameters.getDefence(), this.parameters.getAntiCrit(), this.parameters.getDamage(), this.parameters.getDamageRange(), this.parameters.getCrit());
    }

    public void setPosition(float x, float y) {
        super.setPosition(x * 100.0F, y * 100.0F);
    }

    public void act(float delta) {
        super.act(delta);
        boolean result = false;
        Warp warp = null;
        Iterator var4 = Const.game.getGame().getWarps().getChildren().iterator();

        while(var4.hasNext()) {
            Actor actor = (Actor)var4.next();
            if (actor instanceof Warp) {
                result = this.inWarp((Warp)actor);
                if (result) {
                    warp = (Warp)actor;
                }
            }
        }

        if (warp != null) {
            Const.game.getGui().enableWarpFields(warp);
            Const.game.getGui().setTitle(warp.getTitle());
        } else {
            Const.game.getGui().disableWarpFields();
            Const.game.getGui().setTitle(Const.screen.getLevelName());
        }

        super.toFront();
    }

    private boolean inWarp(Warp warp) {
        boolean result = false;
        int xC = (int)this.getX() + 50;
        int yC = (int)this.getY() + 50;
        if ((float)xC >= warp.getX() && (float)xC <= warp.getX() + 100.0F && (float)yC >= warp.getY() && (float)yC <= warp.getY() + 100.0F) {
            result = true;
        }

        return result;
    }

    public void loadAnimations() {
        this.idle = PlayersAtlasLoader.idle;
        this.sleep = PlayersAtlasLoader.sleep;
        this.animMoveLeft = new Array();
        this.animMoveLeft.add(PlayersAtlasLoader.left_move1);
        this.animMoveLeft.add(PlayersAtlasLoader.left_move2);
        this.animMoveLeft.add(PlayersAtlasLoader.left_move3);
        this.animMoveLeft.add(PlayersAtlasLoader.left_move4);
        this.animMoveRight = new Array();
        this.animMoveRight.add(PlayersAtlasLoader.right_move1);
        this.animMoveRight.add(PlayersAtlasLoader.right_move2);
        this.animMoveRight.add(PlayersAtlasLoader.right_move3);
        this.animMoveRight.add(PlayersAtlasLoader.right_move4);
        this.animMoveDown = new Array();
        this.animMoveDown.add(PlayersAtlasLoader.down_move1);
        this.animMoveDown.add(PlayersAtlasLoader.down_move2);
        this.animMoveDown.add(PlayersAtlasLoader.down_move3);
        this.animMoveDown.add(PlayersAtlasLoader.down_move4);
        this.animMoveTop = new Array();
        this.animMoveTop.add(PlayersAtlasLoader.top_move1);
        this.animMoveTop.add(PlayersAtlasLoader.top_move2);
        this.animMoveTop.add(PlayersAtlasLoader.top_move3);
        this.animMoveTop.add(PlayersAtlasLoader.top_move4);
        this.setSprite(this.idle);
    }

    public void loadLocAnimations() {
        this.animExtractResLeft.clear();
        this.animExtractResLeft.add(PlayersAtlasLoader.extract_res_left1);
        this.animExtractResLeft.add(PlayersAtlasLoader.extract_res_left2);
        this.animExtractResLeft.add(PlayersAtlasLoader.extract_res_left3);
        this.animExtractResLeft.add(PlayersAtlasLoader.extract_res_left4);
        this.animExtractResLeft.add(PlayersAtlasLoader.extract_res_left5);
        this.animExtractResRight.clear();
        this.animExtractResRight.add(PlayersAtlasLoader.extract_res_right1);
        this.animExtractResRight.add(PlayersAtlasLoader.extract_res_right2);
        this.animExtractResRight.add(PlayersAtlasLoader.extract_res_right3);
        this.animExtractResRight.add(PlayersAtlasLoader.extract_res_right4);
        this.animExtractResRight.add(PlayersAtlasLoader.extract_res_right5);
        this.animExtractResDown.clear();
        this.animExtractResDown.add(PlayersAtlasLoader.extract_res_down1);
        this.animExtractResDown.add(PlayersAtlasLoader.extract_res_down2);
        this.animExtractResDown.add(PlayersAtlasLoader.extract_res_down3);
        this.animExtractResDown.add(PlayersAtlasLoader.extract_res_down4);
        this.animExtractResDown.add(PlayersAtlasLoader.extract_res_down5);
        this.animExtractResTop.clear();
        this.animExtractResTop.add(PlayersAtlasLoader.extract_res_top1);
        this.animExtractResTop.add(PlayersAtlasLoader.extract_res_top2);
        this.animExtractResTop.add(PlayersAtlasLoader.extract_res_top3);
        this.animExtractResTop.add(PlayersAtlasLoader.extract_res_top4);
        this.animExtractResTop.add(PlayersAtlasLoader.extract_res_top5);
    }

    public int getPlayerX() {
        return (int)super.getX() / 100;
    }

    public int getPlayerY() {
        return (int)super.getY() / 100;
    }

    public String getName() {
        return this.name;
    }

    public PlayerParameters getParameters() {
        return this.parameters;
    }

    public PlayerMoney getMoney() {
        return this.money;
    }

    public PlayerInventory getInventory() {
        return this.inventory;
    }

    public EquipedInventory getEquipped() {
        return this.equipped;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isMove() {
        return this.move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public void stopMove() {
        this.blocked = false;
        this.move = false;
        super.stop();
        this.setSprite(this.idle);
    }

    public void startMove(PlayerAction action) {
        if (action == PlayerAction.MOVE_LEFT) {
            this.blocked = true;
            this.move = true;
            this.setAnimation(this.animMoveLeft);
            super.start();
        } else if (action == PlayerAction.MOVE_RIGHT) {
            this.blocked = true;
            this.move = true;
            this.setAnimation(this.animMoveRight);
            super.start();
        } else if (action == PlayerAction.MOVE_TOP) {
            this.blocked = true;
            this.move = true;
            this.setAnimation(this.animMoveTop);
            super.start();
        } else if (action == PlayerAction.MOVE_DOWN) {
            this.blocked = true;
            this.move = true;
            this.setAnimation(this.animMoveDown);
            super.start();
        } else if (action == PlayerAction.EXTRACT_RES_TOP) {
            this.setAnimation(this.animExtractResTop);
            super.start();
        } else if (action == PlayerAction.EXTRACT_RES_DOWN) {
            this.setAnimation(this.animExtractResDown);
            super.start();
        } else if (action == PlayerAction.EXTRACT_RES_RIGHT) {
            this.setAnimation(this.animExtractResRight);
            super.start();
        } else if (action == PlayerAction.EXTRACT_RES_LEFT) {
            this.setAnimation(this.animExtractResLeft);
            super.start();
        }

    }

    public void startRest() {
        if (this.blocked) {
            Const.game.getGui().getBtnRest().setActive(true);
        } else {
            this.blocked = true;
            this.setSprite(this.sleep);
            SendPasket.rest();
        }
    }

    public void stopRest() {
        this.blocked = false;
        this.setSprite(this.idle);
        Const.game.getGui().getBtnRest().setActive(true);
    }

    public long getId() {
        return this.id;
    }
}

