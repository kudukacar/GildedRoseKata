package com.example.gildedrose.service;

import com.example.gildedrose.item.Updateable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes={ItemRepository.class})
class ItemRepositoryTest {
    @Test
    void savesItemToRepositoryAndReturnsSavedItem() {
        ItemRepository itemRepository = new ItemRepository();
        SimpleItem simpleItem = new SimpleItem("simpleItem");
        assertThat(itemRepository.save(simpleItem), samePropertyValuesAs(simpleItem));
    }

    @Test
    void returnsAllItemsInRepository() {
        ItemRepository itemRepository = new ItemRepository();
        SimpleItem simpleItem = new SimpleItem("simpleItem");
        itemRepository.save(simpleItem);
        assertThat(itemRepository.findAll(), hasItem(simpleItem));
        assertThat(itemRepository.findAll(), hasSize(1));
    }

    @Test
    void updatesAllItems() {
        ItemRepository itemRepository = new ItemRepository();
        itemRepository.save(new BreadItem(3, 3));

        ArrayList<Updateable> updatedItem = new ArrayList<>();
        BreadItem updatedBreadItem = new BreadItem(1, 0);
        updatedItem.add(updatedBreadItem);

        itemRepository.update(updatedItem);
        BreadItem getUpdatedBread = (BreadItem) itemRepository.findAll().get(0);

        assertEquals(updatedBreadItem.quality, getUpdatedBread.quality);
        assertEquals(updatedBreadItem.sellIn, getUpdatedBread.sellIn);
    }

    private class SimpleItem implements Updateable {
        public String name;

        public SimpleItem(String name) {
            this.name = name;
        }
        @Override
        public void update() {
        }
    }

    private class BreadItem implements Updateable {
        public int sellIn;
        public int quality;

        public BreadItem(int sellIn, int quality) {
            this.sellIn = sellIn;
            this.quality = quality;
        }
        @Override
        public void update() {
            this.sellIn -= 1;
            this.quality -= 2;
        }
    }
}