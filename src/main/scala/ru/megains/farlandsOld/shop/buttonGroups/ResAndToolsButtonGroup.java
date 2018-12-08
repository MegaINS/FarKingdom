package ru.megains.farlandsOld.shop.buttonGroups;


import ru.megains.farlandsOld.loaders.ShopAtlasLoader;
import ru.megains.farlandsOld.shop.*;

public class ResAndToolsButtonGroup extends ButtonsParentGroup {
    private MyGroupNameButton btnRes;
    private MyGroupNameButton btnTools;
    private MyTypeButtonGroup resButtons;
    private MyTypeButtonGroup toolButtons;
    private int nameGroupSelected = -1;

    public ResAndToolsButtonGroup(ClassButtonGroup classButtonGroup, int locId) {
        this.toolButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.toolButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.toolButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_mine, ShopAtlasLoader.over_mine, ShopAtlasLoader.sel_mine, 0, "minetool", "", this.toolButtons));
        this.toolButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_armor, ShopAtlasLoader.over_armor, ShopAtlasLoader.sel_armor, 1, "minearmor", "", this.toolButtons));
        this.toolButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_craft_forging, ShopAtlasLoader.over_craft_forging, ShopAtlasLoader.sel_craft_forging, 2, "crafttool", "", this.toolButtons));
        this.resButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.resButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_metal, ShopAtlasLoader.over_metal, ShopAtlasLoader.sel_metal, 0, "res", "resmine", this.resButtons));
        this.resButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_wood, ShopAtlasLoader.over_wood, ShopAtlasLoader.sel_wood, 1, "res", "reswood", this.resButtons));
        this.resButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_leather, ShopAtlasLoader.over_leather, ShopAtlasLoader.sel_leather, 2, "res", "reshunt", this.resButtons));
        this.resButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_gem, ShopAtlasLoader.over_gem, ShopAtlasLoader.sel_gem, 3, "res", "reshgem", this.resButtons));
        this.btnRes = new MyGroupNameButton(ShopAtlasLoader.btn_resources_long, ShopAtlasLoader.over_resources_long, ShopAtlasLoader.sel_resources_long, this.resButtons, 0, this);
        this.btnTools = new MyGroupNameButton(ShopAtlasLoader.btn_tools_long, ShopAtlasLoader.over_tools_long, ShopAtlasLoader.sel_tools_long, this.toolButtons, 1, this);
        this.btnRes.setPosition(0.0F, 48.0F);
        this.btnTools.setPosition(this.btnRes.getWidth(), 48.0F);
        this.addActor(this.resButtons);
        this.addActor(this.toolButtons);
        this.toolButtons.setVisible(false);
        this.resButtons.setVisible(false);
        this.addActor(this.btnRes);
        this.addActor(this.btnTools);
        this.click(0);
    }

    public void click(int buttonId) {
        this.nameGroupSelected = buttonId;
        this.btnRes.clickChildren(buttonId);
        this.btnTools.clickChildren(buttonId);
    }

    public int getNameGroupSelected() {
        return this.nameGroupSelected;
    }
}

