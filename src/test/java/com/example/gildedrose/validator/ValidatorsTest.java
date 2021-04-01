package com.example.gildedrose.validator;

import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.SulfurasItem;
import com.example.gildedrose.item.Updateable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorsTest {
    @Test
    void itValidatesAProposedItemAgainstValidatorsAndReturnsTheItemWhenValid() {
        Validators validators = new Validators(Arrays.asList(new SimpleValidator()));
        ProposedItem proposedItem = new ProposedItem("Sulfuras", "Sulfuras", 0, 0);
        assertTrue(validators.validate(proposedItem) instanceof Updateable);
    }

    @Test
    void itValidatesAProposedItemAgainstValidatorsAndReturnsNullWhenNotValid() {
        Validators validators = new Validators(Arrays.asList(new NullValidator()));
        ProposedItem proposedItem = new ProposedItem("Sulfuras", "Sulfuras", 0, 0);
        assertNull(validators.validate(proposedItem));
    }


    private class SimpleValidator implements Validation{

        @Override
        public Updateable validate(ProposedItem proposedItem) {
            return new SulfurasItem("Sulfuras", 0, 0);
        }
    }

    private class NullValidator implements Validation{

        @Override
        public Updateable validate(ProposedItem proposedItem) {
            return null;
        }
    }

}