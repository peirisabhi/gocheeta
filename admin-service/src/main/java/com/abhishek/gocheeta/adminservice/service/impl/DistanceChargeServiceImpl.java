package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.DistanceChargeDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.DistanceChargeRepository;
import com.abhishek.gocheeta.adminservice.service.DistanceChargeService;
import com.abhishek.gocheeta.commons.model.DistanceCharge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.*;

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
            distanceCharge.setKmTo(distanceCharge.getKmTo());
            distanceCharge.setPrice(distanceChargeDto.getPrice());
            distanceCharge.setLastUpdate(new Date());

            return distanceChargeRepository.save(distanceCharge)
                    .toDto(DistanceChargeDto.class);

        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }

    }

    @Override
    public DistanceChargeDto deleteDistanceCharge(int id) {

        final DistanceCharge distanceCharge = distanceChargeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(DISTANCE_CHARGE_NOT_FOUND));

//       try {
//          return distanceChargeRepository.delete(distanceCharge).toDto(DistanceChargeDto.class);
//       }

        return null;
    }

    @Override
    public List<DistanceChargeDto> getDistanceCharges() {
        return null;
    }

    @Override
    public DistanceChargeDto getDistanceCharge(int id) {
        return null;
    }
}
