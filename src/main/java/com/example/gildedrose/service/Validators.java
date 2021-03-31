package com.example.gildedrose.service;

import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.validator.Validation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Validators {
    private ArrayList<Validation> validators;

    public Validators() {
        this.validators = new ArrayList<Validation>();
    }

    public void add(Validation validator) {
        this.validators.add(validator);
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
