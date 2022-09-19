package com.abhishek.gocheeta.customerservice.controller;

import com.abhishek.gocheeta.customerservice.dto.CityDto;
import com.abhishek.gocheeta.customerservice.dto.VehicleAvailabilityDto;
import com.abhishek.gocheeta.customerservice.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-18
 * Time: 11:50
 */
@RestController
@RequestMapping(value = "/vehicle")
@Slf4j
@CrossOrigin()
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("availability")
    public ResponseEntity<VehicleAvailabilityDto> checkVehicleAvailability(@RequestBody
                                                                           VehicleAvailabilityDto vehicleAvailabilityDto) {
        log.info(vehicleAvailabilityDto.toString());
        return ResponseEntity.ok(vehicleService.checkVehicleAvailability(vehicleAvailabilityDto));
    }

}
