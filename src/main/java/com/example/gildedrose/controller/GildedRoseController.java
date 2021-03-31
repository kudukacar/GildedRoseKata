package com.example.gildedrose.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GildedRoseController {
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome to the Gilded Rose!\nTo see the inventory append 'items' to your url.\nTo add items to the inventory, append 'items' to your url, and enter itemType (see below), name, sellIn, and quality information in the body of the post request.\nItem types include 'AgedBrie', 'BackstagePasses', 'Conjured', 'Normal', and 'Sulfuras'.";
    }
}
