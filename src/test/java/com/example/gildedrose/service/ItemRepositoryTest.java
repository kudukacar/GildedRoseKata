package com.example.gildedrose.service;

import com.example.gildedrose.item.Updateable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
    private class SimpleItem implements Updateable {
        public String name;

        public SimpleItem(String name) {
            this.name = name;
        }
        @Override
        public void update() {
        }
    }
}