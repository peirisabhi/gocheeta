package com.abhishek.gocheeta.customerservice.service.impl;

import com.abhishek.gocheeta.customerservice.dto.VehicleCategoryDto;
import com.abhishek.gocheeta.customerservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.customerservice.exception.GeneralException;
import com.abhishek.gocheeta.customerservice.repository.VehicleCategoryRepository;
import com.abhishek.gocheeta.customerservice.service.VehicleCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.GENERAL_ERROR;
import static com.abhishek.gocheeta.customerservice.constant.ErrorMessage.VEHICLE_CATEGORY_NOT_FOUND;


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


}
