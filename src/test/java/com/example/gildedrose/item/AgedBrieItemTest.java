package com.example.gildedrose.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieItemTest {
    @Test
    void agedBrieQualityMaxIs50() {
        AgedBrieItem item = new AgedBrieItem("Aged Brie", 0, 50);
        item.update();
        assertEquals(50, item.getQuality());
    }

    @Test
    void agedBrieQualityIncreasesByOneWhenSellInGreaterThanOrEqualToZero() {
        AgedBrieItem item = new AgedBrieItem("Aged Brie", 1, 20);
        item.update();
        assertEquals(21, item.getQuality());
    }

    @Test
    void agedBrieQualityIncreasesByTwoWhenLessThanZero() {
        AgedBrieItem item = new AgedBrieItem("Aged Brie", 0, 20);
        item.update();
        assertEquals(22, item.getQuality());
    }

    @Test
    void agedBrieSellInDecreasesByOne() {
        AgedBrieItem item = new AgedBrieItem("Aged Brie", 0, 20);
        item.update();
        assertEquals(-1, item.getSellIn());
    }
}