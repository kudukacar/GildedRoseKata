package com.example.gildedrose.validator;

import com.example.gildedrose.item.AgedBrieItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.item.ProposedItem;

public class AgedBrieValidator implements Validation {
    private final QualityValidation qualityValidator;

    public AgedBrieValidator(QualityValidation qualityValidator) {
        this.qualityValidator = qualityValidator;
    }
    @Override
    public Updateable validate(ProposedItem proposedItem) {
        if(proposedItem.itemType.equals("AgedBrie") && this.qualityValidator.validateQuality(proposedItem.quality)) {
            return new AgedBrieItem(proposedItem.name, proposedItem.sellIn, proposedItem.quality);
        } else {
            return null;
        }
    }
}
