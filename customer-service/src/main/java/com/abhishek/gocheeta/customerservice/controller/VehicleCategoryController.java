package com.abhishek.gocheeta.customerservice.controller;

import com.abhishek.gocheeta.customerservice.dto.VehicleCategoryDto;
import com.abhishek.gocheeta.customerservice.service.VehicleCategoryService;
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


}
