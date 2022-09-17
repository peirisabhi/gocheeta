package com.abhishek.gocheeta.customerservice.service;

import com.abhishek.gocheeta.customerservice.dto.VehicleAvailabilityDto;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-18
 * Time: 02:19
 */
public interface VehicleService {

    VehicleAvailabilityDto checkVehicleAvailability(VehicleAvailabilityDto vehicleAvailabilityDto);

}
