package com.example.gildedrose.controller;

import com.example.gildedrose.item.NormalItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalItemController {
    private ItemRepository itemRepository;

    public NormalItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/items/normal")
    Updateable addNormalItem(@RequestBody NormalItem normalItem) {
        return itemRepository.save(normalItem);
    }
}
