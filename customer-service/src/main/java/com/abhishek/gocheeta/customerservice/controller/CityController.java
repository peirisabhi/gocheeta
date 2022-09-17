package com.abhishek.gocheeta.customerservice.controller;

import com.abhishek.gocheeta.customerservice.dto.CityDto;
import com.abhishek.gocheeta.customerservice.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-17
 * Time: 23:13
 */
@RestController
@RequestMapping(value = "/city")
@Slf4j
@CrossOrigin()
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityDto>> getCities(){
        return ResponseEntity.ok(cityService.getCities());
    }


    @GetMapping("{cityId}")
    public ResponseEntity<CityDto> getCity(@PathVariable(value = "cityId") int cityId){
        return ResponseEntity.ok(cityService.getCity(cityId));
    }
}
