package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.DriverDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.FileManageException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.DriverRepository;
import com.abhishek.gocheeta.adminservice.service.DriverService;
import com.abhishek.gocheeta.adminservice.util.DateUtil;
import com.abhishek.gocheeta.commons.model.Driver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.abhishek.gocheeta.adminservice.config.Config.UPLOAD_URL;
import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.*;
import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.GENERAL_ERROR;

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
            String nicFront = new Date().getTime() + "_nic_front_" + UUID.randomUUID().toString()
                    .concat(".")
                    .concat(FilenameUtils.getExtension(driverDto.getNicFront().getOriginalFilename()));
            String nicBack = new Date().getTime() + "_nic_back_" + UUID.randomUUID().toString()
                    .concat(".")
                    .concat(FilenameUtils.getExtension(driverDto.getNicBack().getOriginalFilename()));

            String drivingLicenceFront = new Date().getTime() + "_driving_licence_front" + UUID.randomUUID().toString()
                    .concat(".")
                    .concat(FilenameUtils.getExtension(driverDto.getDrivingLicenceFront().getOriginalFilename()));
            String drivingLicenceBack = new Date().getTime() + "_driving_licence_back" + UUID.randomUUID().toString()
                    .concat(".")
                    .concat(FilenameUtils.getExtension(driverDto.getDrivingLicenceBack().getOriginalFilename()));

            Path nicFrontSavePath = Paths.get(UPLOAD_URL + "images/nic/", nicFront);
            Path nicBackSavePath = Paths.get(UPLOAD_URL + "images/nic/", nicBack);
            Path drivingLicenceFrontSavePath = Paths
                    .get(UPLOAD_URL + "images/driving_licence/", drivingLicenceFront);
            Path drivingLicenceBackSavePath = Paths
                    .get(UPLOAD_URL + "images/driving_licence/", drivingLicenceBack);

            try {
                Files.write(nicFrontSavePath, driverDto.getNicFront().getBytes());
                log.info("nic front image saved");
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new FileManageException("nic front image saving error");
            }
            try {
                Files.write(nicBackSavePath, driverDto.getNicBack().getBytes());
                log.info("nic front image saved");
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new FileManageException("nic front image saving error");
            }
            try {
                Files.write(drivingLicenceFrontSavePath, driverDto.getDrivingLicenceFront().getBytes());
                log.info("nic front image saved");
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new FileManageException("nic front image saving error");
            }
            try {
                Files.write(drivingLicenceBackSavePath, driverDto.getDrivingLicenceBack().getBytes());
                log.info("nic front image saved");
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new FileManageException("nic front image saving error");
            }

            final Driver driver = driverDto.toEntity(Driver.class);
            driver.setDob(DateUtil.getDate(driverDto.getDob()));
            driver.setRegisteredAt(new Date());
            driver.setNicFront(nicFront);
            driver.setNicBack(nicBack);
            driver.setDrivingLicenceFront(drivingLicenceFront);
            driver.setDrivingLicenceBack(drivingLicenceBack);
            driver.setStatus(1);

            return driverRepository.save(driver)
                    .toDto(DriverDto.class);

        } catch (ParseException e) {
            e.printStackTrace();
            log.error(e.getLocalizedMessage());
            throw new GeneralException("Invalid Date Format");
        }catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(DRIVER_ALREADY_EXISTS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public DriverDto updateDriver(DriverDto driverDto) {

        final Driver driver = driverRepository.findById(driverDto.getId())
                .orElseThrow(() -> new DataNotFoundException(DRIVER_NOT_FOUND));

        try{
            driver.setDob(DateUtil.getDate(driverDto.getDob()));
            driver.setContact1(driverDto.getContact1());
            driver.setContact2(driverDto.getContact2());
            driver.setEmail(driverDto.getFname());
            driver.setFname(driverDto.getFname());
            driver.setLname(driverDto.getLname());
            driver.setGender(driverDto.getGender());
            driver.setLicenceTypeId(driverDto.getLicenceTypeId());
            driver.setNic(driverDto.getNic());


            return driverRepository.save(driver)
                    .toDto(DriverDto.class);

        } catch (ParseException e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException("Invalid Date Format");
        }catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(DRIVER_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
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