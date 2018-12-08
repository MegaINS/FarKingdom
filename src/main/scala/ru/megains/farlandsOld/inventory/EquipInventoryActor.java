package ru.megains.farlandsOld.inventory;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.gameobjects.MyActor;
import ru.megains.farlandsOld.inventory.item.Item;
import ru.megains.farlandsOld.loaders.UserInfoAtlasLoader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EquipInventoryActor extends Group implements EquipedListener {
    public static final byte SLOT_HEAD = 1;
    public static final byte SLOT_EARRING_LEFT = 2;
    public static final byte SLOT_EARRING_RIGHT = 3;
    public static final byte SLOT_NECKLACE = 4;
    public static final byte SLOT_BRACERS = 5;
    public static final byte SLOT_RING_LEFT = 6;
    public static final byte SLOT_RING_RIGHT = 7;
    public static final byte SLOT_ARMOR = 8;
    public static final byte SLOT_SHEILD = 9;
    public static final byte SLOT_WEAPON = 10;
    public static final byte SLOT_BOTS = 11;
    public static final byte SLOT_TOOL = 12;
    public static final byte SLOT_EQIP1 = 13;
    public static final byte SLOT_EQIP2 = 14;
    public static final byte SLOT_EQIP3 = 15;
    public static final byte SLOT_EQIP4 = 16;
    public static final byte SLOT_EQIP5 = 17;
    private MyActor bg_items;
    private MyActor mask_items;
    private int slotSelected = 0;
    private Label defence;
    private Label damage;
    private EquipedInventory equipedInventory;
    private HashMap<Byte, EquipedInventorySlot> slots = new HashMap();

    public EquipInventoryActor(EquipedInventory equipedInventory) throws ParseException {
        this.equipedInventory = equipedInventory;
        this.bg_items = new MyActor(UserInfoAtlasLoader.bg_items);
        this.addActor(this.bg_items);
        this.mask_items = new MyActor(UserInfoAtlasLoader.mask_items);
        this.addActor(this.mask_items);
        EquipedInventorySlot boots = new EquipedInventorySlot(11, 58, 47, this);
        this.addActor(boots);
        boots.setWidth(58.0F);
        boots.setHeight(47.0F);
        boots.setPosition(7.0F, 33.0F);
        this.slots.put((byte) 11, boots);
        EquipedInventorySlot head = new EquipedInventorySlot(1, 58, 47, this);
        this.addActor(head);
        head.setWidth(58.0F);
        head.setHeight(47.0F);
        head.setPosition(55.0F, 286.0F);
        this.slots.put((byte)1, head);
        EquipedInventorySlot sheild = new EquipedInventorySlot(9, 58, 47, this);
        this.addActor(sheild);
        sheild.setWidth(58.0F);
        sheild.setHeight(47.0F);
        sheild.setPosition(7.0F, 96.0F);
        this.slots.put((byte)9, sheild);
        EquipedInventorySlot weapon = new EquipedInventorySlot(10, 88, 47, this);
        this.addActor(weapon);
        weapon.setWidth(88.0F);
        weapon.setHeight(47.0F);
        weapon.setPosition(71.0F, 96.0F);
        this.slots.put((byte)10, weapon);
        EquipedInventorySlot tool = new EquipedInventorySlot(12, 88, 47, this);
        this.addActor(tool);
        tool.setWidth(88.0F);
        tool.setHeight(47.0F);
        tool.setPosition(71.0F, 33.0F);
        this.slots.put((byte)12, tool);
        EquipedInventorySlot earringLeft = new EquipedInventorySlot(2, 26, 26, this);
        this.addActor(earringLeft);
        earringLeft.setWidth(26.0F);
        earringLeft.setHeight(26.0F);
        earringLeft.setPosition(23.0F, 292.0F);
        this.slots.put((byte)2, earringLeft);
        EquipedInventorySlot earringRight = new EquipedInventorySlot(3, 26, 26, this);
        this.addActor(earringRight);
        earringRight.setWidth(26.0F);
        earringRight.setHeight(26.0F);
        earringRight.setPosition(119.0F, 292.0F);
        this.slots.put((byte)3, earringRight);
        EquipedInventorySlot ringLeft = new EquipedInventorySlot(6, 26, 26, this);
        this.addActor(ringLeft);
        ringLeft.setWidth(26.0F);
        ringLeft.setHeight(26.0F);
        ringLeft.setPosition(7.0F, 150.0F);
        this.slots.put((byte)6, ringLeft);
        EquipedInventorySlot ringRight = new EquipedInventorySlot(7, 26, 26, this);
        this.addActor(ringRight);
        ringRight.setWidth(26.0F);
        ringRight.setHeight(26.0F);
        ringRight.setPosition(133.0F, 150.0F);
        this.slots.put((byte)7, ringRight);
        EquipedInventorySlot braslets = new EquipedInventorySlot(5, 65, 35, this);
        this.addActor(braslets);
        braslets.setWidth(65.0F);
        braslets.setHeight(35.0F);
        braslets.setPosition(86.0F, 247.0F);
        this.slots.put((byte)5, braslets);
        EquipedInventorySlot necklace = new EquipedInventorySlot(4, 65, 35, this);
        this.addActor(necklace);
        necklace.setWidth(65.0F);
        necklace.setHeight(35.0F);
        necklace.setPosition(15.0F, 247.0F);
        this.slots.put((byte)4, necklace);
        EquipedInventorySlot armor = new EquipedInventorySlot(8, this);
        this.addActor(armor);
        armor.setWidth(88.0F);
        armor.setHeight(96.0F);
        armor.setPosition(39.0F, 147.0F);
        this.slots.put((byte)8, armor);
        EquipedInventorySlot equip1 = new EquipedInventorySlot(13, 26, 26, this);
        this.addActor(equip1);
        equip1.setWidth(26.0F);
        equip1.setHeight(26.0F);
        equip1.setPosition(7.0F, 3.0F);
        this.slots.put((byte)13, equip1);
        EquipedInventorySlot equip2 = new EquipedInventorySlot(14, 26, 26, this);
        this.addActor(equip2);
        equip2.setWidth(26.0F);
        equip2.setHeight(26.0F);
        equip2.setPosition(39.0F, 3.0F);
        this.slots.put((byte)14, equip2);
        EquipedInventorySlot equip3 = new EquipedInventorySlot(15, 26, 26, this);
        this.addActor(equip3);
        equip3.setWidth(26.0F);
        equip3.setHeight(26.0F);
        equip3.setPosition(70.0F, 3.0F);
        this.slots.put((byte)15, equip3);
        EquipedInventorySlot equip4 = new EquipedInventorySlot(16, 26, 26, this);
        this.addActor(equip4);
        equip4.setWidth(26.0F);
        equip4.setHeight(26.0F);
        equip4.setPosition(101.0F, 3.0F);
        this.slots.put((byte)16, equip4);
        EquipedInventorySlot equip5 = new EquipedInventorySlot(17, 26, 26, this);
        this.addActor(equip5);
        equip5.setWidth(26.0F);
        equip5.setHeight(26.0F);
        equip5.setPosition(133.0F, 3.0F);
        this.slots.put((byte)17, equip5);
        this.defence = new Label("", Styles.labelYellow);
        this.defence.setPosition(22.0F, 90.0F);
        this.defence.setWidth(42.0F);
        this.defence.setAlignment(1);
        this.addActor(this.defence);
        this.damage = new Label("", Styles.labelYellow);
        this.damage.setPosition(84.0F, 90.0F);
        this.damage.setWidth(70.0F);
        this.damage.setAlignment(1);
        this.addActor(this.damage);
        equipedInventory.addListener(this);
        this.equip();
    }

    public void equip() throws ParseException {
        this.clearAll();
        System.out.println(this.equipedInventory.getEquiped().size());
        Iterator var1 = this.equipedInventory.getEquiped().entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<Byte, Item> items = (Map.Entry)var1.next();
            ((EquipedInventorySlot)this.slots.get(items.getKey())).equip((Item)items.getValue());
        }

    }

    public void selectSlot(EquipedInventorySlot slot) {
        this.slotSelected = slot.getSlotId();
        slot.select();
        this.wasClicked(slot.getSlotId());
    }

    public void wasClicked(int clickedId) {
        Iterator var2 = this.slots.keySet().iterator();

        while(var2.hasNext()) {
            Byte key = (Byte)var2.next();
            ((EquipedInventorySlot)this.slots.get(key)).wasClicked(clickedId);
        }

    }

    public int getSelectedSlotId() {
        return this.slotSelected;
    }

    public EquipedInventorySlot getSelectedSlot() {
        return this.slotSelected > 0 ? (EquipedInventorySlot)this.slots.get(this.slotSelected) : null;
    }

    public void updateLabels(int defence, int anticrit, int damage, int damageRange, int crit) {
        this.defence.setText("" + defence + " (" + anticrit + ")");
        this.damage.setText("" + damage + " - " + (damage + damageRange) + " (" + crit + ")");
    }

    private void clearAll() {
        Iterator var1 = this.slots.entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<Byte, EquipedInventorySlot> entry = (Map.Entry)var1.next();
            ((EquipedInventorySlot)entry.getValue()).takeOff();
        }

    }

    public void hasChanged() throws ParseException {
        this.slotSelected = -1;
        this.equip();
    }

    public EquipedInventory getEquipedInventory() {
        return this.equipedInventory;
    }
}

