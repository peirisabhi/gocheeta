package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.VehicleCategoryDto;

import java.util.List;

public interface VehicleCategoryService {

    List<VehicleCategoryDto> getVehicleCategories();

    VehicleCategoryDto getVehicleCategory(int id);

    VehicleCategoryDto saveVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    VehicleCategoryDto updateVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    VehicleCategoryDto removeVehicleCategory(int id);
}
