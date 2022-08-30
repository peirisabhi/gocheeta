package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.DistanceChargeDto;
import com.abhishek.gocheeta.adminservice.service.DistanceChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 11:08
 */

@RestController
@RequestMapping(value = "/distance-charge")
@Slf4j
@CrossOrigin
public class DistanceChargeController {

    @Autowired
    DistanceChargeService distanceChargeService;

    @PostMapping()
    public ResponseEntity<DistanceChargeDto> saveDistanceCharge(
            @RequestBody DistanceChargeDto distanceChargeDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(distanceChargeService.saveDistanceCharge(distanceChargeDto));
    }


    @PutMapping
    public ResponseEntity<DistanceChargeDto> updateDistanceCharge(
            @RequestBody DistanceChargeDto distanceChargeDto){
        log.info(distanceChargeDto.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .body(distanceChargeService.updateDistanceCharge(distanceChargeDto));
    }


    @DeleteMapping("{distanceChargeId}")
    public ResponseEntity<DistanceChargeDto> deleteDistanceCharge(
            @PathVariable(value = "distanceChargeId") int distanceChargeId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(distanceChargeService.deleteDistanceCharge(distanceChargeId));
    }


    @GetMapping
    public ResponseEntity<List<DistanceChargeDto>> getDistanceCharges(){
        return ResponseEntity.ok(distanceChargeService.getDistanceCharges());
    }


    @GetMapping("{distanceChargeId}")
    public ResponseEntity<DistanceChargeDto> getCity(
            @PathVariable(value = "distanceChargeId") int distanceChargeId){
        return ResponseEntity.ok(distanceChargeService.getDistanceCharge(distanceChargeId));
    }

}
