package com.example.gildedrose.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasItemTest {
    @Test
    void sulfurasValuesAreConstant() {
        SulfurasItem item = new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80);
        item.update();
        assertEquals(0, item.getSellIn());
        assertEquals(80, item.getQuality());
    }

}