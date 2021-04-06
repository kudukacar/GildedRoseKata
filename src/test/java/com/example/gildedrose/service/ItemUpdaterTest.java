package com.example.gildedrose.service;

import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.*;

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

    @SpyBean
    private ItemUpdater itemUpdater;

    @Test
    public void updatesTheRepositoryWhenScheduled() {
        await()
                .atMost(Duration.ONE_SECOND)
                .untilAsserted(() -> verify(itemUpdater, atLeast(1)).performUpdate());
    }
}
