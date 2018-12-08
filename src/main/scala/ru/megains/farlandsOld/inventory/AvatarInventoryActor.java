package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.Group;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

public class AvatarInventoryActor extends Group {
    public AvatarInventoryActor() {
        MyActor bgRight = new MyActor(UserInfoAtlasLoader.bg_frame);
        this.addActor(bgRight);
    }
}

