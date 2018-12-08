package ru.megains.farlandsOld.gameobjects.enemyInfoWindow;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Const;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.gui.guileft.EnemyGuiLeft;
import ru.megains.farlandsOld.inventory.AvatarInventoryActor;
import ru.megains.farlandsOld.inventory.EquipInventoryActor;
import ru.megains.farlandsOld.inventory.EquipedInventory;
import ru.megains.farlandsOld.inventory.profile.ProfilePane;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class EnemyInfoWindow extends Window {
    private EnemyInfoWindow window = this;

    public EnemyInfoWindow(String enemyName, JSONObject enemyEquiped, JSONObject enemyParameters, JSONObject enemyProfile) throws ParseException {
        super("Информация об игроке", Styles.guiSkin);
        this.setPosition(400.0F, 100.0F);
        this.setSize(960.0F, 560.0F);
        this.setVisible(true);
        this.setMovable(true);
        MyActor bg = new MyActor(UserInfoAtlasLoader.bg);
        bg.setPosition(0.0F, 0.0F);
        bg.setWidth(590.0F);
        this.addActor(bg);
        MyActor bg2 = new MyActor(UserInfoAtlasLoader.bg);
        bg2.setPosition(590.0F, 0.0F);
        bg2.setWidth(590.0F);
        this.addActor(bg2);
        TextButton closeButton = new TextButton("X", Styles.guiSkin);
        closeButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Const.game.getGui().closeEnemyInfoWindow(EnemyInfoWindow.this.window);
            }
        });
        this.getTitleTable().add(closeButton).size(20.0F, 20.0F).padRight(10.0F).padTop(0.0F);
        int level = ((Long)enemyParameters.get("level")).intValue();
        int hpMax = ((Long)enemyParameters.get("hpMax")).intValue();
        int hpCurent = ((Long)enemyParameters.get("hpCurent")).intValue();
        int energyMax = ((Long)enemyParameters.get("energyMax")).intValue();
        int energyCurrent = ((Long)enemyParameters.get("energyCurrent")).intValue();
        float carringMax = ((Double)enemyParameters.get("carryingMax")).floatValue();
        float carringCurent = ((Double)enemyParameters.get("carryingCurent")).floatValue();
        int strenght = ((Long)enemyParameters.get("strenght")).intValue();
        int conc = ((Long)enemyParameters.get("conc")).intValue();
        int stamina = ((Long)enemyParameters.get("stamina")).intValue();
        int intellect = ((Long)enemyParameters.get("intellect")).intValue();
        EquipedInventory ei = new EquipedInventory();
        ei.load(enemyEquiped);
        EquipInventoryActor enemyEquipedInventory = new EquipInventoryActor(ei);
        EnemyGuiLeft enemyGuiLeft = new EnemyGuiLeft(true, level, hpMax, hpCurent, energyMax, energyCurrent, carringMax, carringCurent, strenght, conc, stamina, intellect, enemyName);
        Group enemyLeftGroup = new Group();
        enemyLeftGroup.addActor(enemyGuiLeft);
        enemyLeftGroup.addActor(enemyEquipedInventory);
        enemyEquipedInventory.setPosition(0.0F, 0.0F);
        enemyGuiLeft.setPosition(0.0F, 335.0F);
        enemyLeftGroup.setPosition(0.0F, 25.0F);
        this.addActor(enemyLeftGroup);
        ProfilePane profileTab = new ProfilePane();
        profileTab.setPosition(171.0F, 385.0F);
        profileTab.loadProfile(enemyProfile);
        this.addActor(profileTab);
        AvatarInventoryActor avatar = new AvatarInventoryActor();
        avatar.setPosition(595.0F, 7.0F);
        this.addActor(avatar);
    }
}

