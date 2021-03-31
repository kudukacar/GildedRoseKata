package com.example.gildedrose.controller;

import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import com.example.gildedrose.service.Validators;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private Validators validators;
    @MockBean private ItemRepository itemRepository;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getsAllItems() throws Exception {
        when(itemRepository.findAll()).thenReturn(new ArrayList<Updateable>(Arrays.asList(new NormalTestItem("Test"))));
        this.mockMvc.perform(get("/items")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test")));
    }

    @Test
    public void addsItem() throws Exception {
        NormalTestItem item = new NormalTestItem("Normal");
        ProposedItem proposedItem = new ProposedItem("Normal", "Normal", 0, 0);
        byte[] itemJson = mapper.writeValueAsBytes(proposedItem);

        when(itemRepository.save(validators.validate(proposedItem))).thenReturn(item);
        this.mockMvc.perform(post("/items").content(itemJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Normal")));
    }

    private class NormalTestItem implements Updateable {
        public String name;

        public NormalTestItem(String name) {
            this.name = name;
        }
        @Override
        public void update() {

        }
    }
}