package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GildedRoseController {
    @RequestMapping("/")
    public String index() {
        return "Welcome to the Gilded Rose!";
    }
}
