package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.CustomerDto;
import com.abhishek.gocheeta.adminservice.dto.DriverDto;
import com.abhishek.gocheeta.adminservice.service.impl.DriverServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-15
 * Time: 16:11
 */
@RestController
@RequestMapping(value = "/driver")
@Slf4j
public class DriverController {

    @Autowired
    DriverServiceImpl driverService;

    @PostMapping()
    public ResponseEntity<DriverDto> saveDriver(DriverDto driverDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(driverService.saveDriver(driverDto));
    }

}
