package com.example.gildedrose.controller;

import com.example.gildedrose.item.ConjuredItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConjuredItemController.class)
class ConjuredItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemRepository itemRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void addsConjuredItemToRepository() throws Exception {
        Updateable item = new ConjuredTestItem("Conjured");
        byte[] itemJson = mapper.writeValueAsBytes(item);

        when(itemRepository.save(Mockito.any(ConjuredItem.class))).thenReturn(item);
        this.mockMvc.perform(post("/items/conjured").content(itemJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Conjured")));
    }

    private class ConjuredTestItem implements Updateable {

        public String name;

        public ConjuredTestItem(String name) { this.name = name; }
        @Override
        public void update() {

        }
    }
}