package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//By usind this annotation we can create a MockMvc and spring doesn't initiliaze all the beans at the program but only the necessary ones for testing.
@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

    //We need a MockMvc bean to make the request instead of postman. Because of that we create a bean here.
    @Autowired
    private MockMvc mvc;

    //The method we use here to test is not the preferred one. At the second method we use the preferred one.
    @Test
    void welcome_Test() throws Exception {

        // call /welcome endpoint
        // verify response is "welcome"

        //First we create a RequestBuilder object then with MockMvc object we perform it like Postman.By putting dots you can add your request other properties.
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request).andReturn();

        //Then we compare the result with the expected values here.
        assertEquals(200, result.getResponse().getStatus());
        assertEquals("welcome", result.getResponse().getContentAsString());

    }

    @Test
    void welcome_Test2() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        //Here after perform we directly compare the results with the expectations. This is the preferred way.
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();

    }

}
