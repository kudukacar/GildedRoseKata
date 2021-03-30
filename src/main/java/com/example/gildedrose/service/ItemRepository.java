package com.example.gildedrose.service;

import com.example.gildedrose.item.GildedRose;
import com.example.gildedrose.item.Updateable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemRepository {
    private ArrayList<Updateable> items;

    public ItemRepository() {
        this.items = new ArrayList<>();
    }

    public Updateable save(Updateable item) {
        this.items.add(item);
        return item;
    }

    public ArrayList<Updateable> findAll() {
        return this.items;
    }

    public void update() {
        ArrayList<Updateable> updated = GildedRose.updateQuality(items);
        updated.add(items.get(0));
        this.items = updated;
    }
}
