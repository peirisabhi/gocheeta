package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.UserDto;
import com.abhishek.gocheeta.adminservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-19
 * Time: 22:28
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void saveUser() throws Exception{

        final UserDto userDto = new UserDto("abhi", "danu", "abhi@gmail.com", "male", "123456789012", 1, 1);


//        final UserDto userDto = new User(1, "abhi", "danu", "abhi@gmail.com", "male", "123456789012", new Date(), 1, 1, 1).toDto(UserDto.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String reqJson = objectWriter.writeValueAsString(userDto);

        Mockito.when(userService.saveUser(Mockito.any(UserDto.class))).thenReturn(userDto);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user")
                .accept(MediaType.APPLICATION_JSON)
                .content(reqJson).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }

//    @Test
    public void getUsers() throws Exception{
        final UserDto userDto = new UserDto("abhi", "danu", "abhi@gmail.com", "male", "123456789012", 1, 1);

        Mockito.when(userService.getUser(1)).thenReturn(userDto);

        mockMvc.perform(get("/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[1].fname", Matchers.is("abhi")));

    }

}
