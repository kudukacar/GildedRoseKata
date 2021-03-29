package com.example.gildedrose.controller;

import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemRepository itemRepository;

    @Test
    public void getsAllItems() throws Exception {
        when(itemRepository.findAll()).thenReturn(new ArrayList<Updateable>(Arrays.asList(new TestItem("Test"))));
        this.mockMvc.perform(get("/items")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test")));
    }
    private class TestItem implements Updateable {
        public String name;

        public TestItem(String name) {
            this.name = name;
        }
        @Override
        public void update() {
        }
    }
}