package ru.megains.farlandsOld.inventory;

import org.json.simple.parser.ParseException;

public interface EquipedListener {
    void hasChanged() throws ParseException;
}