package com.cydeo.controller;

import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    //When testing controllers we must use @MockBean which is coming from Spring. Because the application context is up we must use directly beans. For the other parts we can use @Mock which is work with only objects but @MockBean is working with interfaces too like below.
    @MockBean
    StudentService studentService;

    @Test
    void getStudent_Test() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/student")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}"))
                .andDo(print())//write the test datas to the console inspite of the test succeed.
                .andReturn();

    }

    @Test
    void jsonAssert_Test() throws Exception {

        String expected = "{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}";
        //We retrieve the actual data as String here.
        String actual = mvc.perform(MockMvcRequestBuilders.get("/student")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        // expected -> {"firstName": "Mike", "lastName":  "Smith", "age": 20}
        // actual   -> {"firstName": "Mike", "lastName":  "Smith", "age": 20}

        //If we put false the third argument it did not look for exact match. For example if the expected consist by the actual but actual data have more datas in it, it again sacceed it.
        JSONAssert.assertEquals(expected, actual, false);

    }

    @Test
    void getStudents_Test() throws Exception {

        //The meaning of this is when this method want to executed by the method instead of this do not execute it and return these things.
        when(studentService.getStudents()).thenReturn(Arrays.asList(
                new StudentDTO("John", "Doe", 20),
                new StudentDTO("Tom", "Hanks", 50)
        ));         // Creating my stub (behavior for my mock object/StudentService obj)

        mvc.perform(MockMvcRequestBuilders.get("/students")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json("[{\"firstName\": \"John\", \"lastName\":  \"Doe\", \"age\": 20}" +
                                ", {\"firstName\": \"Tom\", \"lastName\":  \"Hanks\", \"age\": 50}]"))
                .andDo(print())
                .andReturn();

    }

}
