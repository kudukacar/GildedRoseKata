package com.example.gildedrose;

import com.example.gildedrose.item.*;
import com.example.gildedrose.service.ItemRepository;
import com.example.gildedrose.service.Validators;
import com.example.gildedrose.validator.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    CommandLineRunner loadValidators(Validators validators) {
        QualityValidator qualityValidator = new QualityValidator();
        return args -> {
            validators.add(new AgedBrieValidator(qualityValidator));
            validators.add(new NormalValidator(qualityValidator));
            validators.add(new ConjuredValidator(qualityValidator));
            validators.add(new BackstagePassesValidator(qualityValidator));
            validators.add(new SulfurasValidator());
        };
    }
}
