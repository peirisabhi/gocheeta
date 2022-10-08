package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.DriverDto;
import com.abhishek.gocheeta.adminservice.dto.VehicleCategoryDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;
import com.abhishek.gocheeta.adminservice.service.impl.DriverServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-15
 * Time: 16:11
 */
@RestController
@RequestMapping(value = "/api/driver")
@Slf4j
@CrossOrigin
public class DriverController {

    @Autowired
    DriverServiceImpl driverService;

    @PostMapping()
    public ResponseEntity<DriverDto> saveDriver(DriverDto driverDto) {
        log.info(driverDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(driverService.saveDriver(driverDto));
    }

    @PutMapping()
    public ResponseEntity<DriverDto> updateDriver(DriverDto driverDto) {
        log.info(driverDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(driverService.updateDriver(driverDto));
    }


    @GetMapping
    public ResponseEntity<List<DriverDto>> getDrivers() {
        return ResponseEntity.ok(driverService.getDrivers());
    }


    @GetMapping("{driverId}")
    public ResponseEntity<DriverDto> getDriver(
            @PathVariable(value = "driverId") int driverId) {
        return ResponseEntity.ok(driverService.getDriver(driverId));
    }


    @DeleteMapping("{driverId}")
    public ResponseEntity<DriverDto> removeDriver(
            @PathVariable(value = "driverId") int driverId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(driverService.removeDriver(driverId));
    }


    @PostMapping("/data")
    public DataTableResponse<DriverDto> getDriversForDataTable(@RequestBody DataTableRequest dataTableRequest) {
        return driverService.getDriversForDataTable(dataTableRequest);
    }

}
