package com.example.gildedrose.controller;

import com.example.gildedrose.item.ConjuredItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConjuredItemController {
    private ItemRepository itemRepository;

    public ConjuredItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/items/conjured")
    Updateable addConjuredItem(@RequestBody ConjuredItem conjuredItem) {
        return itemRepository.save(conjuredItem);
    }
}
