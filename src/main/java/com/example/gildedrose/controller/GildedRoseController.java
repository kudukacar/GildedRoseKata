package com.example.gildedrose.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GildedRoseController {
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome to the Gilded Rose!\nTo see the inventory append 'items' to your url.\nTo add items to the inventory append the appropriate url (see below) and enter name, sellIn, and quality information in the body of the request.\nNormal --> items/normal\nAgedBrie --> items/agedbrie\nBackstagePasses --> items/backstagepasses\nConjured --> items/conjured\nSulfuras --> items/sulfuras";
    }
}
