package com.example.gildedrose;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class GildedRoseControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void welcomesTheUser() throws Exception {
        mvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Gilded Rose")));
    }

    @Test
    void displaysTheInventory() throws Exception {
        mvc.perform(get("/items")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"name\":\"Normal\",\"sellIn\":0,\"quality\":0}]")));
    }
}
