package com.example.gildedrose;

import com.example.gildedrose.item.GildedRose;
import com.example.gildedrose.item.NormalItem;
import com.example.gildedrose.item.Updateable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

@SpringBootTest
@AutoConfigureMockMvc
class GildedRoseControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private GildedRoseService gildedRoseService;

    @Test
    void welcomesTheUser() throws Exception {
        mvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Gilded Rose")));
    }

    @Test
    void displaysTheInventory() throws Exception {
        when(gildedRoseService.getGildedRose()).thenReturn(new GildedRose(new ArrayList<Updateable>(Arrays.asList(new NormalItem("Normal", 0, 0)))));
        mvc.perform(get("/items")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"name\":\"Normal\",\"sellIn\":0,\"quality\":0}]")));
    }
}
