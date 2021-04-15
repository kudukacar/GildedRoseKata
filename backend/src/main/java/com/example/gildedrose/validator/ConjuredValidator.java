package com.example.gildedrose.validator;

import com.example.gildedrose.item.ConjuredItem;
import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;

public class ConjuredValidator implements Validation{
    private final QualityValidation qualityValidator;

    public ConjuredValidator(QualityValidation qualityValidator) {
        this.qualityValidator = qualityValidator;
    }

    @Override
    public Updateable validate(ProposedItem proposedItem) {
        if(proposedItem.itemType.equals("Conjured") && this.qualityValidator.validateQuality(proposedItem.quality)) {
            return new ConjuredItem(proposedItem.name, proposedItem.sellIn, proposedItem.quality);
        } else {
            return null;
        }
    }
}
