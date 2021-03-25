package com.example.gildedrose.item;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void gildedRoseGetsAllItems() {
        BrieItem brieItem = new BrieItem(0, 0);
        ArrayList<Updateable> items = new ArrayList<>(Arrays.asList(brieItem));
        Formattable formatter = new Formatter();
        GildedRose app = new GildedRose(items, formatter);
        assertEquals(items, app.getItems());
    }

    @Test
    void gildedRoseUpdatesEachItem() {
        BrieItem brieItem = new BrieItem(0, 0);
        BreadItem baguetteItem = new BreadItem(0, 0);
        ArrayList<Updateable> items = new ArrayList<>(Arrays.asList(brieItem, baguetteItem));
        Formattable formatter = new Formatter();
        GildedRose app = new GildedRose(items, formatter);
        app.updateQuality();
        assertEquals(1, brieItem.quality);
        assertEquals(1, brieItem.sellIn);
        assertEquals(0, baguetteItem.quality);
        assertEquals(0, baguetteItem.sellIn);
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
            this.sellIn += 1;
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

    private class Formatter implements Formattable {

        @Override
        public Object format(ArrayList<Updateable>items) {
            return items;
        }
    }
}