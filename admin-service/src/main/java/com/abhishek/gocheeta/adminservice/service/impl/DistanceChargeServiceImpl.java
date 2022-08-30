package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.dto.DistanceChargeDto;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableRequest;
import com.abhishek.gocheeta.adminservice.dto.datatable.DataTableResponse;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.DistanceChargeRepository;
import com.abhishek.gocheeta.adminservice.service.DistanceChargeService;
import com.abhishek.gocheeta.adminservice.util.DateUtil;
import com.abhishek.gocheeta.commons.model.DistanceCharge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.DISTANCE_CHARGE_NOT_FOUND;
import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.GENERAL_ERROR;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-10
 * Time: 16:36
 */
@Service
@Slf4j
public class DistanceChargeServiceImpl implements DistanceChargeService {

    @Autowired
    DistanceChargeRepository distanceChargeRepository;

    @Override
    public DistanceChargeDto saveDistanceCharge(DistanceChargeDto distanceChargeDto) {
        log.info(distanceChargeDto.toString());
        try {
            final DistanceCharge distanceCharge = distanceChargeDto.toEntity(DistanceCharge.class);
            distanceCharge.setLastUpdate(new Date());
            log.info(distanceCharge.toString());

            return distanceChargeRepository.save(distanceCharge)
                    .toDto(DistanceChargeDto.class);

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public DistanceChargeDto updateDistanceCharge(DistanceChargeDto distanceChargeDto) {

        final DistanceCharge distanceCharge = distanceChargeRepository.findById(distanceChargeDto.getId())
                .orElseThrow(() -> new DataNotFoundException(DISTANCE_CHARGE_NOT_FOUND));

        try {
            distanceCharge.setKmFrom(distanceChargeDto.getKmFrom());
            distanceCharge.setKmTo(distanceChargeDto.getKmTo());
            distanceCharge.setPrice(distanceChargeDto.getPrice());
            distanceCharge.setLastUpdate(new Date());

            return distanceChargeRepository.save(distanceCharge)
                    .toDto(DistanceChargeDto.class);

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }

    }

    @Override
    public DistanceChargeDto deleteDistanceCharge(int id) {

        final DistanceCharge distanceCharge = distanceChargeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(DISTANCE_CHARGE_NOT_FOUND));

        try {
            distanceChargeRepository.delete(distanceCharge);
            return distanceCharge.toDto(DistanceChargeDto.class);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getLocalizedMessage());
            throw new DataNotFoundException(DISTANCE_CHARGE_NOT_FOUND);
        }

    }

    @Override
    public List<DistanceChargeDto> getDistanceCharges() {
        return distanceChargeRepository.findAll().stream()
                .map((distanceCharge) -> {
                    final DistanceChargeDto distanceChargeDto = distanceCharge.toDto(DistanceChargeDto.class);
                    distanceChargeDto.setLastUpdate(DateUtil.getStringDateWith12Time(distanceCharge.getLastUpdate()));
                    return distanceChargeDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public DistanceChargeDto getDistanceCharge(int id) {
        final DistanceCharge distanceCharge = distanceChargeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(DISTANCE_CHARGE_NOT_FOUND));
        final DistanceChargeDto distanceChargeDto = distanceCharge.toDto(DistanceChargeDto.class);
        distanceChargeDto.setLastUpdate(DateUtil.getStringDateWith12Time(distanceCharge.getLastUpdate()));

        return distanceChargeDto;
    }

    @Override
    public DataTableResponse<DistanceChargeDto> getDistanceChargesForDataTable(DataTableRequest dataTableRequest) {
        final String value = dataTableRequest.getSearch().getValue();

        final List<DistanceChargeDto> distanceChargeDtoList = distanceChargeRepository.findAll()
                .stream()
                .filter(distanceCharge ->
                        String.valueOf(distanceCharge.getId()).startsWith(value)
                                || String.valueOf(distanceCharge.getKmFrom()).startsWith(value)
                                || String.valueOf(distanceCharge.getKmTo()).startsWith(value)
                                || String.valueOf(distanceCharge.getPrice()).startsWith(value))
                .map(distanceCharge -> {
                    final DistanceChargeDto distanceChargeDto = distanceCharge.toDto(DistanceChargeDto.class);
                    distanceChargeDto.setLastUpdate(DateUtil.getStringDateWith12Time(distanceCharge.getLastUpdate()));
                    return distanceChargeDto;
                }).collect(Collectors.toList());

        DataTableResponse<DistanceChargeDto> distanceChargeDtoDataTableResponse = new DataTableResponse<>();
        distanceChargeDtoDataTableResponse.setData(distanceChargeDtoList);
        distanceChargeDtoDataTableResponse.setDraw(dataTableRequest.getDraw());
        distanceChargeDtoDataTableResponse.setRecordsTotal(distanceChargeDtoList.size());
        distanceChargeDtoDataTableResponse.setRecordsFiltered(distanceChargeDtoList.size());

        return distanceChargeDtoDataTableResponse;
    }
}
