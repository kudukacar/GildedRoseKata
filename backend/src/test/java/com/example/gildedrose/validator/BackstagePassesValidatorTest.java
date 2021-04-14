package com.example.gildedrose.validator;

import com.example.gildedrose.item.BackstagePassesItem;
import com.example.gildedrose.item.ProposedItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BackstagePassesValidatorTest {
    @Test
    void itReturnsABackStagePassesItemIfValidRequest() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        BackstagePassesValidator backstagePassesValidator = new BackstagePassesValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("BackstagePasses", "Backstage passes to a TAFKAL80ETC concert", 10, 10);

        assertTrue(backstagePassesValidator.validate(proposedItem) instanceof BackstagePassesItem);
    }

    @Test
    void itReturnsNullIfInvalidItemType() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        BackstagePassesValidator backstagePassesValidator = new BackstagePassesValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("Normal", "Backstage passes to a TAFKAL80ETC concert", 10, 10);
        assertNull(backstagePassesValidator.validate(proposedItem));
    }

    @Test
    void itReturnsNullIfInvalidQuality() {
        QualityValidation qualityValidator = new SimpleQualityValidator();
        BackstagePassesValidator backstagePassesValidator = new BackstagePassesValidator(qualityValidator);
        ProposedItem proposedItem = new ProposedItem("BackstagePasses", "Backstage passes to a TAFKAL80ETC concert", 0, -1);
        assertNull(backstagePassesValidator.validate(proposedItem));
    }
}