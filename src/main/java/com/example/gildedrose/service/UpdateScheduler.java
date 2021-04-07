package com.example.gildedrose.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class UpdateScheduler {
    @Autowired
    ItemUpdater itemUpdater;

    @Scheduled(cron = "${app.update.cron}")
    public void scheduledUpdate() {
        itemUpdater.performUpdate();
    }
}
