package ru.megains.farlandsOld.inventory.profile;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import org.json.simple.JSONObject;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class ProfilePane extends Group {
    private MyActor bgChars;
    private Label levelLabel;
    private Label expLabel;
    private Label classLabel;
    private Label genderLabel;
    private Label locationLabel;
    private Label winLabel;
    private Label loseLabel;
    private Label deadheatLabel;

    public ProfilePane() {
        this.bgChars = new MyActor(UserInfoAtlasLoader.bg_chars);
        this.bgChars.setPosition(0.0F, 0.0F);
        this.addActor(this.bgChars);
        this.levelLabel = new Label("0", Styles.labelYellow);
        this.levelLabel.setPosition(8.0F, 114.0F);
        this.levelLabel.setWidth(42.0F);
        this.levelLabel.setAlignment(1);
        this.addActor(this.levelLabel);
        this.expLabel = new Label("0", Styles.labelYellow);
        this.expLabel.setPosition(68.0F, 114.0F);
        this.expLabel.setWidth(86.0F);
        this.expLabel.setAlignment(1);
        this.addActor(this.expLabel);
        this.classLabel = new Label("Класс 0", Styles.labelYellow);
        this.classLabel.setPosition(174.0F, 114.0F);
        this.classLabel.setWidth(65.0F);
        this.classLabel.setAlignment(1);
        this.addActor(this.classLabel);
        this.genderLabel = new Label("М", Styles.labelYellow);
        this.genderLabel.setPosition(8.0F, 74.0F);
        this.genderLabel.setWidth(42.0F);
        this.genderLabel.setAlignment(1);
        this.addActor(this.genderLabel);
        this.locationLabel = new Label("Антирия", Styles.labelYellow);
        this.locationLabel.setPosition(68.0F, 74.0F);
        this.locationLabel.setWidth(170.0F);
        this.locationLabel.setAlignment(1);
        this.addActor(this.locationLabel);
        this.winLabel = new Label("0", Styles.labelYellow);
        this.winLabel.setPosition(266.0F, 74.0F);
        this.winLabel.setWidth(44.0F);
        this.winLabel.setAlignment(1);
        this.addActor(this.winLabel);
        this.loseLabel = new Label("0", Styles.labelYellow);
        this.loseLabel.setPosition(370.0F, 74.0F);
        this.loseLabel.setWidth(44.0F);
        this.loseLabel.setAlignment(1);
        this.addActor(this.loseLabel);
        this.deadheatLabel = new Label("0", Styles.labelYellow);
        this.deadheatLabel.setPosition(318.0F, 74.0F);
        this.deadheatLabel.setWidth(44.0F);
        this.deadheatLabel.setAlignment(1);
        this.addActor(this.deadheatLabel);
    }

    public void loadProfile(JSONObject profile) {
        this.levelLabel.setText("" + profile.get("level"));
        this.expLabel.setText("" + profile.get("exp"));
        this.classLabel.setText("Класс " + profile.get("playerclass"));
        boolean gender = (Boolean)profile.get("gender");
        if (gender) {
            this.genderLabel.setText("Ж");
        } else {
            this.genderLabel.setText("М");
        }

        this.locationLabel.setText("" + profile.get("location"));
        this.winLabel.setText("" + profile.get("win"));
        this.loseLabel.setText("" + profile.get("lose"));
        this.deadheatLabel.setText("" + profile.get("deadheat"));
    }
}

