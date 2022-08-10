package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.VehicleCategoryDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.VehicleCategoryRepository;
import com.abhishek.gocheeta.adminservice.service.VehicleCategoryService;
import com.abhishek.gocheeta.commons.model.VehicleCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.*;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 09:22
 */
@Service
@Slf4j
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    @Autowired
    VehicleCategoryRepository vehicleCategoryRepository;

    @Override
    public List<VehicleCategoryDto> getVehicleCategories() {
        try {
            return vehicleCategoryRepository.findAllByStatus(true)
                    .stream().map(vehicleCategory -> vehicleCategory.toDto(VehicleCategoryDto.class))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public VehicleCategoryDto getVehicleCategory(int id) {
        return vehicleCategoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(VEHICLE_CATEGORY_NOT_FOUND))
                .toDto(VehicleCategoryDto.class);
    }

    @Override
    public VehicleCategoryDto saveVehicleCategory(VehicleCategoryDto vehicleCategoryDto) {
        log.info(vehicleCategoryDto.toString());
        try {
            final VehicleCategory vehicleCategory = VehicleCategory.builder()
                    .category(vehicleCategoryDto.getCategory())
                    .status(true)
                    .build();
            return vehicleCategoryRepository.save(vehicleCategory)
                    .toDto(VehicleCategoryDto.class);

        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(VEHICLE_CATEGORY_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }

    }

    @Override
    public VehicleCategoryDto updateVehicleCategory(VehicleCategoryDto vehicleCategoryDto) {

        final VehicleCategory vehicleCategory = vehicleCategoryRepository.findById(vehicleCategoryDto.getId())
                .orElseThrow(() -> new DataNotFoundException(VEHICLE_CATEGORY_NOT_FOUND));

        try {
            vehicleCategory.setCategory(vehicleCategoryDto.getCategory());
            return vehicleCategoryRepository.save(vehicleCategory)
                    .toDto(VehicleCategoryDto.class);

        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(VEHICLE_CATEGORY_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public VehicleCategoryDto removeVehicleCategory(int id) {
        final VehicleCategory vehicleCategory = vehicleCategoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(VEHICLE_CATEGORY_NOT_FOUND));

        try {
            vehicleCategory.setStatus(false);
            return vehicleCategoryRepository.save(vehicleCategory)
                    .toDto(VehicleCategoryDto.class);

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }
}
