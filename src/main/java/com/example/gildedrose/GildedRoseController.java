package com.example.gildedrose;

import com.example.gildedrose.item.Updateable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GildedRoseController {
    private final GildedRoseService gildedRoseService;

    public GildedRoseController(GildedRoseService gildedRoseService) {
        this.gildedRoseService = gildedRoseService;
    }
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome to the Gilded Rose!\nTo see the inventory append '/items' to your current url.";
    }

    @GetMapping("/items")
    public ArrayList<Updateable> getItems() {
        return gildedRoseService.getGildedRose().getItems();
    }
}
