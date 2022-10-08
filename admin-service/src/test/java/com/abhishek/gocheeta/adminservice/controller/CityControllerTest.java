package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.service.CityService;
import com.abhishek.gocheeta.adminservice.service.impl.CityServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-19
 * Time: 23:07
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {

    @MockBean
    CityServiceImpl cityService;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void getUsers() throws Exception{

//        final List<CityDto> cityDtoList = new ArrayList<>();
//
//        CityDto cityDto = new CityDto(1, "Negombo");
//        CityDto cityDto1 = new CityDto(2, "Colombo");
//
//        cityDtoList.add(cityDto);
//        cityDtoList.add(cityDto1);
//
//
//        Mockito.when(cityService.getCities()).thenReturn(cityDtoList);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/city"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city", Matchers.is("Negombo")));

    }

}
