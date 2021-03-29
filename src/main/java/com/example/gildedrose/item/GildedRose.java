package com.example.gildedrose.item;

import java.util.ArrayList;

public class GildedRose {
    private ArrayList<Updateable> items;

    public GildedRose(ArrayList<Updateable> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(Updateable::update);
    }
}
