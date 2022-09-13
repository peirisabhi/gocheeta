package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.VehicleCategoryDto;
import com.abhishek.gocheeta.adminservice.dto.VehicleDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-13
 * Time: 21:13
 */
public interface VehicleService {

    List<VehicleDto> getVehicles();

    VehicleDto getVehicle(int id);

    VehicleDto saveVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    VehicleDto removeVehicle(int id);

    DataTableResponse<VehicleDto> getVehiclesForDataTable(DataTableRequest dataTableRequest);
}
