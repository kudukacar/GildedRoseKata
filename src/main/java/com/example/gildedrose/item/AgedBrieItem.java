package com.example.gildedrose.item;

public class AgedBrieItem implements Updateable {
    private final String name;
    private int sellIn;
    private int quality;

    public AgedBrieItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    @Override
    public void update() {
        this.sellIn -= 1;
        if (this.sellIn >= 0) {
            this.quality = Math.min(50, this.quality + 1);
        } else {
            this.quality = Math.min(50, this.quality + 2);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSellIn() {
        return this.sellIn;
    }

    @Override
    public int getQuality() {
        return this.quality;
    }
}
