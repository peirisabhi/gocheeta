package com.abhishek.gocheeta.adminservice.service;

import com.abhishek.gocheeta.adminservice.dto.DriverDto;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 15:42
 */
public interface DriverService {

    DriverDto saveDriver(DriverDto driverDto);

    DriverDto updateDriver(DriverDto driverDto);

    DriverDto removeDriver(int id);

    List<DriverDto> getDrivers();

    DriverDto getDriver(int id);

}
