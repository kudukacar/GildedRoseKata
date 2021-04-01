package com.example.gildedrose.validator;

import com.example.gildedrose.item.SulfurasItem;
import com.example.gildedrose.item.ProposedItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SulfurasValidatorTest {
    @Test
    void itReturnsASulfurasItemIfValidRequest() {
        SulfurasValidator sulfurasValidator = new SulfurasValidator();
        ProposedItem proposedItem = new ProposedItem("Sulfuras", "Sulfuras, Hand of Ragnaros", 0, 80);

        assertTrue(sulfurasValidator.validate(proposedItem) instanceof SulfurasItem);
    }

    @Test
    void itReturnsNullIfInvalidItemType() {
        SulfurasValidator sulfurasValidator = new SulfurasValidator();
        ProposedItem proposedItem = new ProposedItem("Conjured", "Sulfuras, Hand of Ragnaros", 0, 80);
        assertNull(sulfurasValidator.validate(proposedItem));
    }

    @Test
    void itReturnsNullIfInvalidQuality() {
        SulfurasValidator sulfurasValidator = new SulfurasValidator();
        ProposedItem proposedItem = new ProposedItem("Sulfuras", "Sulfuras, Hand of Ragnaros", 0, 50);
        assertNull(sulfurasValidator.validate(proposedItem));
    }

    @Test
    void itReturnsNullIfInvalidSellIn() {
        SulfurasValidator sulfurasValidator = new SulfurasValidator();
        ProposedItem proposedItem = new ProposedItem("Sulfuras", "Sulfuras, Hand of Ragnaros", 1, 80);
        assertNull(sulfurasValidator.validate(proposedItem));
    }
}