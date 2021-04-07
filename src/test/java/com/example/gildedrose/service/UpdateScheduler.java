package com.example.gildedrose.service;

import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.*;

@SpringBootTest(properties = { "app.update.cron= */2 * * * * ?" })
class UpdateSchedulerTest {
    @SpyBean
    private UpdateScheduler updateScheduler;

    @Test
    public void performsAutomatedUpdates() {
        await()
            .atMost(Duration.FIVE_SECONDS)
            .untilAsserted(() -> verify(updateScheduler, atLeast(2)).scheduledUpdate());
    }
}
