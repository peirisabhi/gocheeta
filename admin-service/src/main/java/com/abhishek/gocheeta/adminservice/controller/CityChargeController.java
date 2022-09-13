package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.CityChargeDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;
import com.abhishek.gocheeta.adminservice.service.CityChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-13
 * Time: 17:59
 */
@RestController
@RequestMapping(value = "/city-charge")
@Slf4j
@CrossOrigin
public class CityChargeController {

    @Autowired
    CityChargeService cityChargeService;


    @PostMapping()
    public ResponseEntity<CityChargeDto> saveCityCharge(
            @RequestBody CityChargeDto cityChargeDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cityChargeService.saveCityCharge(cityChargeDto));
    }


    @PutMapping
    public ResponseEntity<CityChargeDto> updateCityCharge(
            @RequestBody CityChargeDto cityChargeDto){
        log.info(cityChargeDto.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(cityChargeService.updateCityCharge(cityChargeDto));
    }


    @DeleteMapping("{cityChargeId}")
    public ResponseEntity<CityChargeDto> deleteCityChargeDto(
            @PathVariable(value = "cityChargeId") int cityChargeId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cityChargeService.deleteCityCharge(cityChargeId));
    }


    @GetMapping
    public ResponseEntity<List<CityChargeDto>> getCityCharges(){
        return ResponseEntity.ok(cityChargeService.getCityCharges());
    }


    @GetMapping("{cityChargeId}")
    public ResponseEntity<CityChargeDto> getCityCharge(
            @PathVariable(value = "cityChargeId") int cityChargeId){
        return ResponseEntity.ok(cityChargeService.getCityCharge(cityChargeId));
    }


    @PostMapping("/data")
    public DataTableResponse<CityChargeDto> getCityChargesForDataTable(
            @RequestBody DataTableRequest dataTableRequest) {
        return cityChargeService.getCityChargesForDataTable(dataTableRequest);
    }
}
