package com.example.gildedrose;

import com.example.gildedrose.item.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class GildedRoseService {
    private GildedRose gildedRose;

    public GildedRoseService() {
        this.gildedRose = new GildedRose(new ArrayList<>(Arrays.asList(
                new NormalItem("Normal", 10, 10),
                new AgedBrieItem("AgedBrie", -1, 20),
                new SulfurasItem("Sulfuras", 0, 80),
                new ConjuredItem("Conjured", 10, 10),
                new BackstagePassesItem("BackstagePasses", 5, 25)
        )));
    }

    public GildedRose getGildedRose() {
        return this.gildedRose;
    }
}
