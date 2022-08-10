package com.abhishek.gocheeta.adminservice.service.impl;

import com.abhishek.gocheeta.adminservice.dto.CityDto;
import com.abhishek.gocheeta.adminservice.exception.DataNotFoundException;
import com.abhishek.gocheeta.adminservice.exception.DuplicateDataFoundException;
import com.abhishek.gocheeta.adminservice.exception.GeneralException;
import com.abhishek.gocheeta.adminservice.repository.CityRepository;
import com.abhishek.gocheeta.adminservice.service.CityService;
import com.abhishek.gocheeta.commons.model.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhishek.gocheeta.adminservice.constant.ErrorMessage.*;

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

    @Override
    public List<CityDto> getCities() {

        try {
           return cityRepository.findAllByStatus(true)
                    .stream()
                    .map(city -> city.toDto(CityDto.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }

    }

    @Override
    public CityDto updateCity(CityDto cityDto) {

        City city = cityRepository.findById(cityDto.getId())
                .orElseThrow(() -> new DataNotFoundException(CITY_NOT_FOUND));

        try{
             city.setCity(cityDto.getCity());

            return cityRepository.save(city).toDto(CityDto.class);

        }catch (DataIntegrityViolationException e){
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(CITY_ALREADY_EXISTS);
        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public CityDto removeCity(int id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CITY_NOT_FOUND));

        try{
            city.setStatus(false);
            return cityRepository.save(city).toDto(CityDto.class);

        }catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public CityDto getCity(int id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(CITY_NOT_FOUND))
                .toDto(CityDto.class);
    }
}
