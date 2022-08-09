package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.service.CityService;
import com.abhishek.gocheeta.commons.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/08/2022
 * Time: 2:06 pm
 */

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping()
    public ResponseEntity<CityDto> saveCity(@RequestBody CityDto cityDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.saveCity(cityDto));
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getCities(){
        return ResponseEntity.ok(cityService.getCities());
    }

}
