package com.abhishek.gocheeta.adminservice.controller;

import com.abhishek.gocheeta.adminservice.dto.DriverDto;
import com.abhishek.gocheeta.adminservice.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-31
 * Time: 13:53
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
@CrossOrigin
public class TestController {

    @PostMapping()
    public String saveDriver(TestDto testDto) {

        log.info(testDto.getFile().getName());
        log.info(String.valueOf(testDto.getFile().getSize()));
        log.info(testDto.getFile().getOriginalFilename());

        log.info(testDto.getName());

        return "okk";
    }

}
