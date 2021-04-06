package com.example.gildedrose.service;

import com.example.gildedrose.item.GildedRose;
import com.example.gildedrose.item.Updateable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemUpdater {
    ItemRepository itemRepository;

    @Autowired
    public ItemUpdater(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Scheduled(cron = "* * * * * ?")
    public void performUpdate() {
        ArrayList<Updateable> items = itemRepository.findAll();
        itemRepository.update(GildedRose.updateQuality(items));
    }
}
