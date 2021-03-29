package com.example.gildedrose.service;

import com.example.gildedrose.item.Updateable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemRepository {
    private ArrayList<Updateable> items;

    public ItemRepository() {
        this.items = new ArrayList<Updateable>();
    }

    public Updateable save(Updateable item) {
        this.items.add(item);
        return item;
    }

    public ArrayList<Updateable> findAll() {
        return this.items;
    }
}
