package com.example.gildedrose.item;

import java.util.ArrayList;

public class GildedRose {
    private final Formattable formatter;
    public ArrayList<Updateable> items;

    public GildedRose(ArrayList<Updateable> items, Formattable formatter) {
        this.items = items;
        this.formatter = formatter;
    }

    public void updateQuality() {
        items.forEach(Updateable::update);
    }

    public Object getItems() {
        return formatter.format(this.items);
    }
}
