package com.example.gildedrose.service;

import com.example.gildedrose.item.Updateable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
        BreadItem breadItem = new BreadItem(3, 3);
        itemRepository.save(breadItem);
        itemRepository.update();
        assertEquals(1, breadItem.quality);
        assertEquals(2, breadItem.sellIn);
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