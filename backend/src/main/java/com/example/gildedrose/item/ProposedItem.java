package com.example.gildedrose.item;

public class ProposedItem {
    public final String itemType;
    public final String name;
    public final int sellIn;
    public final int quality;

    public ProposedItem(String itemType, String name, int sellIn, int quality) {
        this.itemType = itemType;
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}