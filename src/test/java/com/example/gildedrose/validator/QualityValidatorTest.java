package com.example.gildedrose.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QualityValidatorTest {
    @Test
    void itReturnsTrueIfQualityBetweenZeroAndFifty() {
        QualityValidator qualityValidator = new QualityValidator();
        assertTrue(qualityValidator.validateQuality(0));
        assertTrue(qualityValidator.validateQuality(50));
        assertTrue(qualityValidator.validateQuality(20));
    }

    @Test
    void itReturnsFalseIfQualityLessThanZero() {
        QualityValidator qualityValidator = new QualityValidator();
        assertFalse(qualityValidator.validateQuality(-1));
    }

    @Test
    void itReturnsFalseIfQualityGreaterThanFifty() {
        QualityValidator qualityValidator = new QualityValidator();
        assertFalse(qualityValidator.validateQuality(51));
    }
}
