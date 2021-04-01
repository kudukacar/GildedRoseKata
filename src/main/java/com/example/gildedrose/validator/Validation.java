package com.example.gildedrose.validator;

import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.item.ProposedItem;

public interface Validation {
    public Updateable validate(ProposedItem proposedItem);
}
