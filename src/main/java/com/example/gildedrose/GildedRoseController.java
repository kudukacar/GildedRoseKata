package com.example.gildedrose;

import com.example.gildedrose.item.GildedRose;
import com.example.gildedrose.item.NormalItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class GildedRoseController {
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome to the Gilded Rose!";
    }

    @RequestMapping("/items")
    public Object getItems() {
        return new GildedRose(new ArrayList<>(Arrays.asList(new NormalItem("Normal", 0, 0)))).getItems();
    }
}
