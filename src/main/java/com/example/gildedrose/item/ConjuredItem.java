package com.example.gildedrose.item;

public class ConjuredItem implements Itemable {
    public final String name;
    public int sellIn;
    public int quality;

    public ConjuredItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void update() {
        this.sellIn -= 1;
        if (this.sellIn >= 0) {
            this.quality = Math.max(0, this.quality -= 2);
        } else {
            this.quality = Math.max(0, this.quality -= 4);
        }
    }
}
