package com.example.gildedrose.item;

public class SulfurasItem implements Updateable {
    private final String name;
    private int sellIn;
    private int quality;

    public SulfurasItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void update() {

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
