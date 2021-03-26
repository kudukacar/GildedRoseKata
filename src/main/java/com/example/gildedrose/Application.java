package com.example.gildedrose;

import com.example.gildedrose.item.GildedRose;
import com.example.gildedrose.item.NormalItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static GildedRose gildedRose = new GildedRose(new ArrayList<>(Arrays.asList(new NormalItem("Normal", 0, 0))));

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
