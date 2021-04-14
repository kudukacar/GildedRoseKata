package com.example.gildedrose.validator;

class SimpleQualityValidator implements QualityValidation {
    @Override
    public Boolean validateQuality(int quality) {
        if(quality >= 0) {
            return true;
        } else
            return false;
    }
}
