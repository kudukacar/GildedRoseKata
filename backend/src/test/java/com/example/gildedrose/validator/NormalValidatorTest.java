package com.example.gildedrose.validator;

import com.example.gildedrose.item.NormalItem;
import com.example.gildedrose.item.ProposedItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NormalValidatorTest {
    @Test
    void itReturnsANormalItemIfValidRequest() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        NormalValidator normalValidator = new NormalValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Normal", "Elixir of the Mongoose", 10, 10);

        assertTrue(normalValidator.validate(proposedItem) instanceof NormalItem);
    }

    @Test
    void itReturnsNullIfInvalidItemType() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        NormalValidator normalValidator = new NormalValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Conjured", "Elixir of the Mongoose", 10, 10);
        assertNull(normalValidator.validate(proposedItem));
    }

    @Test
    void itReturnsNullIfInvalidQuality() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        NormalValidator normalValidator = new NormalValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Normal", "Elixir of the Mongoose", 0, -1);
        assertNull(normalValidator.validate(proposedItem));
    }
}