package com.example.gildedrose.validator;

import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;

import java.util.List;


public class Validators {
    private List<Validation> validators;

    public Validators(List<Validation> validators) {

        this.validators = validators;
    }

    public Updateable validate(ProposedItem proposedItem) {
        for(Validation validator : this.validators) {
            Updateable item = validator.validate(proposedItem);
            if(item != null) {
                return item;
            }
        }
        return null;
    }
}
