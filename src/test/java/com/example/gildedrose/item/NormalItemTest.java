package com.example.gildedrose.item;

import com.example.gildedrose.item.NormalItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalItemTest {
    @Test
    void normalItemQualityMinIsZero() {
        NormalItem item = new NormalItem("An old sword", 0, 0);
        item.update();
        assertEquals(0, item.quality);
    }

    @Test
    void normalItemsDegradeByTwoAfterSellInIsLessThan0() {
        NormalItem item = new NormalItem("An old sword", 0, 10);
        item.update();
        assertEquals(8, item.quality);
    }

    @Test
    void normalItemsDegradeByOneWhenSellInIsAboveZero() {
        NormalItem item = new NormalItem("An old sword", 1, 10);
        item.update();
        assertEquals(9, item.quality);
    }

    @Test
    void normalItemsSellInDecreasesByOne() {
        NormalItem item = new NormalItem("An old sword", 0, 10);
        item.update();
        assertEquals(-1, item.sellIn);
    }
}