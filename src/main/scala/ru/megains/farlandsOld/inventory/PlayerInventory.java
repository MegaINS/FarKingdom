package ru.megains.farlandsOld.inventory;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.megains.farlandsOld.inventory.item.Item;

import java.util.HashMap;
import java.util.LinkedList;

public class PlayerInventory {
    private HashMap<Long, Item> itemsList = new HashMap();
    private LinkedList<InventoryListener> listeners = new LinkedList();

    public PlayerInventory() {
    }

    public void load(JSONArray items) throws ParseException {
        this.itemsList.clear();
        JSONParser parser = new JSONParser();

        for(int i = 0; i < items.size(); ++i) {
            Object obj = parser.parse(items.get(i).toString());
            JSONObject jsonObj = (JSONObject)obj;
            Item item = new Item(jsonObj);
            this.itemsList.put(item.getId(), item);
            System.out.println("Player inventory load Item");
        }

        this.notyfiListeners();
    }

    public HashMap<Long, Item> getItemsList() {
        return this.itemsList;
    }

    public void clearInventory() {
        this.itemsList.clear();
    }

    public void addListener(InventoryListener listener) {
        this.listeners.add(listener);
    }

    public void notyfiListeners() {
        for(int i = 0; i < this.listeners.size(); ++i) {
            ((InventoryListener)this.listeners.get(i)).hasChanged();
        }

    }
}

