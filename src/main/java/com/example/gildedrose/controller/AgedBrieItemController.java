package com.example.gildedrose.controller;

import com.example.gildedrose.item.AgedBrieItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgedBrieItemController {
    private ItemRepository itemRepository;

    public AgedBrieItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/items/agedbrie")
    Updateable addAgedBrieItem(@RequestBody AgedBrieItem agedBrieItem) {
        return itemRepository.save(agedBrieItem);
    }
}
