package com.example.gildedrose.validator;

import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.SulfurasItem;
import com.example.gildedrose.item.Updateable;

public class SulfurasValidator implements Validation{

    @Override
    public Updateable validate(ProposedItem proposedItem) {
        if(proposedItem.itemType.equals("Sulfuras") && proposedItem.sellIn == 0 && proposedItem.quality == 80) {
            return new SulfurasItem(proposedItem.name, proposedItem.sellIn, proposedItem.quality);
        } else {
            return null;
        }
    }
}
