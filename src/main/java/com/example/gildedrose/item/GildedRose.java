package com.example.gildedrose.item;

import java.util.ArrayList;

public class GildedRose {
    public static void updateQuality(ArrayList<Updateable> items) {
        items.forEach(Updateable::update);
    }
}
