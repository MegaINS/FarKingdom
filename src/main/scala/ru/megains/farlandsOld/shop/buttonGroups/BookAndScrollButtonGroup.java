package ru.megains.farlandsOld.shop.buttonGroups;


import ru.megains.farlandsOld.loaders.ShopAtlasLoader;
import ru.megains.farlandsOld.shop.*;

public class BookAndScrollButtonGroup extends ButtonsParentGroup {
    private MyGroupNameButton btnBook;
    private MyGroupNameButton btnScroll;
    private MyTypeButtonGroup bookButtons;
    private MyTypeButtonGroup scrollButtons;
    private int nameGroupSelected = -1;

    public BookAndScrollButtonGroup(ClassButtonGroup classButtonGroup, int locId) {
        this.bookButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.bookButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_book, ShopAtlasLoader.over_book, ShopAtlasLoader.sel_book, 0, "book", "", this.bookButtons));
        this.scrollButtons = new MyTypeButtonGroup(classButtonGroup, locId);
        this.scrollButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_craft_forging, ShopAtlasLoader.over_craft_forging, ShopAtlasLoader.sel_craft_forging, 0, "scroll", "forging", this.scrollButtons));
        this.scrollButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_craft_carpenter, ShopAtlasLoader.over_craft_carpenter, ShopAtlasLoader.sel_craft_carpenter, 1, "scroll", "carpenter", this.scrollButtons));
        this.scrollButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_craft_jewelry, ShopAtlasLoader.over_craft_jewelry, ShopAtlasLoader.sel_craft_jewelry, 2, "scroll", "jewelry", this.scrollButtons));
        this.scrollButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_craft_alchemy, ShopAtlasLoader.over_craft_alchemy, ShopAtlasLoader.sel_craft_alchemy, 3, "scroll", "alchemy", this.scrollButtons));
        this.scrollButtons.addButton(new MyTypeButton(ShopAtlasLoader.btn_scroll, ShopAtlasLoader.over_scroll, ShopAtlasLoader.sel_scroll, 4, "scroll", "scrollusable", this.scrollButtons));
        this.btnBook = new MyGroupNameButton(ShopAtlasLoader.btn_books_long, ShopAtlasLoader.over_books_long, ShopAtlasLoader.sel_books_long, this.bookButtons, 0, this);
        this.btnScroll = new MyGroupNameButton(ShopAtlasLoader.btn_scrolls_long, ShopAtlasLoader.over_scrolls_long, ShopAtlasLoader.sel_scrolls_long, this.scrollButtons, 1, this);
        this.btnBook.setPosition(0.0F, 48.0F);
        this.btnScroll.setPosition(this.btnBook.getWidth(), 48.0F);
        this.addActor(this.bookButtons);
        this.addActor(this.scrollButtons);
        this.bookButtons.setVisible(false);
        this.scrollButtons.setVisible(false);
        this.addActor(this.btnBook);
        this.addActor(this.btnScroll);
        this.click(0);
    }

    public void click(int buttonId) {
        this.nameGroupSelected = buttonId;
        this.btnBook.clickChildren(buttonId);
        this.btnScroll.clickChildren(buttonId);
    }

    public int getNameGroupSelected() {
        return this.nameGroupSelected;
    }
}
