package com.example.gildedrose.validator;

import com.example.gildedrose.item.AgedBrieItem;
import com.example.gildedrose.item.ProposedItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgedBrieValidatorTest {
    @Test
    void itReturnsAnAgedBrieItemIfValidRequest() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        AgedBrieValidator agedBrieValidator = new AgedBrieValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("AgedBrie", "Aged Brie Noir", 10, 10);

        assertTrue(agedBrieValidator.validate(proposedItem) instanceof AgedBrieItem);
    }

    @Test
    void itReturnsNullIfInvalidItemType() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        AgedBrieValidator agedBrieValidator = new AgedBrieValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Normal", "Aged Brie Noir", 10, 10);
        assertNull(agedBrieValidator.validate(proposedItem));
    }

    @Test
    void itReturnsNullIfInvalidQuality() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        AgedBrieValidator agedBrieValidator = new AgedBrieValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("AgedBrie", "Aged Brie", 0, -1);
        assertNull(agedBrieValidator.validate(proposedItem));
    }

}