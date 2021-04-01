package com.example.gildedrose.validator;

import com.example.gildedrose.item.BackstagePassesItem;
import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;

public class BackstagePassesValidator implements Validation{
    private final QualityValidation qualityValidator;

    public BackstagePassesValidator(QualityValidation qualityValidator) {
        this.qualityValidator = qualityValidator;
    }
    @Override
    public Updateable validate(ProposedItem proposedItem) {
        if(proposedItem.itemType.equals("BackstagePasses") && this.qualityValidator.validateQuality(proposedItem.quality)) {
            return new BackstagePassesItem(proposedItem.name, proposedItem.sellIn, proposedItem.quality);
        } else {
            return null;
        }
    }
}
