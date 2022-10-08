package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.VehicleDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;
import com.abhishek.gocheeta.adminservice.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-14
 * Time: 12:36
 */
@RestController
@RequestMapping(value = "/api/vehicle")
@Slf4j
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }


    @GetMapping("{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicle(
            @PathVariable(value = "vehicleId") int vehicleId) {
        return ResponseEntity.ok(vehicleService.getVehicle(vehicleId));
    }

    @PostMapping()
    public ResponseEntity<VehicleDto> saveVehicle(
            @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleService.saveVehicle(vehicleDto));
    }

    @PutMapping
    public ResponseEntity<VehicleDto> updateVehicle(
            @RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vehicleService.updateVehicle(vehicleDto));
    }

    @DeleteMapping("{vehicleId}")
    public ResponseEntity<VehicleDto> removeVehicle(
            @PathVariable(value = "vehicleId") int vehicleId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vehicleService.removeVehicle(vehicleId));
    }


    @PostMapping("/data")
    public DataTableResponse<VehicleDto> getVehiclesForDataTable(
            @RequestBody DataTableRequest dataTableRequest) {
        return vehicleService.getVehiclesForDataTable(dataTableRequest);
    }

}
