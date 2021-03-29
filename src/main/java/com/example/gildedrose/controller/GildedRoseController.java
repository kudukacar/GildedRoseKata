package com.example.gildedrose.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GildedRoseController {
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome to the Gilded Rose!\nTo see the inventory append '/items' to your current url.";
    }
}
