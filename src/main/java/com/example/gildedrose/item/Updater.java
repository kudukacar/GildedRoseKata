package com.example.gildedrose.item;

public class Updater {
    public Itemable[] items;

    public Updater(Itemable[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Itemable item : items) {
                item.update();
        }
    }
}
