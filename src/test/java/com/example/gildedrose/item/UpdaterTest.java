package com.example.gildedrose.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdaterTest {
    @Test
    void gildedRoseUpdatesEachItem() {
        BrieItem brieItem = new BrieItem(0, 0);
        BreadItem baguetteItem = new BreadItem(0, 0);
        Itemable[] items = new Itemable[] { brieItem, baguetteItem };
        Updater app = new Updater(items);
        app.updateQuality();
        assertEquals(1, brieItem.quality);
        assertEquals(1, brieItem.sellIn);
        assertEquals(0, baguetteItem.quality);
        assertEquals(0, baguetteItem.sellIn);
    }
    private class BrieItem implements Itemable {
        public int sellIn;
        public int quality;

        public BrieItem(int sellIn, int quality) {
            this.sellIn = sellIn;
            this.quality = quality;
        }
        @Override
        public void update() {
            this.sellIn += 1;
            this.quality += 1;
        }
    }

    private class BreadItem implements Itemable {
        public int sellIn;
        public int quality;

        public BreadItem(int sellIn, int quality) {
            this.sellIn = sellIn;
            this.quality = quality;
        }
        @Override
        public void update() {
        }
    }
}