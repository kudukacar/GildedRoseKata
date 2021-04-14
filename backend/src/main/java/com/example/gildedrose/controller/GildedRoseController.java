package com.example.gildedrose.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GildedRoseController {

    @GetMapping("/")
    public EntityModel<Introduction> welcomeUser() throws Exception {
        Introduction introduction = new Introduction(
            "Welcome to the Gilded Rose! Access the links to see the inventory, and to add an item to the inventory. See item types and proposed item properties.",
            Arrays.asList("AgedBrie", "BackstagePasses", "Conjured", "Normal", "Sulfuras"),
            Arrays.asList("itemType", "name", "sellIn", "quality"));

        return EntityModel.of(introduction,
            linkTo(methodOn(ItemController.class).getAllItems()).withRel("See inventory"),
            linkTo(methodOn(ItemController.class).addItem(null)).withRel("Add item"));
    }

    private class Introduction {
        public final String description;
        public final List<String> itemTypes;
        public final List<String> proposedItemProperties;

        public Introduction(String description, List<String> itemTypes, List<String> proposedItemProperties) {
            this.description = description;
            this.itemTypes = itemTypes;
            this.proposedItemProperties = proposedItemProperties;
        }
    }
}