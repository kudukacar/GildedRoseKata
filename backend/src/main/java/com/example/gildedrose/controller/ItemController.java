package com.example.gildedrose.controller;

import com.example.gildedrose.exception.IncorrectProposedItemException;
import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import com.example.gildedrose.validator.Validators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ItemController {
    private Validators validators;
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository, Validators validators) {

        this.itemRepository = itemRepository;
        this.validators = validators;
    }

    @GetMapping("/items")
    public ArrayList<Updateable> getAllItems() {
        return itemRepository.findAll();
    }

    @PostMapping("/items")
    public Updateable addItem(@RequestBody ProposedItem proposedItem) throws Exception {
        Updateable item = validators.validate(proposedItem);
        if(item != null) {
            return itemRepository.save(item);
        } else {
            throw new IncorrectProposedItemException();
        }
    }
}
