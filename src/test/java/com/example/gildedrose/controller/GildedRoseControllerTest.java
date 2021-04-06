package com.example.gildedrose.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GildedRoseControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private Environment environment;

    @Test
    void withUnauthorizedUserReturnsUnauthorizedStatus() throws Exception {
        mvc.perform(get("/")).andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void withAuthorizedUserReturnsWelcomeMessage() throws Exception {
        mvc.perform(get("/").with(httpBasic(environment.getProperty("USERNAME"), environment.getProperty("PASSWORD")))).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("/items")));
    }
}
