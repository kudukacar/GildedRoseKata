package com.example.gildedrose.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemUpdaterTest {
    @Mock
    ItemRepository itemRepository;

    @Test
    public void updatesTheItemRepository() {
        ItemUpdater itemUpdater = new ItemUpdater(itemRepository);
        itemUpdater.performUpdate();
    }
}
