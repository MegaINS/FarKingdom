package ru.megains.farlandsOld.base;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.megains.farlandsOld.inventory.item.ItemAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JsonUtil {
    public JsonUtil() {
    }

    public static HashMap<String, Object> toMap(JSONObject object) {
        HashMap<String, Object> map = new HashMap();

        String key;
        Object value;
        for(Iterator var2 = object.keySet().iterator(); var2.hasNext(); map.put(key, value)) {
            Object keysItr = var2.next();
            key = (String)keysItr;
            value = object.get(key);
            if (value instanceof JSONArray) {
                value = toList((JSONArray)value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject)value);
            }
        }

        return map;
    }

    public static ArrayList<ItemAttribute> toItemAttributeArrayList(JSONObject jsonObject) {
        ArrayList<ItemAttribute> list = new ArrayList();
        Iterator var2 = jsonObject.keySet().iterator();

        while(var2.hasNext()) {
            Object keysItr = var2.next();
            String key = (String)keysItr;
            Object value = jsonObject.get(key);
            list.add(new ItemAttribute(key, value));
        }

        return list;
    }

    public static List<Object> toList(JSONArray array) {
        List<Object> list = new ArrayList();

        for(int i = 0; i < array.size(); ++i) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray)value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject)value);
            }

            list.add(value);
        }

        return list;
    }
}

