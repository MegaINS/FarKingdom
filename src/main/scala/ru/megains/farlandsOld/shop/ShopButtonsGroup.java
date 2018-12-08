package ru.megains.farlandsOld.shop;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import ru.megains.farlandsOld.inventory.InfinityInventoryActor;
import ru.megains.farlandsOld.inventory.PlayerInventory;
import ru.megains.farlandsOld.shop.buttonGroups.BookAndScrollButtonGroup;
import ru.megains.farlandsOld.shop.buttonGroups.JewelsAndPotionsButtonGroup;
import ru.megains.farlandsOld.shop.buttonGroups.ResAndToolsButtonGroup;
import ru.megains.farlandsOld.shop.buttonGroups.WeaponAndArmorButtonGroup;

public class ShopButtonsGroup extends Group {
    private ButtonsParentGroup buttonsGroup;
    private ClassButtonGroup classButtonsGroup;
    private PlayerInventory shopInventory = new PlayerInventory();
    private InfinityInventoryActor shopInventoryActor;

    public ShopButtonsGroup(int locId) {
        this.shopInventoryActor = new InfinityInventoryActor(400, 350, this.shopInventory, (new Table()).left().top());
        this.classButtonsGroup = new ClassButtonGroup(this);
        switch(locId) {
            case 6001:
                this.buttonsGroup = new ResAndToolsButtonGroup(this.classButtonsGroup, locId);
                break;
            case 6002:
                this.buttonsGroup = new BookAndScrollButtonGroup(this.classButtonsGroup, locId);
                break;
            case 6003:
                this.buttonsGroup = new JewelsAndPotionsButtonGroup(this.classButtonsGroup, locId);
                break;
            case 6004:
                this.buttonsGroup = new WeaponAndArmorButtonGroup(this.classButtonsGroup, locId);
        }

        if (this.buttonsGroup != null) {
            this.classButtonsGroup.setPosition(0.0F, this.shopInventoryActor.getHeight() + 10.0F + 90.0F);
            this.buttonsGroup.setPosition(25.0F, this.shopInventoryActor.getHeight() + 10.0F);
            this.addActor(this.classButtonsGroup);
            this.addActor(this.buttonsGroup);
            this.addActor(this.shopInventoryActor);
        }
    }

    public void selectClass() {
        if (this.buttonsGroup != null && this.buttonsGroup.getNameGroupSelected() >= 0) {
            this.buttonsGroup.click(this.buttonsGroup.getNameGroupSelected());
        }
    }

    public InfinityInventoryActor getShopInventoryActor() {
        return this.shopInventoryActor;
    }
}

