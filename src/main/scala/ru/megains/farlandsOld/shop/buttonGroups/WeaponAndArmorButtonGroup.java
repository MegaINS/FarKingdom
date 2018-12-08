package ru.megains.farlandsOld.shop.buttonGroups;


import ru.megains.farlandsOld.loaders.ShopAtlasLoader;
import ru.megains.farlandsOld.shop.*;

public class WeaponAndArmorButtonGroup extends ButtonsParentGroup {
    private MyGroupNameButton btnWeapon;
    private MyGroupNameButton btnArmor;
    private MyTypeButtonGroup weaponButtons;
    private MyTypeButtonGroup armorButtons;
    private int nameGroupSelected = -1;

    public WeaponAndArmorButtonGroup(ClassButtonGroup classButtonGroup, int locId) {
        this.weaponButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.weaponButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_sword, ShopAtlasLoader.over_sword, ShopAtlasLoader.sel_sword, 0, "weapon", "wpnsword", this.weaponButtons));
        this.weaponButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_axe, ShopAtlasLoader.over_axe, ShopAtlasLoader.sel_axe, 1, "weapon", "wpnaxe", this.weaponButtons));
        this.weaponButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_hammer, ShopAtlasLoader.over_hammer, ShopAtlasLoader.sel_hammer, 2, "weapon", "wpnahammer", this.weaponButtons));
        this.weaponButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_dagger, ShopAtlasLoader.over_dagger, ShopAtlasLoader.sel_dagger, 3, "weapon", "wpndagger", this.weaponButtons));
        this.armorButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.armorButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_armor, ShopAtlasLoader.over_armor, ShopAtlasLoader.sel_armor, 0, "armor", "armorbattle", this.armorButtons));
        this.armorButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_boots, ShopAtlasLoader.over_boots, ShopAtlasLoader.sel_boots, 1, "bots", "", this.armorButtons));
        this.armorButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_bracers, ShopAtlasLoader.over_bracers, ShopAtlasLoader.sel_bracers, 2, "bracers", "", this.armorButtons));
        this.armorButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_helmet, ShopAtlasLoader.over_helmet, ShopAtlasLoader.sel_helmet, 3, "head", "hemlet", this.armorButtons));
        this.armorButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_shield, ShopAtlasLoader.over_shield, ShopAtlasLoader.sel_shield, 4, "sheild", "", this.armorButtons));
        this.btnWeapon = new MyGroupNameButton(ShopAtlasLoader.btn_weapon_long, ShopAtlasLoader.over_weapon_long, ShopAtlasLoader.sel_weapon_long, this.weaponButtons, 0, this);
        this.btnArmor = new MyGroupNameButton(ShopAtlasLoader.btn_armor_long, ShopAtlasLoader.over_armor_long, ShopAtlasLoader.sel_armor_long, this.armorButtons, 1, this);
        this.btnWeapon.setPosition(0.0F, 48.0F);
        this.btnArmor.setPosition(this.btnWeapon.getWidth(), 48.0F);
        this.addActor(this.weaponButtons);
        this.addActor(this.armorButtons);
        this.weaponButtons.setVisible(false);
        this.armorButtons.setVisible(false);
        this.addActor(this.btnWeapon);
        this.addActor(this.btnArmor);
        this.click(0);
    }

    public void click(int buttonId) {
        this.nameGroupSelected = buttonId;
        this.btnWeapon.clickChildren(buttonId);
        this.btnArmor.clickChildren(buttonId);
    }

    public int getNameGroupSelected() {
        return this.nameGroupSelected;
    }
}

