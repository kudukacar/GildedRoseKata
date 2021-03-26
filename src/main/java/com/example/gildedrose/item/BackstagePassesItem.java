package com.example.gildedrose.item;

public class BackstagePassesItem implements Updateable {
    public final String name;
    public int sellIn;
    public int quality;

    public BackstagePassesItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public void update() {
        this.sellIn -= 1;
        if (this.sellIn >= 10) {
            this.quality = Math.min(50, this.quality + 1);
        } else if (this.sellIn < 10 && this.sellIn >= 5) {
            this.quality = Math.min(50, this.quality + 2);
        } else if (this.sellIn < 5 && this.sellIn >= 0) {
            this.quality = Math.min(50, this.quality + 3);
        } else {
            this.quality = 0;
        }
    }
}
