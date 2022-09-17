package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.customerservice.dto.VehicleAvailabilityDto;
import com.abhishek.gocheeta.customerservice.repository.CityRepository;
import com.abhishek.gocheeta.customerservice.repository.VehicleCategoryRepository;
import com.abhishek.gocheeta.customerservice.repository.VehicleRepository;
import com.abhishek.gocheeta.customerservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-18
 * Time: 02:24
 */
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleCategoryRepository vehicleCategoryRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public VehicleAvailabilityDto checkVehicleAvailability(VehicleAvailabilityDto vehicleAvailabilityDto) {
        return null;
    }
}
