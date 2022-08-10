package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.service.CityService;
import com.abhishek.gocheeta.commons.model.City;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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

    @PutMapping
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto){
        log.info(cityDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(cityService.updateCity(cityDto));
    }

    @DeleteMapping("{cityId}")
    public ResponseEntity<CityDto> removeCity(@PathVariable(value = "cityId") int cityId){
        log.info(String.valueOf(cityId));
        return ResponseEntity.status(HttpStatus.OK).body(cityService.removeCity(cityId));
    }

    @GetMapping("{cityId}")
    public ResponseEntity<CityDto> getCity(@PathVariable(value = "cityId") int cityId){
        return ResponseEntity.ok(cityService.getCity(cityId));
    }
}
