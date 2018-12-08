package ru.megains.farlandsOld.sclad;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.loaders.StoreAtlasLoader;

public class SkladServicesGroup extends Group {
    private BtnBack btnBack;

    public SkladServicesGroup(SkladWindow skladWindow, int skladId) {
        Label cellSmall = new Label("маленькая", Styles.labelBlack);
        cellSmall.setPosition(20.0F, 110.0F);
        Label cellBig = new Label("большая", Styles.labelBlack);
        cellBig.setPosition(20.0F, 80.0F);
        Label cellType = new Label("тип ячейки", Styles.labelBlack);
        cellType.setPosition(40.0F, 135.0F);
        Label weght = new Label("вместимость, кг.", Styles.labelBlack);
        weght.setPosition(180.0F, 135.0F);
        Label store = new Label("Аренда ячеек", Styles.labelBlack);
        store.setPosition(160.0F, 160.0F);
        Label price = new Label("цена", Styles.labelBlack);
        price.setPosition(360.0F, 135.0F);
        Label services = new Label("СЕРВИСЫ ХРАНИЛИЩА", Styles.labelBlack);
        services.setPosition(160.0F, 180.0F);
        Group smallCellWeight = new Group();
        Label smallCellWeightLabel = new Label("  100", Styles.labelYellow);
        MyActor smallCellWeightBg = new MyActor(StoreAtlasLoader.bg_type_count);
        smallCellWeight.addActor(smallCellWeightBg);
        smallCellWeight.addActor(smallCellWeightLabel);
        smallCellWeight.setPosition(weght.getX() + 20.0F, cellSmall.getY());
        Group smallCellPrice = new Group();
        Label smallCellPriceLabel = new Label("  5.0", Styles.labelYellow);
        MyActor smallCellPriceBg = new MyActor(StoreAtlasLoader.bg_type_count);
        smallCellPrice.addActor(smallCellPriceBg);
        smallCellPrice.addActor(smallCellPriceLabel);
        smallCellPrice.setPosition(price.getX(), cellSmall.getY());
        Group bigCellWeight = new Group();
        Label bigCellWeightLabel = new Label("1000", Styles.labelYellow);
        MyActor bigCellWeightBg = new MyActor(StoreAtlasLoader.bg_type_count);
        bigCellWeight.addActor(bigCellWeightBg);
        bigCellWeight.addActor(bigCellWeightLabel);
        bigCellWeight.setPosition(weght.getX() + 20.0F, cellBig.getY());
        Group biglCellPrice = new Group();
        Label biglCellPriceLabel = new Label(" 50.0", Styles.labelYellow);
        MyActor biglCellPriceBg = new MyActor(StoreAtlasLoader.bg_type_count);
        biglCellPrice.addActor(biglCellPriceBg);
        biglCellPrice.addActor(biglCellPriceLabel);
        biglCellPrice.setPosition(price.getX(), cellBig.getY());
        BtnBuy bySmall = new BtnBuy(100, skladId);
        bySmall.setPosition(440.0F, cellSmall.getY() - 2.0F);
        BtnBuy byBig = new BtnBuy(1000, skladId);
        byBig.setPosition(440.0F, cellBig.getY() - 2.0F);
        this.addActor(cellSmall);
        this.addActor(cellBig);
        this.addActor(cellType);
        this.addActor(weght);
        this.addActor(store);
        this.addActor(price);
        this.addActor(services);
        this.addActor(smallCellWeight);
        this.addActor(smallCellPrice);
        this.addActor(bigCellWeight);
        this.addActor(biglCellPrice);
        this.addActor(bySmall);
        this.addActor(byBig);
        this.btnBack = new BtnBack(skladWindow, skladId);
        this.btnBack.setPosition(440.0F, 160.0F);
        this.addActor(this.btnBack);
    }
}

