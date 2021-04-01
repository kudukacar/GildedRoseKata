package com.example.gildedrose;

import com.example.gildedrose.item.*;
import com.example.gildedrose.service.ItemRepository;
import com.example.gildedrose.validator.Validators;
import com.example.gildedrose.validator.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class, args); }

    @Bean
    CommandLineRunner loadDatabase(ItemRepository itemRepository) {
        return args -> {
            itemRepository.save(new NormalItem("Normal", 10, 10));
            itemRepository.save(new AgedBrieItem("AgedBrie", -1, 20));
            itemRepository.save(new SulfurasItem("Sulfuras", 0, 80));
            itemRepository.save(new ConjuredItem("Conjured", 10, 10));
            itemRepository.save(new BackstagePassesItem("BackstagePasses", 5, 25));
        };
    }

    @Bean
    Validators validators() {
        QualityValidator qualityValidator = new QualityValidator();
        return new Validators(Arrays.asList(
                new AgedBrieValidator(qualityValidator),
                new NormalValidator(qualityValidator),
                new ConjuredValidator(qualityValidator),
                new BackstagePassesValidator(qualityValidator),
                new SulfurasValidator()
        ));
    }
}
