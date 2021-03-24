package com.example.gildedrose;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GildedRoseController {
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome to the Gilded Rose!";
    }
}
