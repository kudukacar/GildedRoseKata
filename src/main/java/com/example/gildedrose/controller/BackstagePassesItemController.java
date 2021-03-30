package com.example.gildedrose.controller;

import com.example.gildedrose.item.BackstagePassesItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackstagePassesItemController {
    private ItemRepository itemRepository;

    public BackstagePassesItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/items/backstagepasses")
    Updateable addBackstagePassesItem(@RequestBody BackstagePassesItem backstagePassesItem) {
        return itemRepository.save(backstagePassesItem);
    }
}
