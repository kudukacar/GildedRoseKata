package com.example.gildedrose.controller;

import com.example.gildedrose.item.ProposedItem;
import com.example.gildedrose.item.Updateable;
import com.example.gildedrose.service.ItemRepository;
import com.example.gildedrose.validator.Validators;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private Environment environment;
    @MockBean private ItemRepository itemRepository;
    @MockBean private Validators validators;
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getsAllItemsWithAuthorizedUser() throws Exception {
        when(itemRepository.findAll()).thenReturn(new ArrayList<Updateable>(Arrays.asList(new NormalTestItem("Test"))));
        this.mockMvc.perform(get("/items").with(httpBasic(environment.getProperty("USERNAME"), environment.getProperty("PASSWORD")))).andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Test")));
    }

    @Test
    public void returnsUnauthorizedStatusWithUnauthorizedUserForGetRequest() throws Exception {
        this.mockMvc.perform(get("/items")).andDo(print())
            .andExpect(status().isUnauthorized());
    }

    @Test
    public void addsValidItemWithAuthorizedUser() throws Exception {
        NormalTestItem item = new NormalTestItem("Normal");
        ProposedItem proposedItem = new ProposedItem("Normal", "Normal", 0, 0);
        byte[] itemJson = mapper.writeValueAsBytes(proposedItem);

        when(validators.validate(Mockito.any(ProposedItem.class))).thenReturn(item);
        when(itemRepository.save(Mockito.any(Updateable.class))).thenReturn(item);
        this.mockMvc.perform(post("/items").content(itemJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).with(httpBasic(environment.getProperty("USERNAME"), environment.getProperty("PASSWORD"))))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Normal")));
    }

    @Test
    public void returnsUnauthorizedStatusWithUnauthorizedUserForPostRequest() throws Exception {
        ProposedItem proposedItem = new ProposedItem("Normal", "Normal", 0, 0);
        byte[] itemJson = mapper.writeValueAsBytes(proposedItem);

        this.mockMvc.perform(post("/items").content(itemJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isUnauthorized());
    }

    @Test
    public void returnsBadRequestWhenInvalidItem() throws Exception {
        ProposedItem proposedItem = new ProposedItem("Normal", "Normal", 0, 0);
        byte[] itemJson = mapper.writeValueAsBytes(proposedItem);

        when(validators.validate(Mockito.any(ProposedItem.class))).thenReturn(null);
        this.mockMvc.perform(post("/items").content(itemJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).with(httpBasic(environment.getProperty("USERNAME"), environment.getProperty("PASSWORD"))))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(content().string(containsString("Incorrect")));
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
