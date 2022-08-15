package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.DriverDto;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.DriverRepository;
import com.abhishek.gocheeta.adminservice.service.DriverService;
import com.abhishek.gocheeta.adminservice.util.DateUtil;
import com.abhishek.gocheeta.commons.model.Driver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-13
 * Time: 15:49
 */
@Service
@Slf4j
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Override
    public DriverDto saveDriver(DriverDto driverDto) {
        try{
            final Driver driver = driverDto.toEntity(Driver.class);
            driver.setDob(DateUtil.getDate(driverDto.getDob()));
            driver.setRegisteredAt(new Date());

            return driverRepository.save(driver)
                    .toDto(DriverDto.class);

        } catch (ParseException e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException("Invalid Date Format");
        }
    }

    @Override
    public DriverDto updateDriver(DriverDto driverDto) {
        return null;
    }

    @Override
    public DriverDto removeDriver(int id) {
        return null;
    }

    @Override
    public List<DriverDto> getDrivers() {
        return null;
    }

    @Override
    public DriverDto getDriver(int id) {
        return null;
    }
}
