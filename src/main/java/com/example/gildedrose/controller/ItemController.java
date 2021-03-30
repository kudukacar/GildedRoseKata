package com.example.gildedrose.controller;

import com.example.gildedrose.service.ItemRepository;
import com.example.gildedrose.item.Updateable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ItemController {
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public ArrayList<Updateable> getAllItems() {
        return itemRepository.findAll();
    }
}
