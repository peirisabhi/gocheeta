package com.abhishek.gocheeta.customerservice.service;


import com.abhishek.gocheeta.customerservice.dto.VehicleCategoryDto;

import java.util.List;

public interface VehicleCategoryService {

    List<VehicleCategoryDto> getVehicleCategories();

    VehicleCategoryDto getVehicleCategory(int id);
}
