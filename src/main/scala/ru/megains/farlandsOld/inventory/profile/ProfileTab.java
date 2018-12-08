package ru.megains.farlandsOld.inventory.profile;

import com.badlogic.gdx.scenes.scene2d.Group;
import org.json.simple.JSONObject;
import ru.megains.farlandsOld.inventory.skill.SkillListPane;

public class ProfileTab extends Group {
    private ProfilePane profilePane = new ProfilePane();
    private SkillListPane skills;

    public ProfileTab() {
        this.profilePane.setPosition(0.0F, 330.0F);
        this.addActor(this.profilePane);
        this.skills = new SkillListPane();
        this.skills.setPosition(10.0F, 0.0F);
        this.addActor(this.skills);
    }

    public void loadProfileAndSkills(JSONObject jsonObject) {
        this.profilePane.loadProfile((JSONObject)jsonObject.get("profile"));
        this.skills.loadSkills((JSONObject)jsonObject.get("playerskills"));
    }
}