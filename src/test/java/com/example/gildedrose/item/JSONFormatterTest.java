package com.example.gildedrose.item;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class JSONFormatterTest {
    @Test
    void jsonFormatterReturnsTheObjectInJSON() {
        JSONFormatter formatter = new JSONFormatter();
        ArrayList<Updateable> items = new ArrayList<>(Arrays.asList());
        JSONObject object = new JSONObject();
        assertEquals(formatter.format(items), "");
    }
}