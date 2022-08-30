package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.dto.VehicleCategoryDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;
import com.abhishek.gocheeta.adminservice.service.VehicleCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 09:38
 */

@RestController
@RequestMapping(value = "/vehicle-category")
@Slf4j
@CrossOrigin
public class VehicleCategoryController {

    @Autowired
    VehicleCategoryService vehicleCategoryService;

    @GetMapping
    public ResponseEntity<List<VehicleCategoryDto>> getVehicleCategories() {
        return ResponseEntity.ok(vehicleCategoryService.getVehicleCategories());
    }


    @GetMapping("{vehicleCategoryId}")
    public ResponseEntity<VehicleCategoryDto> getVehicleCategory(
            @PathVariable(value = "vehicleCategoryId") int vehicleCategoryId) {
        return ResponseEntity.ok(vehicleCategoryService.getVehicleCategory(vehicleCategoryId));
    }

    @PostMapping()
    public ResponseEntity<VehicleCategoryDto> saveVehicleCategory(
            @RequestBody VehicleCategoryDto vehicleCategoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleCategoryService.saveVehicleCategory(vehicleCategoryDto));
    }

    @PutMapping
    public ResponseEntity<VehicleCategoryDto> updateVehicleCategory(
            @RequestBody VehicleCategoryDto vehicleCategoryDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vehicleCategoryService.updateVehicleCategory(vehicleCategoryDto));
    }

    @DeleteMapping("{vehicleCategoryId}")
    public ResponseEntity<VehicleCategoryDto> removeVehicleCategory(
            @PathVariable(value = "vehicleCategoryId") int vehicleCategoryId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vehicleCategoryService.removeVehicleCategory(vehicleCategoryId));
    }


    @PostMapping("/data")
    public DataTableResponse<VehicleCategoryDto> getVehicleCategoriesForDataTable(
            @RequestBody DataTableRequest dataTableRequest) {
        return vehicleCategoryService.getVehicleCategoriesForDataTable(dataTableRequest);
    }
}
