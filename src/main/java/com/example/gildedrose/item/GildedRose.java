package com.example.gildedrose.item;

import java.util.ArrayList;

public class GildedRose {
    public static ArrayList<Updateable> updateQuality(ArrayList<Updateable> items) {
        items.forEach(Updateable::update);
        return items;
    }
}
