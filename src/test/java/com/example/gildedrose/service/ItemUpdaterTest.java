package com.example.gildedrose.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ItemUpdaterTest {
    @Mock
    ItemRepository itemRepository;

    @Test
    public void updatesTheItemRepository() {
        ItemUpdater itemUpdater = new ItemUpdater(itemRepository);
        itemUpdater.performUpdate();
        verify(itemRepository, times(1)).update(new ArrayList<>());
    }
}
