package ru.megains.farlandsOld.inventory.item;


public class ItemAttribute {
    public static String ATT_ONE_HEND = "onehend";
    public static final String ATT_DAMAGE = "dmg";
    public static final String ATT_DMG_RANGE = "dmgrange";
    public static final String ATT_CRIT = "crit";
    public static final String ATT_DEFENCE = "def";
    public static final String ATT_ANTI_CRIT = "anticrit";
    public static final String ATT_MINE_DAMAGE = "minedmg";
    public static final String ATT_MINE_DMG_RANGE = "minedmgrange";
    public static final String ATT_MINE_DEFENCE = "minedef";
    public static final String ATT_INTELLECT = "int";
    public static final String ATT_CONC = "conc";
    public static final String ATT_STRENGHT = "strenght";
    public static final String ATT_STAMINA = "stamina";
    public static final String ATT_LIFE = "life";
    public static final String ATT_ENERGY = "energy";
    public static final String ATT_EQUILIBRIUM = "equilibrium";
    public static final String ATT_CARRYNG = "carryng";
    public String attrName;
    public Object attrValue;

    public ItemAttribute(String attrName, Object attrValue) {
        this.attrName = attrName;
        this.attrValue = attrValue;
    }

    public float getFloatValue() {
        Double dValue = (Double)this.attrValue;
        return dValue.floatValue();
    }

    public int getIntegerValue() {
        try {
            Long lValue = (Long)this.attrValue;
            return lValue.intValue();
        } catch (Exception var3) {
            String result = "" + this.attrValue.toString();
            return Integer.parseInt(result);
        }
    }

    public boolean getBooleanValue() {
        Boolean bValue = (Boolean)this.attrValue;
        return bValue;
    }

    public String getAttrName() {
        return this.attrName;
    }

    public Object getObjectValue() {
        return this.attrValue;
    }
}

