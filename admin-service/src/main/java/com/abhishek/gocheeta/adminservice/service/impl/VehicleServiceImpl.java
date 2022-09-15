package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.DriverDto;
import com.abhishek.gocheeta.adminservice.dto.VehicleDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.VehicleRepository;
import com.abhishek.gocheeta.adminservice.service.CityService;
import com.abhishek.gocheeta.adminservice.service.DriverService;
import com.abhishek.gocheeta.adminservice.service.VehicleCategoryService;
import com.abhishek.gocheeta.adminservice.service.VehicleService;
import com.abhishek.gocheeta.adminservice.util.DateUtil;
import com.abhishek.gocheeta.commons.model.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.*;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-13
 * Time: 23:05
 */
@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    final
    VehicleRepository vehicleRepository;

    final
    DriverService driverService;

    final
    VehicleCategoryService vehicleCategoryService;

    final
    CityService cityService;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              DriverService driverService,
                              VehicleCategoryService vehicleCategoryService,
                              CityService cityService) {

        this.vehicleRepository = vehicleRepository;
        this.driverService = driverService;
        this.vehicleCategoryService = vehicleCategoryService;
        this.cityService = cityService;
    }

    @Override
    public List<VehicleDto> getVehicles() {
        try {
            return vehicleRepository.findAllByStatus(1)
                    .stream()
                    .map(vehicle -> {
                        final VehicleDto vehicleDto = vehicle.toDto(VehicleDto.class);
//                    vehicleDto.set
                        return vehicleDto;
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }


    }

    @Override
    public VehicleDto getVehicle(int id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(VEHICLE_NOT_FOUND))
                .toDto(VehicleDto.class);
    }

    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        try {
            final Vehicle vehicle = vehicleDto.toEntity(Vehicle.class);
            vehicle.setRegisteredAt(new Date());
            vehicle.setStatus(1);

            return vehicleRepository.save(vehicle)
                    .toDto(VehicleDto.class);

        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(VEHICLE_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {
        final Vehicle vehicle = vehicleRepository.findById(vehicleDto.getId())
                .orElseThrow(() -> new DataNotFoundException(VEHICLE_NOT_FOUND));

        try {
            vehicle.setVehicleCategoryId(vehicleDto.getVehicleCategoryId());
            vehicle.setVehicleMake(vehicleDto.getVehicleMake());
            vehicle.setVehicleModel(vehicleDto.getVehicleModel());
            vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
            vehicle.setMaxPassengers(vehicleDto.getMaxPassengers());
            vehicle.setDriverId(vehicleDto.getDriverId());

            return vehicleRepository.save(vehicle)
                    .toDto(VehicleDto.class);

        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(VEHICLE_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public VehicleDto removeVehicle(int id) {
        final Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(VEHICLE_NOT_FOUND));

        try {
            vehicle.setStatus(0);
            return vehicleRepository.save(vehicle)
                    .toDto(VehicleDto.class);

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public DataTableResponse<VehicleDto> getVehiclesForDataTable(DataTableRequest dataTableRequest) {
        final String value = dataTableRequest.getSearch().getValue();

        final List<VehicleDto> vehicleDtoList = vehicleRepository.findAllByStatus(1)
                .stream()
                .filter(vehicle -> String.valueOf(vehicle.getId()).startsWith(value)
                        || vehicle.getVehicleMake().toLowerCase().startsWith(value)
                        || vehicle.getVehicleModel().toLowerCase().startsWith(value)
                        || vehicle.getVehicleNumber().toLowerCase().startsWith(value)
                        || String.valueOf(vehicle.getMaxPassengers()).startsWith(value)
                        || vehicleCategoryService.getVehicleCategory(vehicle.getVehicleCategoryId())
                        .getCategory().toLowerCase().startsWith(value)
                        || driverService.getDriver(vehicle.getDriverId())
                        .getFname().toLowerCase().startsWith(value)
                        || driverService.getDriver(vehicle.getDriverId())
                        .getLname().toLowerCase().startsWith(value)
                        || cityService.getCity(vehicle.getCityId())
                        .getCity().toLowerCase().startsWith(value))

                .map(vehicle -> {
                    final VehicleDto vehicleDto = vehicle.toDto(VehicleDto.class);
                    vehicleDto.setRegisteredAt(DateUtil.getStringDateWith12Time(vehicle.getRegisteredAt()));
                    vehicleDto.setVehicleCategory(vehicleCategoryService.getVehicleCategory(vehicle
                            .getVehicleCategoryId()).getCategory());

                    final DriverDto driver = driverService.getDriver(vehicleDto.getDriverId());

                    vehicleDto.setDriver(driver.getFname().concat(" ").concat(driver.getLname()));
                    vehicleDto.setCity(cityService.getCity(vehicle.getCityId()).getCity());

                    return vehicleDto;
                })
                .collect(Collectors.toList());

        DataTableResponse<VehicleDto> vehicleDtoDataTableResponse = new DataTableResponse<>();
        vehicleDtoDataTableResponse.setData(vehicleDtoList);
        vehicleDtoDataTableResponse.setDraw(dataTableRequest.getDraw());
        vehicleDtoDataTableResponse.setRecordsTotal(vehicleDtoList.size());
        vehicleDtoDataTableResponse.setRecordsFiltered(vehicleDtoList.size());

        return vehicleDtoDataTableResponse;
    }
}
