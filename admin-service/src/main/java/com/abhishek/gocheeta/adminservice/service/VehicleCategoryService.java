package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.dto.VehicleCategoryDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;

import java.util.List;

public interface VehicleCategoryService {

    List<VehicleCategoryDto> getVehicleCategories();

    VehicleCategoryDto getVehicleCategory(int id);

    VehicleCategoryDto saveVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    VehicleCategoryDto updateVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    VehicleCategoryDto removeVehicleCategory(int id);

    DataTableResponse<VehicleCategoryDto> getVehicleCategoriesForDataTable(DataTableRequest dataTableRequest);
}
