package com.example.gildedrose.validator;

import com.example.gildedrose.item.NormalItem;
import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;

public class NormalValidator implements Validation{
    private final QualityValidation qualityValidator;

    public NormalValidator(QualityValidation qualityValidator) {
        this.qualityValidator = qualityValidator;
    }
    @Override
    public Updateable validate(ProposedItem proposedItem) {
        if(proposedItem.itemType.equals("Normal") && this.qualityValidator.validateQuality(proposedItem.quality)) {
            return new NormalItem(proposedItem.name, proposedItem.sellIn, proposedItem.quality);
        } else {
            return null;
        }
    }
}
