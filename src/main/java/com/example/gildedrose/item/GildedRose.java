package com.example.gildedrose.item;

import java.util.ArrayList;

public class GildedRose {
    public ArrayList<Updateable> items;

    public GildedRose(ArrayList<Updateable> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(Updateable::update);
    }

    public Object getItems() {
        return this.items;
    }
}
