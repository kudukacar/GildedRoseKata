package com.example.gildedrose.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalItemTest {
    @Test
    void normalItemQualityMinIsZero() {
        NormalItem item = new NormalItem("An old sword", 0, 0);
        item.update();
        assertEquals(0, item.getQuality());
    }

    @Test
    void normalItemsDegradeByTwoAfterSellInIsLessThan0() {
        NormalItem item = new NormalItem("An old sword", 0, 10);
        item.update();
        assertEquals(8, item.getQuality());
    }

    @Test
    void normalItemsDegradeByOneWhenSellInIsAboveZero() {
        NormalItem item = new NormalItem("An old sword", 1, 10);
        item.update();
        assertEquals(9, item.getQuality());
    }

    @Test
    void normalItemsSellInDecreasesByOne() {
        NormalItem item = new NormalItem("An old sword", 0, 10);
        item.update();
        assertEquals(-1, item.getSellIn());
    }
}