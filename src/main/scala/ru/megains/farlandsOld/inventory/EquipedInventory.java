package ru.megains.farlandsOld.inventory;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.inventory.item.Item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class EquipedInventory {
    private HashMap<Byte, Item> equiped = new HashMap();
    private LinkedList<EquipedListener> listeners = new LinkedList();

    public EquipedInventory() {
    }

    public void load(JSONObject equiped) throws ParseException {
        this.equiped.clear();
        Iterator var2 = equiped.keySet().iterator();

        while(var2.hasNext()) {
            Object keysItr = var2.next();
            Byte key = Byte.parseByte((String)keysItr);
            JSONObject value = (JSONObject)equiped.get("" + key);
            this.equiped.put(key, new Item(value));
        }

        this.notyfiListeners();
        System.out.println("size" + equiped.size());
    }

    public void addListener(EquipedListener listener) {
        this.listeners.add(listener);
    }

    public void notyfiListeners() throws ParseException {
        for(int i = 0; i < this.listeners.size(); ++i) {
            ((EquipedListener)this.listeners.get(i)).hasChanged();
        }

    }

    public HashMap<Byte, Item> getEquiped() {
        return this.equiped;
    }
}

