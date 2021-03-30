package com.example.gildedrose.item;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void gildedRoseUpdatesEachItem() {
        int initialSellIn = 5;
        int initialQuality = 10;
        BrieItem brieItem = new BrieItem(initialSellIn, initialQuality);
        BreadItem baguetteItem = new BreadItem(initialSellIn, initialQuality);
        ArrayList<Updateable> items = new ArrayList<>(Arrays.asList(brieItem, baguetteItem));
        GildedRose.updateQuality(items);
        assertEquals(initialQuality + 1, brieItem.quality);
        assertEquals(initialSellIn - 1, brieItem.sellIn);
        assertEquals(initialQuality, baguetteItem.quality);
        assertEquals(initialSellIn, baguetteItem.sellIn);
    }
    private class BrieItem implements Updateable {
        public int sellIn;
        public int quality;

        public BrieItem(int sellIn, int quality) {
            this.sellIn = sellIn;
            this.quality = quality;
        }
        @Override
        public void update() {
            this.sellIn -= 1;
            this.quality += 1;
        }
    }

    private class BreadItem implements Updateable {
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