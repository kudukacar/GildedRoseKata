package com.example.gildedrose.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredItemTest {
    @Test
    void conjuredItemQualityMinIsZero() {
        ConjuredItem item = new ConjuredItem("Conjured", 0, 1);
        item.update();
        assertEquals(0, item.getQuality());
    }

    @Test
    void conjuredItemSellInDecreasesByOne() {
        ConjuredItem item = new ConjuredItem("Conjured", 2, 10);
        item.update();
        assertEquals(1, item.getSellIn());
    }

    @Test
    void conjuredItemsDegradeByTwoWhenInDate() {
        ConjuredItem item = new ConjuredItem("Conjured", 1, 10);
        item.update();
        assertEquals(8, item.getQuality());
    }

    @Test
    void conjuredItemsDegradeByFourWhenExpired() {
        ConjuredItem item = new ConjuredItem("Conjured", 0, 10);
        item.update();
        assertEquals(6, item.getQuality());
    }
}