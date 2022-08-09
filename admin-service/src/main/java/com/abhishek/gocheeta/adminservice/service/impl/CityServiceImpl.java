package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.CityRepository;
import com.abhishek.gocheeta.adminservice.service.CityService;
import com.abhishek.gocheeta.commons.model.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.CITY_ALREADY_EXISTS;
import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.GENERAL_ERROR;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public CityDto saveCity(CityDto cityDto) {
        log.info(cityDto.toString());

        try{
            final City city = City.builder()
                    .city(cityDto.getCity())
                    .status(true)
                    .build();

            return cityRepository.save(city).toDto(CityDto.class);

        }catch (DataIntegrityViolationException e){
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(CITY_ALREADY_EXISTS);
        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }


    }
}
