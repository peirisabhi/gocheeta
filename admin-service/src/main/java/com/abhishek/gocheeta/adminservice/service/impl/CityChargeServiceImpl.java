package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.CityChargeDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.CityChargeRepository;
import com.abhishek.gocheeta.adminservice.service.CityChargeService;
import com.abhishek.gocheeta.adminservice.service.CityService;
import com.abhishek.gocheeta.commons.model.CityCharge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.CITY_CHARGE_NOT_FOUND;
import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.GENERAL_ERROR;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-09-13
 * Time: 14:47
 */
@Service
@Slf4j
public class CityChargeServiceImpl implements CityChargeService {

    @Autowired
    CityChargeRepository cityChargeRepository;

    @Autowired
    CityService cityService;

    @Override
    public CityChargeDto saveCityCharge(CityChargeDto cityChargeDto) {
        log.info(cityChargeDto.toString());
        try {
            final CityCharge cityCharge = cityChargeDto.toEntity(CityCharge.class);
            log.info(cityCharge.toString());

            return cityChargeRepository.save(cityCharge)
                    .toDto(CityChargeDto.class);

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public CityChargeDto updateCityCharge(CityChargeDto cityChargeDto) {

        final CityCharge cityCharge = cityChargeRepository.findById(cityChargeDto.getId())
                .orElseThrow(() -> new DataNotFoundException(CITY_CHARGE_NOT_FOUND));

        try {
            cityCharge.setCityTo(cityChargeDto.getCityTo());
            cityCharge.setCityFrom(cityChargeDto.getCityFrom());
            cityCharge.setKm(cityChargeDto.getKm());

            return cityChargeRepository.save(cityCharge)
                    .toDto(CityChargeDto.class);

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public CityChargeDto deleteCityCharge(int id) {
        final CityCharge cityCharge = cityChargeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CITY_CHARGE_NOT_FOUND));

        try {
            cityChargeRepository.delete(cityCharge);
            return cityCharge.toDto(CityChargeDto.class);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getLocalizedMessage());
            throw new DataNotFoundException(CITY_CHARGE_NOT_FOUND);
        }

    }

    @Override
    public List<CityChargeDto> getCityCharges() {
        return cityChargeRepository.findAll().stream()
                .map((cityCharge) -> cityCharge.toDto(CityChargeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CityChargeDto getCityCharge(int id) {
        return cityChargeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CITY_CHARGE_NOT_FOUND))
                .toDto(CityChargeDto.class);
    }

    @Override
    public DataTableResponse<CityChargeDto> getCityChargesForDataTable(DataTableRequest dataTableRequest) {
        final String value = dataTableRequest.getSearch().getValue();

        final List<CityChargeDto> cityChargeDtoList = cityChargeRepository.findAll()
                .stream()
                .filter(cityCharge ->
                        String.valueOf(cityCharge.getId()).startsWith(value)
                                || String.valueOf(cityCharge.getPrice()).startsWith(value)
                                || String.valueOf(cityCharge.getKm()).startsWith(value)
                                || cityService.getCity(cityCharge.getCityTo()).getCity()
                                .toLowerCase().startsWith(value)
                                || cityService.getCity(cityCharge.getCityFrom()).getCity()
                                .toLowerCase().startsWith(value))
                .map(cityCharge -> {
                    final CityChargeDto cityChargeDto = cityCharge.toDto(CityChargeDto.class);
                    cityChargeDto.setCityToVal(cityService.getCity(cityCharge.getCityTo()).getCity());
                    cityChargeDto.setCityFromVal(cityService.getCity(cityCharge.getCityFrom()).getCity());
                    return cityChargeDto;
                }).collect(Collectors.toList());

        DataTableResponse<CityChargeDto> cityChargeDtoDataTableResponse = new DataTableResponse<>();
        cityChargeDtoDataTableResponse.setData(cityChargeDtoList);
        cityChargeDtoDataTableResponse.setDraw(dataTableRequest.getDraw());
        cityChargeDtoDataTableResponse.setRecordsTotal(cityChargeDtoList.size());
        cityChargeDtoDataTableResponse.setRecordsFiltered(cityChargeDtoList.size());

        return cityChargeDtoDataTableResponse;
    }
}
