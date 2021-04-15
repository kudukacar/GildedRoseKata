package com.example.gildedrose.validator;

import com.example.gildedrose.item.ConjuredItem;
import com.example.gildedrose.item.ProposedItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConjuredValidatorTest {
    @Test
    void itReturnsAConjuredItemIfValidRequest() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        ConjuredValidator conjuredValidator = new ConjuredValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Conjured", "Conjured Mana Cake", 10, 10);

        assertTrue(conjuredValidator.validate(proposedItem) instanceof ConjuredItem);
    }

    @Test
    void itReturnsNullIfInvalidItemType() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        ConjuredValidator conjuredValidator = new ConjuredValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Normal", "Conjured Mana Cake", 10, 10);
        assertNull(conjuredValidator.validate(proposedItem));
    }

    @Test
    void itReturnsNullIfInvalidQuality() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        ConjuredValidator conjuredValidator = new ConjuredValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Conjured", "Conjured Mana Cake", 0, -1);
        assertNull(conjuredValidator.validate(proposedItem));
    }
}