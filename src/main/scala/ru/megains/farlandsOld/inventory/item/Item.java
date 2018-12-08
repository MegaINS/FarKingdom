package ru.megains.farlandsOld.inventory.item;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.JsonUtil;

import java.util.ArrayList;

public class Item {
    private long id = 0L;
    private int imageId = 0;
    private String itemTag = "";
    private String subTag = "";
    private String name = "";
    private int itemClass;
    private float price = 0.0F;
    private float weight = 0.0F;
    private float life = 0.0F;
    private float maxLife = 0.0F;
    private boolean stacked = false;
    private boolean usable = false;
    private boolean cantsell = false;
    private boolean personal = false;
    private int count = 0;
    private int minLevel = 0;
    private int maxLevel = 0;
    private boolean eZet = false;
    private ArrayList<ItemAttribute> attribute = new ArrayList();

    public Item(JSONObject item) throws ParseException {
        this.id = (Long)item.get("id");
        this.imageId = ((Long)item.get("imageId")).intValue();
        this.itemTag = (String)item.get("itemTag");
        this.subTag = (String)item.get("subTag");
        this.name = (String)item.get("name");
        this.itemClass = ((Long)item.get("itemClass")).intValue();
        this.price = ((Double)item.get("price")).floatValue();
        this.weight = ((Double)item.get("weight")).floatValue();
        this.life = ((Double)item.get("life")).floatValue();
        this.maxLife = ((Double)item.get("maxLife")).floatValue();
        this.stacked = (Boolean)item.get("stacked");
        this.usable = (Boolean)item.get("usable");
        this.cantsell = (Boolean)item.get("cantsell");
        this.personal = (Boolean)item.get("personal");
        this.count = ((Long)item.get("count")).intValue();
        this.minLevel = ((Long)item.get("minLevel")).intValue();
        this.maxLevel = ((Long)item.get("maxLevel")).intValue();
        this.eZet = (Boolean)item.get("eZet");
        JSONObject attrs = (JSONObject)item.get("attribute");
        this.attribute = JsonUtil.toItemAttributeArrayList(attrs);
    }

    public boolean attributeExist(String attrName) {
        for(int i = 0; i < this.attribute.size(); ++i) {
            if (((ItemAttribute)this.attribute.get(i)).getAttrName().equals(attrName)) {
                return true;
            }
        }

        return false;
    }

    public ItemAttribute getAttributeByName(String attrName) {
        for(int i = 0; i < this.attribute.size(); ++i) {
            if (((ItemAttribute)this.attribute.get(i)).getAttrName().equals(attrName)) {
                return (ItemAttribute)this.attribute.get(i);
            }
        }

        return null;
    }

    public long getId() {
        return this.id;
    }

    public int getImageId() {
        return this.imageId;
    }

    public int getItemClass() {
        return this.itemClass;
    }

    public String getItemTag() {
        return this.itemTag;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public float getWeight() {
        return this.weight;
    }

    public float getLife() {
        return this.life;
    }

    public float getMaxLife() {
        return this.maxLife;
    }

    public boolean isStacked() {
        return this.stacked;
    }

    public int getCount() {
        return this.count;
    }

    public String getSubTag() {
        return this.subTag;
    }

    public void setSubTag(String subTag) {
        this.subTag = subTag;
    }

    public boolean iseZet() {
        return this.eZet;
    }

    public boolean isUsable() {
        return this.usable;
    }

    public boolean isCantsell() {
        return this.cantsell;
    }

    public boolean isPersonal() {
        return this.personal;
    }

    public ArrayList<ItemAttribute> getAttribute() {
        return this.attribute;
    }

    public int getMinLevel() {
        return this.minLevel;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }
}

