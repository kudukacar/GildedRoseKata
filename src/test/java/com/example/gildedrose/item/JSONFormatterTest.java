package com.example.gildedrose.item;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JSONFormatterTest {
    @Test
    void jsonFormatterReturnsTheObjectInJSON() {
        JSONFormatter formatter = new JSONFormatter();
        JSONObject jsonObject = new JSONObject();
        GildedRose gildedRose = new GildedRose(new ArrayList<>());
        assertEquals(formatter.format(gildedRose.getItems()), "");
    }

    private class GildedRose {
        public ArrayList<Updateable> items;

        public GildedRose(ArrayList<Updateable> items) {
            this.items = items;
        }

        public ArrayList<Updateable> getItems () {
            return items;
        }
    }
}