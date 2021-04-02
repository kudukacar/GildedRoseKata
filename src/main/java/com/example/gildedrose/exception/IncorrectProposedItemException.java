package com.example.gildedrose.exception;

public class IncorrectProposedItemException extends RuntimeException{
    public IncorrectProposedItemException() {
        super("Incorrect item type, quality or sellIn. Quality must be between 0 and 50 inclusive, except for conjured items.  Conjured items sellIn is 0 and quality is 80.");
    }
}
