package com.example.gildedrose.validator;

public class QualityValidator implements QualityValidation{

    @Override
    public Boolean validateQuality(int quality) {
        if(quality >= 0 && quality <= 50) {
            return true;
        } else {
            return false;
        }
    }
}
