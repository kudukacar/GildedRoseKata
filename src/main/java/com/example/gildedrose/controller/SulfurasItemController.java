package com.example.gildedrose.controller;

import com.example.gildedrose.item.SulfurasItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SulfurasItemController {
    private ItemRepository itemRepository;

    public SulfurasItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/items/sulfuras")
    Updateable addSulfurasItem(@RequestBody SulfurasItem sulfurasItem) {
        return itemRepository.save(sulfurasItem);
    }
}
