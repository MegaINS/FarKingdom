package ru.megains.farlandsOld.shop.buttonGroups;


import ru.megains.farlandsOld.loaders.ShopAtlasLoader;
import ru.megains.farlandsOld.shop.*;

public class JewelsAndPotionsButtonGroup extends ButtonsParentGroup {
    private int nameGroupSelected = -1;
    private MyGroupNameButton btnJewel;
    private MyGroupNameButton btnPotion;
    private MyTypeButtonGroup jewelButtons;
    private MyTypeButtonGroup potionButtons;

    public JewelsAndPotionsButtonGroup(ClassButtonGroup classButtonGroup, int locId) {
        this.jewelButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.jewelButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_amulets, ShopAtlasLoader.over_amulets, ShopAtlasLoader.sel_amulets, 0, "necklace", "", this.jewelButtons));
        this.jewelButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_diadems, ShopAtlasLoader.over_diadems, ShopAtlasLoader.sel_diadems, 1, "head", "diadem", this.jewelButtons));
        this.jewelButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_earrings, ShopAtlasLoader.over_earrings, ShopAtlasLoader.sel_earrings, 2, "earring", "", this.jewelButtons));
        this.jewelButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_ring, ShopAtlasLoader.over_ring, ShopAtlasLoader.sel_ring, 3, "ring", "", this.jewelButtons));
        this.potionButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.potionButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_potions, ShopAtlasLoader.over_potions, ShopAtlasLoader.sel_potions, 0, "potion", "", this.potionButtons));
        this.potionButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_potions1, ShopAtlasLoader.over_potions1, ShopAtlasLoader.sel_potions1, 1, "potion", "", this.potionButtons));
        this.potionButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_potions2, ShopAtlasLoader.over_potions2, ShopAtlasLoader.sel_potions2, 2, "potion", "", this.potionButtons));
        this.btnJewel = new MyGroupNameButton(ShopAtlasLoader.btn_jewelry_long, ShopAtlasLoader.over_jewelry_long, ShopAtlasLoader.sel_jewelry_long, this.jewelButtons, 0, this);
        this.btnPotion = new MyGroupNameButton(ShopAtlasLoader.btn_potions_long, ShopAtlasLoader.over_potions_long, ShopAtlasLoader.sel_potions_long, this.potionButtons, 1, this);
        this.btnJewel.setPosition(0.0F, 48.0F);
        this.btnPotion.setPosition(this.btnJewel.getWidth(), 48.0F);
        this.addActor(this.jewelButtons);
        this.addActor(this.potionButtons);
        this.jewelButtons.setVisible(false);
        this.potionButtons.setVisible(false);
        this.addActor(this.btnJewel);
        this.addActor(this.btnPotion);
        this.click(0);
    }

    public void click(int buttonId) {
        this.nameGroupSelected = buttonId;
        this.btnJewel.clickChildren(buttonId);
        this.btnPotion.clickChildren(buttonId);
    }

    public int getNameGroupSelected() {
        return this.nameGroupSelected;
    }
}

