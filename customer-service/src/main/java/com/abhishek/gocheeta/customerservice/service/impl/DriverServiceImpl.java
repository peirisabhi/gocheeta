package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.commons.model.Driver;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.repository.DriverRepository;
import com.abhishek.gocheeta.customerservice.service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.DRIVER_NOT_FOUND;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-29
 * Time: 23:27
 */
@Service
@Slf4j
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public Driver getDriver(int id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(DRIVER_NOT_FOUND));
    }
}
